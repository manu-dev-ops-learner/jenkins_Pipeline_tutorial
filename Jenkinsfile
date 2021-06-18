
def remote = [:]
remote.name = 'VM4'
remote.host = '172.31.105.15'
remote.user = 'root'
remote.password = 'devOpsAlt=15'
remote.allowAnyHosts = true

pipeline {

    agent any

    stages {

    stage('Remote SSH') {
        steps {
      sshCommand remote: remote, command: "docker ps"
      //sshCommand remote: remote, command: "for i in {1..5}; do echo -n \"Loop \$i \"; date ; sleep 1; done"
    }
    }
}

}