# Usa una imagen base de OpenJDK 17
FROM openjdk:17-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR compilado de tu aplicación Spring Boot al contenedor
COPY target/proyecto-spring-jose-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que se ejecuta tu aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar tu aplicación Spring Boot al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]
