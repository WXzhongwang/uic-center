#jdk版本
FROM openjdk:8-jdk-alpine

#挂载目录
VOLUME /tmp

#将jar包添加到容器中并更名为demosw.jar
ADD /start/target/uic-center-service.jar uic-center-service.jar

#docker运行命令
ENTRYPOINT ["java","-Dspring.profiles.active=test","-jar","/uic-center-service.jar"]