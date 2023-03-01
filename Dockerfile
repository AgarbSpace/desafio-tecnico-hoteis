# Imagem base
FROM openjdk:17-jdk-alpine

# Diretório de trabalho
WORKDIR /api

# Copiar o arquivo JAR gerado pelo projeto Spring Boot
COPY target/api-0.0.1-SNAPSHOT.jar api.jar

# Comando de execução
ENTRYPOINT ["java", "-jar", "api.jar"]