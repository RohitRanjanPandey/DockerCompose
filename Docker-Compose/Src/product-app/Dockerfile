#Enter all the required tools like java, mysql, redis etc inside Dockerfile
FROM openjdk:8
ADD target/productservice.jar productservice.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "productservice.jar"]