# Step 1: Use a base image with JDK
FROM openjdk:17-jdk-slim as build

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the local application jar to the container
COPY target/habits-tracker-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port the app will run on
EXPOSE 8080

# Step 5: Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
