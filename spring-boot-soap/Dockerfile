FROM openjdk:11.0-jdk
EXPOSE 8080
ADD target/spring-boot-soap-0.0.1-SNAPSHOT.jar spring-boot-soap.jar
ENTRYPOINT ["java","-jar","soap.jar","/spring-boot-soap.jar"]