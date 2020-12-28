//def gitUrl = "https://github.com/example/project.git"

pipelineJob("MyProject-Build") {
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