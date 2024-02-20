@echo off

echo Starting app...

timeout /nobreak /t 1 > nul

cd ./src/backend-and-api/target

java -jar backend-and-api-0.0.1-SNAPSHOT.jar

pause