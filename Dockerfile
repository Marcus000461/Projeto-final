# Estágio 1: Build (Compilação)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia o pom.xml e baixa as dependências (cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código e gera o .jar
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Run (Execução)
FROM eclipse-temurin:17-jre
WORKDIR /app

# Busca o arquivo gerado no estágio anterior
# O "*" garante que pegaremos o jar independente do nome definido no pom.xml
COPY --from=build /app/target/*.jar app.jar

# Porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a API
ENTRYPOINT ["java", "-jar", "app.jar"]