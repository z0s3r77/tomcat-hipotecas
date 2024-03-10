FROM tomcat:jdk21-temurin-jammy

RUN apt-get update && \
    apt-get install -y ca-certificates-java && \
    update-ca-certificates -f

RUN apt-get update
RUN apt-get install maven -y

WORKDIR /usr/src/app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

RUN cp target/tomcat-hipotecas.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
