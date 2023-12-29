FROM openjdk:19
WORKDIR /app
COPY target/Product_Microservice-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "Product_Microservice-0.0.1-SNAPSHOT.jar"]