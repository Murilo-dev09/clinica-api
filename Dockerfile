FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Define a variável de ambiente para o Maven usar UTF-8
ENV MAVEN_OPTS="-Dfile.encoding=UTF-8"

COPY clinica/ .

# Força o encoding também no comando de build
RUN mvn clean package -DskipTests -Dproject.build.sourceEncoding=UTF-8 -Dproject.reporting.outputEncoding=UTF-8

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
