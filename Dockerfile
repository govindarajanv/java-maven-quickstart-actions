FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn -B package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /usr/app
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
COPY --from=build /build/target/*.jar app.jar
ENV PORT=8080
ENV JAVA_OPTS=""
EXPOSE 8080
LABEL org.opencontainers.image.title="java-maven-quickstart-service" \
      org.opencontainers.image.description="A simple calculator web service" \
      org.opencontainers.image.source="https://github.com/govindarajanv/java-maven-quickstart-actions"
HEALTHCHECK --interval=30s --timeout=5s --retries=3 \
  CMD curl -s --fail http://localhost:${PORT}/actuator/health | grep -q "UP" || exit 1
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
