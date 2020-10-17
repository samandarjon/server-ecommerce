FROM maven:adoptopenjdk AS MAVEN_BUILD
MAINTAINER Samandar Akbarov
COPY ../pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM ringcentral/jdk:latest
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/ecommerce-api.jar /app/
ENTRYPOINT ["java", "-jar", "ecommerce-api.jar"]