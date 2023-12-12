# Authentification web app 2.0.0

This is a web application dedicated for a simple authentification system, as well as viewing your created account and modifying the details. The application is written in `React` for the frontend, `Spring Boot` for the backend and `MySQL` for the database

## Table of contents

- [Release notes](#release-notes)
- [Required 3rd party tools](#required-3rd-party-tools)
- [Deploying the application](#deploying-the-application)
- [App documentation](#app-documentation)
- [Useful 3rd party docs](#useful-3rd-party-docs)

## Release notes

- [Relase 2.0.0 release notes]([url](https://github.com/virlancristian/Authentification-site/pull/6))

## Required 3rd party tools

- [Node.js v20.8.1](https://nodejs.org/dist/v20.8.1/)
- [Java 20.0.2](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html)
- [MySQL 8.0](https://dev.mysql.com/downloads/installer/)

## Deploying the application

After installing all your 3rdparty tools do the following steps before starting the application:
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
- Go into your app folder to `src/backend-and-api/src/main/resources` and open `application.properties`
- Fill in the `spring.datasource.username` and `spring.datasource.password` fields and fill them with your MySQL authentification credentials(or create another user for the )

**Optional: providing the internal IP**
If you want to access your application from outside of your computer from any device in your local network you must provide the internal IP to the application. Do the following steps:
- Run the `obtain-internal-ip.bat` file from the root directory if you are on Windows or run
```bash
chmod +x obtain-internal-ip.sh
./obtain-internal-ip.sh
```
if you are on Linux
- Copy the IP address from `internal_ip.txt`
- Go to `src/backend-and-api/src/main/resources` and open `application.properties`
- Fill in the `internal.ip` field with the copied IP
- Go to the root directory then go to `src/frontend` and create a file name `.env`
- Open the file and write the following content:
```env
REACT_APP_INTERNAL_IP={your_ip_goes_here}
```

- Everything is done! You can run the `start.bat` file from the root directory if you are on Windows or run
```bash
chmod +x start.sh
./start.sh
```
if you are on Linux

## App documentation

[Click here!](https://github.com/virlancristian/Authentification-site/issues/5)

## Useful 3rd party docs

- [React](https://devdocs.io/react/)
- [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
