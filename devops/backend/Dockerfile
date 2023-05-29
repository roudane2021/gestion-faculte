# Utiliser une image Java 11 en tant que base
FROM openjdk:11-jdk

LABEL version="1.0"
LABEL maintainer="ra.roudane@gmail.com"

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY couche.jar app.jar


# Exposer le port sur lequel l'application écoute
EXPOSE 9090

# Commande pour exécuter l'application lorsque le conteneur démarre
CMD ["java", "-jar", "app.jar"]