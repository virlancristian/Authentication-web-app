echo "Checking for dependencies..."

sleep 1

cd ./src/backend-and-api

if [ ! -d "target" ]; then
    echo "Maven dependencies not found!"
    echo "Installing dependencies..."

    sleep 1

    ./mvnw dependency:resolve

    echo "Maven dependencies successfully installed!"
fi

cd ../frontend

if [ ! -d "node_modules" ]; then
    echo "Node dependencies not found!"
    echo "Installing dependencies..."

    sleep 1

    npm install

    echo "Node dependencies successfully installed!"
fi

cd ../backend-and-api

echo "All dependencies found!"

if [ ! -d "target" ]; then
    echo "Building app..."

    sleep 1

    ./mvnw package
fi

echo "Starting app..."

sleep 1

cd ./target

java -jar backend-and-api-0.0.1-SNAPSHOT.jar &

cd ../../frontend

npm run start

read -p "Press Enter to exit..."
