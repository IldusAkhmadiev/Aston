FROM openjdk:22-jdk-slim
WORKDIR /app
COPY src /app/src
RUN javac -d /app/classes /app/src/**/*.java
ENTRYPOINT ["java", "-cp", "/app/classes", "battle.DockerRunner"]
# если вместо ENTRYPOINT ошибка из за того что невозможно передать аргументы
# CMD ["java", "-cp", "/app/classes", "battle.DockerRunner"]