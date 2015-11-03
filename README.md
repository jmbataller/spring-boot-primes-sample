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

Get primes for a number (by default returns JSON):

*GET http://localhost:8080/primes/{number}*

```
curl http://localhost:8080/primes/10
```

JSON response:

```
curl --header "Accept: application/json" http://localhost:8080/primes/10
```

XML response:

```
curl --header "Accept: application/xml" http://localhost:8080/primes/10
```

Algorithms:
---------------
The API contains different algorithms to generate the primes list:

- *Basic Iterative algorithm* **(default)**
	
	Get prime numbers up-to and including the number passed as parameter
	
	```
	curl http://localhost:8080/primes/10?algorithm=BasicIterative
	```

- *Multi-threading Iterative algorithm* **(ideal for big numbers)**
	
	Same as *Basic Iterative algorithm* but uses multi-threading to generate the list of primes.  This algorithm breaks the domain (range between 2 and the number) in sub-groups and creates several threads to process each of the sub-groups.
	
	```
	curl http://localhost:8080/primes/10?algorithm=BasicParallelIterative
	```


- *Multi-threading Iterative with Cache algorithm* **(ideal for repeated requests)**

	Same as *Multi-threading Iterative algorithm* but uses a in-memory cache that is used to store previous calculations. The list of primes is retrieved from the cache when there are repeated requests.
	
	```
	curl http://localhost:8080/primes/10?algorithm=CachedParallelIterative
	```

	
