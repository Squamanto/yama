FROM openjdk:12

WORKDIR /app
COPY ./target/*.jar /app

ENTRYPOINT ["java", "-jar", "yama-0.0.1-SNAPSHOT.jar"]