FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /hema/springapp/app1

COPY ./target/order-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 9095

ENTRYPOINT java -jar ./app.jar