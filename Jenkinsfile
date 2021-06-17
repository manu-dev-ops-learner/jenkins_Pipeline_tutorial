pipeline {

    agent any

    stages {

        stage('Docker Build') {
            steps {
                sh 'docker build -t flask_app_image . '
                echo  'Build success'
            }
        }

        stage('Publish image to Docker Hub'){
            steps{
                withCredentials([string(credentialsId: 'dockerHubPwd', variable: 'dockerHubPwd')]) {
                    sh "docker login -u mkouakou -p ${dockerHubPwd}"
                    sh 'docker push mkouakou/flask_app_image'
            }
                
                }
        }

        stage('Run in the jenkins host') {
            steps {

                sh 'docker run -d -p 5000:5000 --name flask_app_cont flask_app_image' 
                echo ' Run success'
            }
        }
    }
}