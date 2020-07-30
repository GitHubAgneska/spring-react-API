Project environment
Java 8 (Maven) Spring Boot React.js (ES6)

Spring Data REST-based application
---
https://spring.io/guides/tutorials/react-and-spring-data-rest/


## run app

    ./mvnw spring-boot:run


## webpack watch mode (monitor js changes live)

    npm run-script watch



## Ports in use

    netstat -a 

## change default port 8080 > applications.properties > add:


    server.port=8888


## while app running: check current data info

    curl localhost:8888/api
    curl localhost:8888/api/customers


## create new entries:

    curl -X POST localhost:8888/api/customers -d "{\"firstName\": \"Name\", \"lastName\": \"XXX\", \"address\": \"YYY\"}" -H "Content-Type:application/json"


## After adding 'PagingAndSortingRepository'

    curl "localhost:8888/api/customers?size=2"
    curl "localhost:8888/api/customers?page=1&size=2"


## In ---2 : start using the hypermedia controls Spring Data REST 

after refact: 

    curl http://localhost:8888/api/profile/customers -H "Accept:application/schema+json"