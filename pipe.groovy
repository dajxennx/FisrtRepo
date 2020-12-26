//def gitUrl = "https://github.com/example/project.git"

pipelineJob("MyProject-Build") {
        properties {
        pipelineTriggers {
            triggers {
                pollSCM {
                    scmpoll_spec('H/5 * * * *')
                }
            }
        }
    }
    definition {
        cpsScm {
            scm {
                git('git@github.com:dajxennx/FisrtRepo.git')
                branch('origin/master')
                scriptPath('JenkinsFile')
            }
        }
    }
}