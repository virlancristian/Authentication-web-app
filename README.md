# Authentification site(Login app 3.0)

This is an updated version of my login application(check my profile for more details). This time is done as a web application, and compared to the previous versions, it is fully working, meaning the accounts you create are stored in a database and you can login from anywhere at any time(as long as you have internet connection). You can check it for yourself here: http://82.76.142.241:3000

## Components

On the frontend part, the application consists of 4 parts:

-A main UI where you can select if you want to create an account/login
-An UI for the account creation

-An UI for loggin in

-A UI for a successful login where you can see the details of the account

All the HTTP requests for account creation/logging in are done in JavaScript and sent to the backend to handle them

The backend is done using Spring Boot and has 3 main functions:

-one for handling POST requests for account creations

-one for handling POST requests for logging in and verifying if the information sent by the user is found in the database

-one for handling GET requests for obtaining the account information

All the information regarding the user's data is being stored with the help of the Spring Boot application into a MySQL database

## How to run the servers
The frontend server runs on a NodeJS server.
Once you have NodeJS installed, type in "npm start" to start the frontent server

The backend server runs on an integrated tomcat server
You will need Java 17 or higher to run the integrated tomcat server 
To run the server, in the bash go to the backend forlder and type "./mvnw spring-boot:run"
