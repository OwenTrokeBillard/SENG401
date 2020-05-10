# SENG 401 - NHL Application
Winter 2020
Contributors: Owen Troke-Billard, Nick Brough, Jedediah Heal, Qifeng Li,  Jathniel Ong  
## Project Layout
### 1. NHL
- Description: Front End
- Developed Using: Angular 8
- Dev Port: 4200
### 2. Main Web-App
- Description: Coordinates between the front end and all the other microservices. The Main Web-App communicates with the front-end using HTTP. It communicates with the microservices using GRPC.
- Developed Using: Java, Spring Boot, Maven, MongoDB, GRPC
- Dev Port: 8080
### 4. ForumPost Microservice
- Description: Manages Forums and Posts Data. Communicates with the main web-application using GRPC.
- Developed Using: Golang, MongoDB, GRPC
- Dev Port: 50051
### 3. Comments Microservice
- Description: Manages comments including nesting. 
- Developed Using: Rust, MongoDB, GRPC
- Dev Port: 50052
### 5. Notifications Microservice
- Description: Manages notifications and subscriptions and Posts Data. Communicates with the main web-application using GRPC.
- Developed Using: Java, Maven, MongoDB, GRPC
- Dev Port: 50053

# Instructions
## Prerequisites
Install [Docker](https://docs.docker.com/get-docker/) on Windows, Mac, or Linux. Make sure Docker is using Linux containers if you are on Windows, which is the default.
## Run
Run `docker-compose up -d` in the same directory as `docker-compose.yml`. It may take a long time to download the dependencies and build everything the first time.

Once everything is running, head to [http://localhost/](http://localhost/) to access the application.
