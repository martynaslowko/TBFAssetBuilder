FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY build/libs/TBFAssetBuilder-*.jar TBFAssetBuilder.jar
COPY build/resources resources

CMD ["java", "-jar", "TBFAssetBuilder.jar"]