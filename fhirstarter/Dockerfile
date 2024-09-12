# betriebssystem bereitstellen
FROM maven:3.9.9-amazoncorretto-21 as build

# dateien in conteiner kopieren
WORKDIR /build
COPY . .

# jar datei bauen
RUN mvn clean package

FROM amazoncorretto:21

WORKDIR /app

COPY --from=build /build/target/*.jar app.jar

EXPOSE 8080

# jar datei ausführen
ENTRYPOINT ["java", "-jar", "app.jar"]