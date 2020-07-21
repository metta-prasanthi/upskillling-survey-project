FROM openjdk:8-alpine

RUN mkdir -p /app && apk update

WORKDIR /app

COPY target/SurveyApi-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar","app.jar"]