FROM eclipse-temurin:17.0.8_7-jre
EXPOSE 8080
WORKDIR /opt/app
COPY target/*.jar app.jar
CMD java -jar -Dspring.profiles.active=prod app.jar