# -------- BUILD STAGE --------
FROM gradle:7.6-jdk17-alpine AS build
WORKDIR /app
COPY . .
RUN ./gradlew bootJar --no-daemon

# -------- RUNTIME STAGE --------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
