call mvn clean
echo "clean complete"

cd .\cloud-eureka-server7001
call mvn package spring-boot:repackage -DskipTests=true

echo "eureka build complete"
cd ..

cd .\cloud-order80
call mvn package spring-boot:repackage -DskipTests=true
echo "order80 build complete"
cd ..


cd .\cloud-provider-payment8001
call mvn package spring-boot:repackage -DskipTests=true
echo "payment8001 build complete"
cd ..