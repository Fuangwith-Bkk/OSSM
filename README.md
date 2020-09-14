# OSSM

mvn clean package -DskipTests -Pnative \
-Dquarkus.native.container-build=true \
-Dquarkus.native.container-runtime=docker
executing mvnw instead of mvn

docker build -f src/main/docker/Dockerfile.native -t ossm-front-native:v1 .  


docker images

docker tag a35cd6af7f7d quay.io/fuangwit/ossm-frontend-native:v1

docker push quay.io/fuangwit/ossm-frontend-native:v1