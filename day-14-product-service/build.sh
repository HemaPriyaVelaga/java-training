#! /bin/sh

cd ./customer-service
mvn clean package -DskipTests
docker build -t customer-service:latest .
cd ..

cd ./product-service
mvn clean package -DskipTests
docker build -t product-service:latest .
cd ..


cd ./employee-service
mvn clean package -DskipTests
docker build -t employee-service:latest .
cd ..

cd ./shippers-service
mvn clean package -DskipTests
docker build -t shippers-service:latest .
cd ..


cd ./api-gateway-service
mvn clean package -DskipTests
docker build -t api-gateway-service:latest .
cd ..


cd ./eureka-service
mvn clean package -DskipTests
docker build -t eureka-service:latest .
cd ..