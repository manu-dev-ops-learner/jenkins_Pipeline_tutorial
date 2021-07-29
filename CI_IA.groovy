
pipeline {

    agent any

    stages {
       
        //Construction de l'image à partir du Dockerfile BackEnd
        stage('Docker Build text profiling IA') {
            steps {
               
               git credentialsId: '27d0ca7f-967f-4503-91e3-17d47bb6ed12', url: 'http://srvdoadop2/pygenest/text-profiling-debug.git'
               sh 'docker build -t srvdoadop2:9080/textprofiling:1.0.0 . '
                
            }
        }

        ///Push Image to Alteca's Nexus 
        stage('Publish text profiling IA image to Nexus'){
            
            steps{
                  withCredentials([string(credentialsId: 'nexuspassword', variable: 'nexus')]) { 
                   sh " docker login -u admin -p ${nexus} http://srvdoadop2:9080 "
            } 
                    sh 'docker push srvdoadop2:9080/textprofiling:1.0.0'
                    sh 'docker rmi -f srvdoadop2:9080/textprofiling:1.0.0'
                    
                }
        }
    }
}



      