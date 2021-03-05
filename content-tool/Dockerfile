FROM openjdk:12

WORKDIR /app
COPY ./target/*.jar /app
COPY ./frontend/build /app/static

ENTRYPOINT ["java", "-jar", "yama-frontend-0.0.1-SNAPSHOT.jar"]