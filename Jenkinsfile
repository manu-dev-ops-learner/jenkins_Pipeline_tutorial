pipeline {
    agent { docker { image 'python:3.5.1' } }
    stages {
        stage('build') {
            steps {
                sh 'first_flask_app.py'
                stash(name: 'Compiled-results', includes: '*.py')
                echo "Build Success"
            }
        }
    }
}
