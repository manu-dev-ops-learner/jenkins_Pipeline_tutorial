pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'python plus_ou_moins.py'
                sh 'python first_flask_app.py'
                stash(name: 'Compiled-results', includes: '*.py')
                echo "Build Success"
            }
        }
    }
}
