#!/bin/bash 
 


sudo mvn clean package -DskipTests

docker build -t cookbook-app  .

docker run -dit --restart unless-stopped -d -p 9000:8081 --name cookbook-app cookbook-app
