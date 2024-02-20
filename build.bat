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

echo %ipAddress% > local_ip.txt

echo IP address has been saved to local_ip.txt

echo Writing config files...

timeout /nobreak /t 1 > nul

java -jar ConfigBuilder.jar frontend

del local_ip.txt

echo Resolving dependencies...

timeout /nobreak /t 1 > nul

cd ./src/backend-and-api

if exist target (
	del target /f /q /s
)

cd ../frontend

timeout /nobreak /t 1 > nul

if exist node_modules (
	del node_modules /f /q /s
)

cd ../backend-and-api

call mvnw dependency:resolve

echo Building executables...

timeout /nobreak /t 1 > nul

call mvnw package

echo Final steps...

timeout /nobreak /t 1  > nul

java -jar ConfigBuilder.jar backend

echo Build completed successfully!

pause
