
pipeline {

    agent any

    stages {
       
        //Construction de l'image à partir du Dockerfile BackEnd
        stage('Docker Build speech IA') {
            steps {
               
                git credentialsId: '27d0ca7f-967f-4503-91e3-17d47bb6ed12', url: 'http://srvdoadop2/athevenot/speech-emotion-recognition.git'
                sh 'docker build -t srvdoadop2:9080/speechia:1.0.0 . '
                
            }
        }
       

        //Connexion et push de l'image sur Nexus Alteca, le tag doit être respecté, l'interpolation aussi avec les ""
        stage('Publish speech IA image to Nexus'){
            
            steps{
                 withCredentials([string(credentialsId: 'nexuspassword', variable: 'nexus')]) {
                    sh " docker login -u admin -p ${nexus} http://srvdoadop2:9080 "
            } 
                    sh 'docker push srvdoadop2:9080/speechia:1.0.0'
                    echo  'Push speech IA image to Alteca Nexus success'
                }
        }


        
        stage('Run speech IA in the jenkins host') {
            steps {

               sh 'docker run -d -it -p 5001:5000 --name ia_speech srvdoadop2:9080/speechia:1.0.0' 
                echo ' Run success'
            }
        }


   
}

}