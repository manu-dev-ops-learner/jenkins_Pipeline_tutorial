pipeline {

    agent any

    stages {

        stage('Docker Build') {
            steps {
                sh 'docker build -t mkouakou/flask_app_image:2.0.0 . '
                echo  'Build success'
            }
        }

        stage('Publish image to Docker Hub'){
            steps{
                withCredentials([string(credentialsId: 'dockerHubPwd', variable: 'dockerHubPwd')]) {
                    sh "docker login -u mkouakou -p ${dockerHubPwd}"
                   
            }
                    sh 'docker push mkouakou/flask_app_image:2.0.0'
                
                }
        }

        stage('Run in the jenkins host') {
            steps {

                sh 'docker run -d -p 5000:5000 --name flask_app_cont mkouakou/flask_app_image:2.0.0' 
                echo ' Run success'
            }
        }
    }
}