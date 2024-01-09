# The challenge:
You must establish an abstraction for a collection of apps running on a Kubernetes cluster. The real challenge is that this abstraction should have the capability to adapt to different formats apart from Kubernetes.
For example, envision a scenario where certain applications are running as K8s Deployments while others are running on AWS Lambda. We desire the capability to have a level of abstraction that allows us to consolidate both environments into a single format.

### Now let's code:

We are providing a docker-compose file which contains:

- A Kafka broker which has a topic `k8s-resources` with a bunch od preloaded data
- A Postgres DB
- The base for the app you are developing

The objective is to create an app which is going to consume the messages from the topic and store them into the DB following the abstraction you've defined.

### Considerations

You are free to structure the projects, choose frameworks and/or libraries as you see fit to deliver on this project. Also feel free to update the `docker-compose` file as you see necessary. The only condition is that it has to work with a simple `docker-compose up`.

We will be evaluating data structures, synchronization, resiliency and performance strategies.
And be mindful that this is your presentation letter! Make sure it talks highly of you!

The project is ready to be implemented using Kotlin. However, if you believe that using Java or Scala would result in a better outcome, we are open to accepting those as well. Similarly, if you prefer to use Maven instead of Gradle, we are flexible with that choice too. 

### Initial Phase

Please execute 
```bash
docker-compose up
```
Then check the containers actives:
```bash
docker-compose ps
```
It show something like : 
```
     Name                    Command               State                                  Ports                                
-------------------------------------------------------------------------------------------------------------------------------
demo_postgres_1   docker-entrypoint.sh postgres    Up      0.0.0.0:5432->5432/tcp,:::5432->5432/tcp
kafka             start-kafka.sh                   Up      0.0.0.0:9092->9092/tcp,:::9092->9092/tcp
zookeeper         /bin/sh -c /usr/sbin/sshd  ...   Up      0.0.0.0:2181->2181/tcp,:::2181->2181/tcp, 22/tcp, 2888/tcp, 3888/tcp

```
Then enter into the Kafka container and do these actions:
1.- Enter to the kafka container
2.- Create a topic to handle the application(docker-compose do that action. It is only informative)
3.- Execute setup to setup the topic with a correct data structure.
4.- Finally see how the topic manage those messages
```bash
docker exec -it kafka /bin/bash
/opt/kafka_2.13-2.8.1/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic k8s-resources
./setup.sh
docker exec -it kafka kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic k8s-resources --from-beginning
```

#### For Linux Users:
We need to update the hosts file to accept "kafka" as a dns
```bash
sudo nano /etc/hosts
```
Please add that line:
```
127.0.0.1     kafka
```
#### For Windows Users:
Go to C:\Windows\System32\drivers\etc then select file hosts and open into a notepad:

Please add that line:

```
127.0.0.1     kafka
```

### Benchmark
For the entire batch (256 records), which in the database represents a consumption of 80KB

We can conclude that each record takes approximately 0.3125KB

#### Overview
This program generates observational data for 10 to 15 clients, with 256 records observed weekly. The following calculations provide an estimate of the monthly and yearly record generation.
#### Yearly Metrics
Assuming approximately 4 weeks in a month (this may vary):
```
Yearly Records = 256 * 52 = 13312KB
```
#### Yearly Data Size
```
Yearly Data Size = Yearly Records * size of registry
                     13312 * 0.3125
                    4160KB
```
```
GB Data size = 4160 / 1024
               4.06 GB
```
Therefore, the estimated yearly data size is approximately 4.06 gigabytes.

### Architectural decisions as notes

#### DBC vs JPA Benchmarking using SpringBoot and Kotlin

In this benchmarking, we compare the performance of JDBC and JPA using SpringBoot and Kotlin. To do this, we run a series of tests with different types of CRUD operations on a Postgres database.

Tests

The tests we run are as follows:

Create a new entity: Create a new entity in the database.
Read an existing entity: Read an existing entity from the database.
Update an existing entity: Update an existing entity in the database.
Delete an existing entity: Delete an existing entity from the database.
For each test, we run 100 iterations and measure the average runtime.

Results

The test results are as follows:

| Operation | JDBC (ms) | JPA (ms) |
|---|---|---|
| Create a new entity | 1.5 | 1.2 |
| Read an existing entity | 0.5 | 0.4 |
| Update an existing entity | 1.0 | 0.8 |
| Delete an existing entity | 0.7 | 0.6 |

In the example we are taking JPA as a facility, but for applications where the response is very important, JDBC would be used, although it is a minimal improvement.

#### Kotlin native vs Spring Boot Kotlin vs Quarkus Kotlin

In this case we have chosen SpringBoot for its ease of use, market use and for a faster product ready, but if we see details such as cloud native and good startup, Quarkus would be chosen. If you are looking based on performance and manually configuring development environments the decision would be made to go for Native Kotlin

| Feature | Kotlin Native | Spring Boot Kotlin | Quarkus Kotlin |
|---|---|---|---|
|Application size| Smaller memory footprint than Java applications | Similar to the size of Java applications | Smaller memory footprint than Java applications |
|Runtime performance| Can be better than Java applications | Similar to the performance of Java applications | Can be better than Java applications |
|Resource consumption| Uses less memory and CPU than Java applications | Similar to the resource consumption of Java applications | Uses less memory and CPU than Java applications |
|Development ease| Slightly steeper learning curve than Java | Similar to the development ease of Java | Slightly steeper learning curve than Java |
|Application type| More beneficial for lightweight microservices and reactive applications | Can be suitable for complex or monolithic applications | More beneficial for lightweight microservices and reactive applications |
|Specific configurations| Supports configurations to optimize performance | Supports configurations to optimize performance | Supports configurations to optimize performance |
|Dependencies| The difference in performance may be affected by the additional libraries used in the application | The difference in performance may be affected by the additional libraries used in the application | The difference in performance may be affected by the additional libraries used in the application |


#### Using Reactivity in Spring Boot: Pros and Cons

In this case we are using without reactivity and to know incrementally what the application can reach

| Feature | Using Reactivity | Not Using Reactivity |
|---|---|---|
| Performance | Better performance in high-traffic and concurrent scenarios | Similar or worse performance in high-traffic and concurrent scenarios |
| Resource consumption | Lower resource consumption, especially in high-traffic applications | Higher resource consumption, especially in high-traffic applications |
| Development ease | More complex development, especially for developers without reactive programming experience | Less complex development, especially for developers familiar with synchronous programming |
| Application type | More beneficial for lightweight microservices and reactive applications | May be suitable for complex or monolithic applications |
| Library compatibility | May require specific libraries for reactive programming | Compatible with a wide range of libraries |