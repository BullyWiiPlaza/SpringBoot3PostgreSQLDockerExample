# Spring Boot 3 + PostgreSQL Docker Example

This example project follows [this](https://www.baeldung.com/spring-boot-postgresql-docker) tutorial and demonstrates
the use of [`Spring Boot 3`](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Release-Notes)
with [`Java 17`](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html),
the [`maven`](https://maven.apache.org/download.cgi) build system, a [`PostgreSQL`](https://www.postgresql.org/download)
database as well as containerizing everything with [`docker`](https://www.docker.com/products/docker-desktop).

# Running the app locally

Set up a `PostgreSQL` installation and create a database using e.g. `PgAdmin 4`
according to the properties in the `application.properties`. Run
the application from
your IDE or via `mvn spring-boot:run`. Verify it works correctly without any warnings or errors in the terminal. Then,
shut down the application once again.

# Running the app from a docker container

First, compile the whole app via `mvn clean package -DskipTests`. Then, copy the compiled executable JAR file to
the `docker` directory with the following
command: `cp target/spring-boot-postgresql-docker-0.0.1-SNAPSHOT.jar src/main/docker`
Navigate into the `docker` folder via `cd src/main/docker`. Make
sure `docker` is installed and the daemon is started. Now run the
command `docker-compose up` to set up and execute your docker container based on the `docker-compose.yml`. Verify
that the app once again works as expected.
