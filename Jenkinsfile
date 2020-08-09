pipeline {
  agent any
  stages {
    stage('error') {
      parallel {
        stage('error') {
          steps {
            sh '''bash hw.sh
exit'''
          }
        }

        stage('hr') {
          steps {
            git(url: 'https://github.com/dajxennx/FisrtRepo.git', branch: 'master')
            sh 'bash hw.sh'
          }
        }

      }
    }

  }
}