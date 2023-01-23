FROM registry.cn-hangzhou.aliyuncs.com/cake-devops/tomcat8:0.0.1
COPY start/target/uic-center.war /usr/local/apache-tomcat-8.5.85/webapps/ROOT.war
EXPOSE 8080