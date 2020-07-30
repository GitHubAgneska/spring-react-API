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


## Adding Spring Security to the Project

1.pom.xml + :

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.thymeleaf.extras</groupId>
        <artifactId>thymeleaf-extras-springsecurity5</artifactId>
    </dependency>

2.Defining the Security Model + repository

-> add a manager object entity
-> add a manager repository

3.Linking Data with Their Managers

-> modify customer object entity to add manager / version

4.Securing Employees to Their Managers : any manager can log in and view the data, but only a given employee’s manager can make any changes

-> modify customer repository


5.Writing a UserDetails Service : connect user’s data store into a Spring Security interface

-> add  a SpringDataJpaUserDetailsService


6.Wiring up Your Security Policy

-> add a securityConfiguration


7.Adding Security Details Automatically

-> add a SpringDataRestEventHandler


8.Pre-loading Manager Data

-> add manager(s) to DatabaseLoader








