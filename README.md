# Authentication system web app 2.1.0

This is a web application dedicated for a simple authentification system, as well as viewing your created account and modifying the details. The application is written in `React` for the frontend, `Spring Boot` for the backend and `MySQL` for the database

## Table of contents

- [Release notes](#release-notes)
- [Required 3rd party tools](#required-3rd-party-tools)
- [Deploying the application](#deploying-the-application)
- [App documentation](#app-documentation)
- [Useful 3rd party docs](#useful-3rd-party-docs)

## Release notes

- [Relase 2.1.0 release notes](https://github.com/virlancristian/Authentication-web-app/pull/11)

## Required 3rd party tools

- [Node.js v20.8.1](https://nodejs.org/dist/v20.8.1/)
- [Java 21](https://www.oracle.com/ro/java/technologies/downloads/#java21)
- [MySQL 8.0](https://dev.mysql.com/downloads/installer/)

## Deploying the application

After installing all your 3rd party tools do the following steps before starting the application:
- Open MySQL workbench and run the following query:
```mysql
CREATE DATABASE userdb;
USE userdb;
CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    profilePictureURL VARCHAR(500),
    about_me VARCHAR(500),
    PRIMARY KEY (id)
);
``` 
- In the root directory of the project, create a file name `database_credentials.txt`
- Open the file and provide the MySQL database login credentials in the following format:
```
{username}
{password}
```
- Open the `build.bat` file if you are on Windows or run the following commands if you are on Linux:
```bash
chmod +x build.sh #this command should be executed once, the first time you run the build.sh file
./build.sh
```
- Everything is ready! You can start the server by opening the `start.bat` file if you are on Windows or run the following commands if you are on Linux:
```bash
chmod +x start.sh #this command should be executed once, the first time you run the start.sh file
./start.sh
```

## App documentation

[Click here!](https://github.com/virlancristian/Authentication-web-app/issues/10)

## Useful 3rd party docs

- [React](https://devdocs.io/react/)
- [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
