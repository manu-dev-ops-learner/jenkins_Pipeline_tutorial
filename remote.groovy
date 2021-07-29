def remote = [:]
remote.name = 'VM4'
remote.host = 'SRVDOADOP4'
withCredentials([sshUserPrivateKey(credentialsId: 'ansadminkey', keyFileVariable: 'privateKey', passphraseVariable: '', usernameVariable: 'ansadmin')]) {
    remote.user = "${ansadmin}"
   	remote.password = "${pwdVM4}"
}
withCredentials([usernamePassword(credentialsId: 'cred-vm4', passwordVariable: 'pwdVM4', usernameVariable: 'userVM4')]) {
                        remote.user = "${userVM4}"
   		                remote.password = "${pwdVM4}"
            }  
remote.allowAnyHosts = true

pipeline {

    agent any

    stages {
        
        //Construction de l'image à partir du Dockerfile
        stage('Test Ansible') {
            steps {
                sshagent(['ansadminkey']) {
                sh 'ssh -o StrictHostKeyChecking=no ansadmin@172.31.105.15 ansible all -m ping'
                echo  'Run success'
            }
        }
    }
    }
}