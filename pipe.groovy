//def gitUrl = "https://github.com/example/project.git"

pipelineJob("MyProject-Build") {
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