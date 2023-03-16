FROM openjdk:17-jdk-slim

WORKDIR /app

VOLUME /app

CMD java -jar /app/myjar.jar

COPY app-jar/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]