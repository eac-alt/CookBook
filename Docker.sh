#!/bin/bash 
 


sudo mvn clean package -DskipTests

docker build -t cookbook-app  .
docker run -d -p 9000:8081 --name cookbook-app cookbook-app

