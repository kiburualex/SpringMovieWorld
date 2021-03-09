# MOVIEWORLD API USING SPRINGBOOT
## Introduction
* An API for movies crud management.

## Technologies used.
* **[Spring Boot](https://spring.io/projects/spring-boot)**
* **[Swagger](https://swagger.io/)**
* **[Docker](https://www.docker.com/)**


## Installation

 #### **Download the repo.**
 ```
    $ git clone https://github.com/kiburualex/SpringMovieWorld
```
 #### **Build project using maven**
 ```
    $ mvn clean install
```
 #### **Locate target folder to run jar**
 ```
    $ java -jar movieworld-0.0.1-SNAPSHOT.jar
```


## Run Using Docker

 #### **Build image**
   ```
    $ docker build -t springio/spring-boot-movieworld .
  ```
 #### **Run image**
 ```
    $ docker run -p 8080:8080 springio/spring-boot-movieworld
```

  ## Urls
  #### **Login url: already has users inserted on initialization**
 ```
  http://localhost:8080/login
  username: admin
  password: admin123
```
  #### **Swagger Api Url**
 ```
  http://localhost:8080/swagger-ui
```
   #### **Health Check Url**
```
  http://localhost:8080/actuator/health
  ```
