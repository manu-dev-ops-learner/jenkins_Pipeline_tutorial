
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
      sshCommand remote: remote, command: "ls -lrt"
      //sshCommand remote: remote, command: "for i in {1..5}; do echo -n \"Loop \$i \"; date ; sleep 1; done"
    }
}

}