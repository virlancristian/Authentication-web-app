echo "Starting app..."

sleep 1

cd ./target

java -jar backend-and-api-0.0.1-SNAPSHOT.jar &

cd ../../frontend

npm run start

read -p "Press Enter to exit..."
