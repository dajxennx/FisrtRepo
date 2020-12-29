//def gitUrl = "https://github.com/example/project.git"

pipelineJob("MyProject-Build") {
    parameters {
        booleanParam('FLAG', true)
        choiceParam('OPTION', ['option 1 (default)', 'option 2', 'option 3'])
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