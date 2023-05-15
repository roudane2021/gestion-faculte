pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Étape pour récupérer le code source depuis le dépôt Git
                git 'https://github.com/roudane2021/gestion-faculte.git'
            }
        }

        stage('Build') {
            steps {
                // Étape pour construire l'application avec Maven
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Étape pour exécuter les tests avec Maven
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Étape pour déployer l'application
                sh 'java -jar target/couche-web-1.0-SNAPSHOT.jar'
            }
        }
    }
}
