##compilar
FROM maven:3-amazoncorretto-17-alpine as builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

##ejecutar 
FROM tomcat:9-jdk17-openjdk
##FROM openjdk:17-alpine
RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
##COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

CMD [ "catalina.sh", "run" ]

##CMD ["java", "-jar", "app.jar"]

