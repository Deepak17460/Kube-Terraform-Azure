FROM openjdk:17-slim
EXPOSE 8087
ADD target/Calculator2.war Calculator2.war
ENTRYPOINT ["java", "-jar", "Calculator2.war"]