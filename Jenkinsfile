pipeline {
    agent any
  //paramters
parameters {
        //string parameter
        string(name: 'Greeting', defaultValue: 'Hello', description: 'How should I greet the world?')
        //choice paramter
        choice(name: 'Stage', choices: ['dev', 'test', 'uat'], description: 'Deployment Stage')
    }
    //stages of build
    stages {
      stage('Init') {
            steps {
                echo "${params.Greeting} World!"
            }
        }
        stage('Build') {
            steps {
                echo "Building ${params.Stage}."

            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}