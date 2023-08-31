#Enter all the required tools like java, mysql, redis etc inside Dockerfile
FROM openjdk:8
ADD target/orderservice.jar orderservice.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "orderservice.jar"]