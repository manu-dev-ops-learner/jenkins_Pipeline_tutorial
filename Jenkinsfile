pipeline {

    agent { dockerfile true }

    stages {

        stage('Build') {
            steps {
                sh """ docker build -t flask_app . """
                echo " Build success"
            }
        }

         stage('Run') {
            steps {
                sh """ docker run --rm flask_app  """
                echo " Runn success"
            }
        }
    }
}