@echo off
setlocal enabledelayedexpansion

echo Starting application build...

timeout /nobreak /t 1 > nul

echo Obtaining address...

timeout /nobreak /t 1 > nul

for /f "tokens=2 delims=:" %%a in ('ipconfig ^| find "IPv4 Address"') do (
    set "ipAddress=%%a"
)

set "ipAddress=!ipAddress:~1!"

echo %ipAddress% > internal_ip.txt

echo IP address has been saved to internal_ip.txt

echo Writing config files...

timeout /nobreak /t 1 > nul

java -jar ConfigBuilder.jar

del internal_ip.txt

echo Installing Maven dependencies...

timeout /nobreak /t 1 > nul

cd ./src/backend-and-api

if exist target (
	del target /f /q /s
)

call mvnw dependency:resolve

cd ../frontend

echo Installing Node dependencies...

timeout /nobreak /t 1 > nul

if exist node_modules (
	del node_modules /f /q /s
)

start cmd /k "npm i"

cd ../backend-and-api

echo Building executables...

timeout /nobreak /t 1 > nul

call mvnw package

echo Build completed successfully!

pause
