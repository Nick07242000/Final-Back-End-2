cd eureka-server/
sh make.sh
cd ..

cd gateway-service/
sh make.sh
cd ..

cd movies-service/
sh make.sh
cd ..

cd users-service/
sh make.sh
cd ..

cd billing-service/
sh make.sh
cd ..

docker-compose up
