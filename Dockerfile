FROM adoptopenjdk/openjdk11

WORKDIR /usr/app

COPY target/*.jar app.jar

CMD java -jar app.jar
HEALTHCHECK CMD curl -s --fail http://localhost:$$PORT/addition/1/2/3 || exit 1
