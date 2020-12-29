//def gitUrl = "https://github.com/example/project.git"

pipelineJob("MyProject-Build") {
      //paramters
parameters {
        //string parameter
        string(name: 'Greeting', defaultValue: 'Hello', description: 'How should I greet the world?')
        //choice paramter
        choice(name: 'Stage', choices: ['dev', 'test', 'uat'], description: 'Deployment Stage')
        choice(name: 'Tester', choices: ['Danny', 'Ruby', 'William'], description: 'Tester')
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