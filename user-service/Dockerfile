FROM gradle:8.12.1-jdk21 AS build
WORKDIR /app
COPY . .  

RUN gradle clean build --no-daemon

FROM openjdk:21
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]