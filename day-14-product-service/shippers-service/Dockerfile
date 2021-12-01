FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /hema/springapp/app1
## The above is working directory in the container
COPY ./target/shippers-service-0.0.1-SNAPSHOT.jar ./app.jar
## Copying the file from local machine to container
EXPOSE 9093

ENTRYPOINT java -jar ./app.jar
## Running the jar file in container