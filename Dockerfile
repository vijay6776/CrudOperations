FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/spring-boot-app.jar /app/

EXPOSE 8080

ENTRYPOINT [ "java","-jar","spring-boot-app.jar"]

