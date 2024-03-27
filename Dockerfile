# Use a base image with Java 11 and Maven pre-installed
FROM adoptopenjdk/maven-openjdk11 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project's pom.xml and resolve the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code to the container
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Create a new image with a smaller footprint for runtime
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/mill-creek-hoa-backend-0.0.1-SNAPSHOT.jar .

# Set any desired environment variables
ENV VARIABLE_NAME=value

# Specify the default command to run when the container starts
CMD ["java", "-jar", "mill-creek-hoa-backend-0.0.1-SNAPSHOT.jar"]
