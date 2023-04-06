FROM openjdk:17-jdk-alpine
RUN mkdir -p /app
COPY target/PasswordManager-1.0.0.jar /app
WORKDIR /app
EXPOSE 8090
CMD ["java", "-jar",  "PasswordManager-1.0.0.jar"]

