FROM openjdk:17-jdk-alpine

WORKDIR /app

RUN apk add --no-cache maven

COPY src /app

RUN mvn clean install -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "./target/projectManagment-0.0.1.jar"]