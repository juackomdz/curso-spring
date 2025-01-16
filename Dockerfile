##compilar
FROM maven:3-amazoncorretto-17-alpine as builder

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN mvn clean package -DskipTests

##ejecutar 
FROM tomcat:9-jdk17-openjdk

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD [ "catalina.sh", "run" ]

#ENTRYPOINT [ "catalina,sh", "run" ]

