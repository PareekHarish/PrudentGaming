FROM openjdk:17
EXPOSE 8080
ADD  target/prudentgaming-demo.jar prudentgaming-demo.jar
ENTRYPOINT ["java", "-jar", "/prudentgaming-demo.jar"]
