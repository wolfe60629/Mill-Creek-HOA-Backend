# -------------------------- Build stage ---------------------------------------------
FROM maven:3.8.3-openjdk-17 as build

# Set the working directory inside the container
WORKDIR /app

# Copy the project's pom.xml and resolve the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code to the container
COPY src ./src

# Build the application
RUN mvn package -DskipTests


# -------------------------- Run stage ---------------------------------------------
# Create a new image with a smaller footprint for runtime
FROM openjdk:17-oracle

# Set the working directory inside the container
WORKDIR /app

# Copy the keystore folder to the container
COPY keystore /app/keystore

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/mill-creek-hoa-backend-0.0.1-SNAPSHOT.jar .

# Specify the default command to run when the container starts
CMD ["java", "-jar", "mill-creek-hoa-backend-0.0.1-SNAPSHOT.jar"]
