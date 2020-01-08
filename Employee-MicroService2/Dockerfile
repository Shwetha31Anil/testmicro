FROM maven:3.5-jdk-8 AS build
COPY src /usr/springpeople/src
COPY pom.xml /usr/springpeople
RUN mvn -f /usr/springpeople/pom.xml clean package
EXPOSE 8090
ENTRYPOINT ["java", "-jar","/usr/springpeople/target/Employee-MicroService-0.0.1-SNAPSHOT.jar"]
