#!/bin/bash

echo "Starting application build..."

sleep 1

echo "Obtaining address..."

sleep 1

ipAddress=$(ifconfig | grep "inet " | grep -v 127.0.0.1 | awk '{print $2}')

echo "$ipAddress" > internal_ip.txt

echo "IP address has been saved to internal_ip.txt"

echo "Writing config files..."

sleep 1

java -jar ConfigBuilder.jar

rm internal_ip.txt

echo "Installing Maven dependencies..."

sleep 1

cd ./src/backend-and-api

if [ -d "target" ]; then
    rm -rf target
fi

./mvnw dependency:resolve

cd ../frontend

echo "Installing Node dependencies..."

sleep 1

if [ -d "node_modules" ]; then
    rm -rf node_modules
fi

npm i

cd ../backend-and-api

echo "Building executables..."

sleep 1

./mvnw package

echo "Build completed successfully!"

read -p "Press Enter to exit..."
