FROM amazoncorretto:11

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 3001

ENTRYPOINT ["java","-jar","/app.jar"]