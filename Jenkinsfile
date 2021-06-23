//Credentials de la machine distante
def remote = [:]
remote.name = 'VM4'
remote.host = 'SRVDOADOP4'
withCredentials([usernamePassword(credentialsId: 'cred-vm4', passwordVariable: 'pwdVM4', usernameVariable: 'userVM4')]) {
                        remote.user = "${userVM4}"
   		                remote.password = "${pwdVM4}"
            }  
remote.allowAnyHosts = true


pipeline {

    agent any

    stages {
        
        //Construction de l'image à partir du Dockerfile
        stage('Docker Build') {
            steps {
                sh 'docker build -t srvdoadop2:9080/flask_app_image:2.0.0 . '
                echo  "Build $BUILD_NUMBER success"
            }
        }

        //Connexion et push de l'image sur DockerHub le tag doit être respecté
        //stage('Publish image to Docker Hub'){
           // steps{
             //   withCredentials([string(credentialsId: 'dockerHubPwd', variable: 'dockerHubPwd')]) {
               //     sh "docker login -u mkouakou -p ${dockerHubPwd}"
                   
            //}
              //      sh 'docker push mkouakou/flask_app_image:2.0.0'
                
                //}
        //}

        //Connexion et push de l'image sur Nexus Alteca, le tag doit être respecté, l'interpolation aussi avec les ""
        stage('Publish image to Nexus'){
            steps{
               withCredentials([string(credentialsId: 'nexuspassword', variable: 'nexus')]) {
                    sh " docker login -u admin -p ${nexus} http://srvdoadop2:9080 "
            }   
                    sh 'docker push srvdoadop2:9080/flask_app_image:2.0.0'
                    echo  'Push to Alteca Nexus success'
                }
        }

        //Run du container sur la VM hôte de Jenkins
        //stage('Run in the jenkins host') {
            //steps {

               // sh 'docker run -d -p 5000:5000 --name flask_app_cont srvdoadop2:9080/flask_app_image:2.0.0' 
                //echo ' Run success'
            //}
        //}

        //Run de l'image sur un container distant
        stage('Run in Remote host') {
            steps {
                         
                sshCommand remote: remote, command: "docker run -d -p 5001:5000 --name flask_app_VM4 srvdoadop2:9080/flask_app_image:2.0.0 "
                echo  'Run success'
    }
    }
}

}