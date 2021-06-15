pipeline {
    agent { docker { image 'python:3.5.1' } }
    stages {
        stage('build') {
            steps {
                sh 'python plus_ou_moins.py'
                stash(name: 'Compiled-results', includes: '*.py')
                echo "Build Success"
            }
        }
    }
}
