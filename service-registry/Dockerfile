FROM openjdk:11-jdk
WORKDIR /opt
COPY service-registry/build/libs/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar