FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/springboot-ebook-app-image.jar springboot-ebook-app-image.jar
ENTRYPOINT ["java","-jar","/springboot-ebook-app-image.jar"]