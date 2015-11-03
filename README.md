[![Build Status](https://travis-ci.org/jmbataller/spring-boot-primes-sample.svg?branch=master)](https://travis-ci.org/jmbataller/spring-boot-primes-sample)

# spring-boot-primes-sample

Requirements
---------------

- Java JDK 8
- Maven 3

Installation
---------------

```
mvn clean install
```

Run
---------------

```
mvn spring-boot:run
```

or

```
java -jar target/spring-boot-primes-sample-0.0.1-SNAPSHOT.jar
```

Tests
---------------

```
mvn test
```

API:
---------------

Get primes for a number

Basic (default JSON response):

```
curl http://localhost:8080/primes/10
```

Basic with JSON response:

```
curl --header "Accept: application/json" http://localhost:8080/primes/10
```

Basic with XML response:

```
curl --header "Accept: application/xml" http://localhost:8080/primes/10
```

TODOs:
---------------
- Add http caching headers
- Write integration and unit tests
- Add different algorithms:
	+ Basic - Iterative
	+ Basic - Iterative with parallelStream
	+ Recursive
	+ Iterative caching results in a Map
