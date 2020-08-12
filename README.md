# Getting Started

To run the application you would first need to compile the code and then you can access the jar from the target folder

`mvn clean install`

`java -jar target/valr-test-0.0.1-SNAPSHOT.jar`

or use spring boot maven plugin

`mvn spring-boot:run`

by default the application runs on port http://localhost:8080


### Health Check
you can see if the service is up and running by calling http://localhost:8080/actuator/health

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#production-ready)

* [vertx java documentation](https://vertx.io/docs/vertx-core/java/)

#Vertx things I am not sure about

I am not sure if I handled the exceptions in the best way I had a look at https://vertx.io/docs/vertx-web/java/#_error_handling,I fell like there is a much neater way of doing this

Testing 