# Start with a base image containing Java runtime
FROM openjdk:latest
EXPOSE 8080
WORKDIR /app
COPY target/CountryAppProject-1.0-SNAPSHOT.jar target/CountryAppProject-1.0-SNAPSHOT.jar
# Run the jar file
CMD ["java","-jar","target/CountryAppProject-1.0-SNAPSHOT.jar"]