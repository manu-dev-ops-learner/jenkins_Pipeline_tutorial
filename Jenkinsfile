pipeline {

    agent any

    stages {

        stage('Docker Build') {
            steps {
                sh 'docker build -t srvdoadop2:9080/flask_app_image:2.0.0 . '
               // sh 'docker tag mkouakou/flask_app_image:2.0.0 srvdoadop2:9080/flask_app_image:2.0.0'
                echo  'Build success'
            //rm build images to docker host after build
            }
        }

        //stage('Publish image to Docker Hub'){
           // steps{
             //   withCredentials([string(credentialsId: 'dockerHubPwd', variable: 'dockerHubPwd')]) {
               //     sh "docker login -u mkouakou -p ${dockerHubPwd}"
                   
            //}
              //      sh 'docker push mkouakou/flask_app_image:2.0.0'
                
                //}
        //}

    //Stash to Nexus repo

        stage('Publish image to Nexus'){
            steps{
               withCredentials([string(credentialsId: 'nexuspassword', variable: 'nexus')]) {
                    sh " docker login -u admin -p ${nexus} http://srvdoadop2:9080 "
                   
            }
                    
                    sh 'docker push srvdoadop2:9080/flask_app_image:2.0.0'
                
                }
        }

        //stage('Run in the jenkins host') {
            //steps {

               // sh 'docker run -d -p 5000:5000 --name flask_app_cont srvdoadop2:9080/flask_app_image:2.0.0' 
                //echo ' Run success'
            //}
        //}

        stage('Connexion to VM4 via SSH') {

            sh 'ssh root@172.31.105.15'
            echo 'Success'

        }

        //stage('Run in VM4') {
            //steps {
                //sshagent(['connect_VM4']) {
                    //sh 'docker run -d -p 5001:5000 --name flask_app_VM4 srvdoadop2:9080/flask_app_image:2.0.0' 
                //}

               // sh 'docker -H ssh://root@172.31.105.15 run -d -p 5001:5000 srvdoadop2:9080/flask_app_image:2.0.0'
                //echo ' Run success'
            //}
        //}


    }
}

//Do it for IA projects3
//How to add tag automa