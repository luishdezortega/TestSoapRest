FROM openjdk:11.0-jdk
EXPOSE 8081
ADD target/spring-boot-web-0.0.1-SNAPSHOT.jar spring-boot-web.jar
ENTRYPOINT ["java","-jar","/spring-boot-web.jar"]