echo "Starting application build..."

sleep 1

echo "Obtaining address..."

sleep 1

ipAddress=$(ifconfig | grep -oP 'inet \K[\d.]+')

echo "${ipAddress}" > local_ip.txt

echo "IP address has been saved to local_ip.txt"

echo "Writing config files..."

sleep 1

java -jar ConfigBuilder.jar build

rm local_ip.txt

echo "Resolving dependencies..."

sleep 1

cd ./src/backend-and-api || exit

if [ -d "target" ]; then
    rm -rf target
fi

cd ../frontend || exit

sleep 1

if [ -d "node_modules" ]; then
    rm -rf node_modules
fi

cd ../backend-and-api || exit

./mvnw dependency:resolve

echo "Building executables..."

sleep 1

./mvnw package

echo "Final steps..."

sleep 1

java -jar ConfigBuilder.jar clean

echo "Build completed successfully!"
