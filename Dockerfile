FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY build/libs/MobBuilderAPI-*.jar MobBuilderAPI.jar
COPY build/resources resources

CMD ["java", "-jar", "MobBuilderAPI.jar"]