#!/bin/bash 
 

cd Cookbookdb
sudo mvn clean package -DskipTests

docker build -t cookbook-app  .
docker run -d -p 9000:8081 --network app-network --name cookbook-app cookbook-app – run cookbook on network 


