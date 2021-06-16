pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'plus_ou_moins.py'
                sh 'first_flask_app.py'
                stash(name: 'Compiled-results', includes: '*.py')
                echo "Build Success"
            }
        }
    }
}
