FROM openjdk:8-jdk-alpine

COPY ./build/libs/gs-spring-boot-docker-0.1.0.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]