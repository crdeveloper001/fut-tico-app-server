# Use Maven image to build the JAR
FROM maven:3.9.9-amazoncorretto-17 AS build
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the project files
COPY src ./src

# Build the project and create the JAR file
RUN mvn clean package -DskipTests

# Use the OpenJDK image to create the final image
FROM openjdk:17
VOLUME /tmp
EXPOSE 4500

# Copy the JAR file from the build stage
COPY --from=build /app/target/fut-tico-app-server-0.0.1-SNAPSHOT.jar /app/app.jar

# Run the application with optimized JVM options
ENTRYPOINT ["java","-XX:+UseContainerSupport","-XX:MaxRAMPercentage=75.0","-jar","/app/app.jar"]
