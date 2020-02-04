pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('--test--') {
            steps {
                sh "mvn -DskipTests"
            }
        }
        stage('--package--') {
            steps {
                sh "mvn package"
            }
        }
    }
}
