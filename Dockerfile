# ---------- BUILD STAGE ----------
FROM maven:3.9.9-amazoncorretto-21 AS build
WORKDIR /app

# Copiar solo pom primero (mejor cache)
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copiar código fuente
COPY src ./src

# Compilar aplicación
RUN mvn -B clean package -DskipTests

# ---------- RUNTIME STAGE ----------
FROM amazoncorretto:21-alpine

# Crear usuario no-root (best practice)
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

WORKDIR /app
VOLUME /tmp

# Puerto que usa Render
EXPOSE 4500

# Copiar JAR
COPY --from=build /app/target/fut-tico-app-server-0.0.1-SNAPSHOT.jar app.jar

# Opciones JVM optimizadas para contenedores
ENTRYPOINT ["java", \
 "-XX:+UseContainerSupport", \
 "-XX:MaxRAMPercentage=75.0", \
 "-XX:+UseG1GC", \
 "-XX:+ExitOnOutOfMemoryError", \
 "-jar", "app.jar"]