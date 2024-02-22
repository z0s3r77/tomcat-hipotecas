FROM tomcat:10.0.2-jdk11-openjdk

COPY ./target/tomcat-hipotecas.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
