#!/bin/bash
Docker pull mysql
cd CookBook
Git pull Docker 
docker network create app-network #create the network
docker run -p 3306:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=root -d mysql:latest # start MySQL container
docker network connect app-network mysql  #add MySQL container to the network
docker run -it --network app-network --rm mysql mysql -hmysql-db -u root -p #connect to MySQL container
create database cookbookdb; #create database
exit
docker build -t cookbook-app . #build spring application image
docker run -d -p 8080:8081 --network app-network --name cookbook-app cookbook-app #run spring container
curl localhost:8080 #test the application


