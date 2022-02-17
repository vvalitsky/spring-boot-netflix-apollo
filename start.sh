CURRENT_PATH=$(pwd)

cd "$CURRENT_PATH/employee-service/build/libs/" && nohup java -jar employee-service-1.0.0.jar &> /dev/null

cd "$CURRENT_PATH/car-service/build/libs/" && nohup java -jar car-service-1.0.0.jar &> /dev/null



