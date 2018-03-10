FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
ARG CONFIG_FILE
ADD ${CONFIG_FILE} conf.yml
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar", "--spring.config.location=classpath:application.yml,file:./conf.yml"]