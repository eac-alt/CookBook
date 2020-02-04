pipeline {
    agent any
    stages {
        stage('--Mvn clean package--') {
                steps {
                    sh "mvn clean package deploy"
                    }
            }
            stage('--Build back-end--') {
                steps {
                    sh "docker build -t cookbook-app ."
                    }
            }
        stage('--Deploy--') {
              steps {
                    sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PSSWRD}"
                    sh "docker tag cookbook-app lizziecol/cookbook-app"
                    sh "docker push lizziecol/cookbook-app"
                    }
              }
    }
}
