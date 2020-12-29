//def gitUrl = "https://github.com/example/project.git"

pipelineJob("MyProject-Build") {
      //paramters
parameters {
        //string parameter
        stringParam('Greeting', 'Hello', 'How should I greet the world?')
        //choice paramter
        choiceParam('Stage', ['dev', 'test', 'uat'], 'Deployment Stage')
        choiceParam('Tester', ['Danny', 'Ruby', 'William'], 'Tester')
    }
        properties {
        pipelineTriggers {
            triggers {
                /*
                pollSCM {
                    scmpoll_spec('H/5 * * * *')
                }
                */
            }
        }
    }
    definition {
        cpsScm {
            lightweight()
            scm {
                git {
                branch('origin/master')
                remote {
                    url('git@github.com:dajxennx/FisrtRepo.git')
                }
                }
                scriptPath('deploy/Jenkinsfile')
            }
        }
    }
}