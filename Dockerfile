FROM adoptopenjdk/openjdk8:alpine-nightly
EXPOSE 8080
ADD target/app-0.0.1-SNAPSHOT.jar app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "app-0.0.1-SNAPSHOT.jar"]