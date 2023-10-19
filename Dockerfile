#JDK version
FROM openjdk:17

# address of the project's JAR file in the image
ARG JAR_FILE=target/*.jar

# JAR file name in the image
COPY ${JAR_FILE} application.jar

#Linux update
CMD apt-get update-y

# internal port where the project will run
EXPOSE 8080

# runs the JAR file in the project for the container
ENTRYPOINT ["java", "-jar", "application.jar"]


# Docker image command
# docker build --build-arg JAR_FILE=build/libs/PribasMonolithic-0.0.1-SNAPSHOT.jar -t serkansahinz/pribasmonolithic:v001 .