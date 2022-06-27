FROM eclipse-temurin:17-alpine

EXPOSE 8080

COPY target/SpringIntegrationTest-*.jar /SpringIntegrationTest.jar

ENTRYPOINT ["java", "-jar", "/SpringIntegrationTest.jar"]