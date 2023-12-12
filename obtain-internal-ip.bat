@echo off
setlocal enabledelayedexpansion

echo Obtaining address...

timeout /nobreak /t 1 > nul

for /f "tokens=2 delims=:" %%a in ('ipconfig ^| find "IPv4 Address"') do (
    set "ipAddress=%%a"
)

set "ipAddress=!ipAddress:~1!"

echo %ipAddress% > internal_ip.txt

echo IP address has been saved to internal_ip.txt

pause