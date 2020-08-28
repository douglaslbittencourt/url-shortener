FROM maven:3.6.3-jdk-11 AS build
LABEL maintainer="douglaslbittencourt"
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests=true

FROM openjdk:13-jdk-alpine
LABEL maintainer="douglaslbittencourt"
COPY --from=build /usr/src/app/target/url-shortener-0.0.1-SNAPSHOT.jar /usr/src/app/url-shortener-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app/url-shortener-0.0.1-SNAPSHOT.jar"]