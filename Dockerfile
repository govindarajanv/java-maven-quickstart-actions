FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn -B package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /usr/app
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
COPY --from=build /build/target/*.jar app.jar
ENV PORT=8080
CMD ["java", "-jar", "app.jar"]
HEALTHCHECK CMD curl -s --fail http://localhost:${PORT}/addition/1/2/3 || exit 1
