FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /vinod/app/workspace

COPY ./target/api-gateway-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 5000

ENTRYPOINT java -jar ./app.jar