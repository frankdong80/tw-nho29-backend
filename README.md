# Project Name
Thoughtworks NHO 29 Train System backend

# Scripts
#### Build
```shell
./gradlew build
```
#### Run
```shell
./gradlew bootRun
```
#### Create docker images 
```shell
./gradlew docker 
```
Then you will get a docker image of ${project.group}/${bootJar.baseName}
```shell
docker images
output: com.thoughtworks.nho/gs-spring-boot-docker:latest
```