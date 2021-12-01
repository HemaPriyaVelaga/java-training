#! /bin/sh

mvn clean package -DskipTests
docker build -t order-service:latest .
