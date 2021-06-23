

pipeline {

    agent any

    stages {
        stage ("Build"){
        parallel {
        //Construction de l'image à partir du Dockerfile BackEnd
        stage('Docker Build BackEnd IA') {
            steps {
               
                git credentialsId: '27d0ca7f-967f-4503-91e3-17d47bb6ed12', url: 'http://srvdoadop2/yyildiz/classification-bancaire.git'
                sh 'docker build -t srvdoadop2:9080/testbackendia:1.0.0 . '
                
            }
        }

        //Construction de l'image à partir du Dockerfile FrontEnd
        stage('Docker Build FrontEnd IA') {
            steps {
                git credentialsId: '27d0ca7f-967f-4503-91e3-17d47bb6ed12', url: 'http://srvdoadop2/ybenkhallouf/classification-bancaire.git'
                sh 'docker build -t srvdoadop2:9080/testfrontendia:1.0.0 . '
               
            }
        }

        }
        }

        stage ("Push"){

        parallel {

        //Connexion et push de l'image sur Nexus Alteca, le tag doit être respecté, l'interpolation aussi avec les ""
        stage('Publish BackEnd IA image to Nexus'){
            steps{
               withCredentials([string(credentialsId: 'nexuspassword', variable: 'nexus')]) {
                    sh " docker login -u admin -p ${nexus} http://srvdoadop2:9080 "
            }   
                    sh 'docker push srvdoadop2:9080/testbackendia:1.0.0'
                    echo  'Push to Alteca Nexus success'
                }
        }

        stage('Publish FrontEnd IA image to Nexus'){
            steps{
               withCredentials([string(credentialsId: 'nexuspassword', variable: 'nexus')]) {
                    sh " docker login -u admin -p ${nexus} http://srvdoadop2:9080 "
            }   
                    sh 'docker push srvdoadop2:9080/testfrontendia:1.0.0'
                    echo  'Push to Alteca Nexus success'
                }
        }

        }
        }
        stage ("Deploy"){

        parallel {
        //Run du container sur la VM hôte de Jenkins
        //Back IA
        stage('Run BackEnd IA in the jenkins host') {
            steps {

               sh 'docker run -d -p 5000:5000 --name ia_backend srvdoadop2:9080/testbackendia:1.0.0' 
                echo ' Run success'
            }
        }

        //Front IA
        stage('Run FrontEnd IA in the jenkins host') {
            steps {

               sh 'docker run -d -p 4000:3000 --name ia_frontend srvdoadop2:9080/testfrontendia:1.0.0' 
                echo ' Run success'
            }
        }

        }
        }
}

}