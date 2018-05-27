FROM openjdk:8-jdk-alpine
MAINTAINER dogood.ai <devgood@dogood.ai>

VOLUME /tmp
ADD target/flash-cards-1.0.0.jar /app/app.jar
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar" ]