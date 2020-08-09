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
            git(url: 'https://github.com/dajxennx/FisrtRepo.git', branch: 'helloRuby')
            sh 'bash helloRuby.sh'
            git(url: 'https://github.com/dockerdemo/apache.git', branch: 'master')
            sh '''#!/bin/sh
id
set +e
echo \'>>> Get old container id\'

CID=$(docker ps | grep "apache" | awk \'{print $1}\')

echo $CID

/usr/local/bin/docker build -t apache /var/lib/jenkins/jobs/apache/workspace | tee /var/lib/jenkins/jobs/apache/workspace/Docker_build_result.log
RESULT=$(cat /var/lib/jenkins/jobs/apache/workspace/Docker_build_result.log | tail -n 1)

#if [["$RESULT" != *Successfully*]];then
#  exit -1
#fi

echo \'>>> Stopping old container\'

if [ "$CID" != "" ];then
  /usr/local/bin/docker stop $CID
fi

echo \'>>> Restarting docker\'
service docker.io restart
sleep 5
  
echo \'>>> Starting new container\'
/usr/local/bin/docker run -p 3000:80 -d apache'''
          }
        }

      }
    }

  }
}