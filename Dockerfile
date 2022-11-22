FROM openjdk:8
EXPOSE 8080
ADD target/springboot-ebook-app-image.jar springboot-ebook-app-image.jar
ENTRYPOINT ["java", "-jar", "/springboot-ebook-app-image.jar"]