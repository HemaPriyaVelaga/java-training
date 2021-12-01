FROM adoptopenjdk/openjdk11:alpine-slim
WORKDIR /hema/app/workspace
COPY ./target/hello-service-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8082
ENTRYPOINT java -jar ./app.jar