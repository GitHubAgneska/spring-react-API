

https://spring.io/guides/tutorials/react-and-spring-data-rest/

./mvnw spring-boot:run

netstat -a

while app running: check current data info
curl localhost:8888/api
curl localhost:8888/api/clients


create new entries:

curl -X POST localhost:8080/api/employees -d "{\"firstName\": \"Bilbo\", \"lastName\": \"Baggins\", \"description\": \"burglar\"}" -H "Content-Type:application/json"

