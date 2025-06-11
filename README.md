# Test Java Service Project

This project is a simple Java service that retrieves data from our API to test TLS cert issues from certain legacy environments

## Project Structure

```bash
java-service-project
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── App.java
│       └── resources
├── Dockerfile
├── pom.xml
└── README.md
```

## Prerequisites

- Docker
- Maven

## Building the Project

To build the project, navigate to the project directory and run:

```bash
mvn clean package
```

This command will compile the Java code and package it into a JAR file.

## Running the Application with Docker

1. Build the Docker image:

   ```bash
   docker build -t java-test .
   ```

2. Run the Docker container, providing the API URL as an environment variable:

   ```bash
   docker run -e API_URL=https://jujhar.com/v1/_health java-test
   ```
