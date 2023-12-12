@echo off

echo Checking for dependencies...

timeout /nobreak /t 1 > nul

cd ./src/backend-and-api

if not exist target (
    echo Maven dependencies not found!
    echo Installing dependences...

    timeout /nobreak /t 1 > nul

    call mvnw dependency:resolve

    echo Maven dependencies successfully installed!
)

cd ../frontend

if not exist node_modules (
    echo Node dependencies not found!
    echo Installing dependencies...

    timeout /nobreak /t 1 > nul

    npm i

    echo Node dependencies successfully installed!
)

cd ../backend-and-api

echo All dependencies found!

if not exist target (
    echo Building app...

    timeout /nobreak /t 1 > nul

    call mvnw package
)

echo Starting app...

timeout /nobreak /t 1 > nul

cd ./target

start cmd /k "java -jar backend-and-api-0.0.1-SNAPSHOT.jar"

cd ../../frontend

npm run start

pause