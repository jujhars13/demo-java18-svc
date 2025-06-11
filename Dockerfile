# --- Build stage ---
FROM maven:3.8-openjdk-18-slim AS build

WORKDIR /build
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

RUN ls -l /build/target

# --- Runtime stage ---
#FROM openjdk:1.8.0_442-jdk
FROM openjdk:8-jdk-alpine3.7

COPY --from=build /build/target/java-goodstack-svc-1.0.jar /app.jar

ENV API_URL=https://api.poweredbypercent.com/v1/_health
ENTRYPOINT ["java", "-jar", "/app.jar"]
