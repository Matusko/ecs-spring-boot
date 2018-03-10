**Run spring boot**

mvn spring-boot:run

**Build docker image**

docker build --build-arg JAR_FILE=target/gs-spring-boot-docker-0.1.0.jar --tag ${some_tag} .

**OR**

mvn install dockerfile:build

**check images**

docker images

**run docker container**

docker run -p 8080:8080 -t ${some_tag}

**check running containers**

docker ps

**stop running container**

docker stop ${containerId}