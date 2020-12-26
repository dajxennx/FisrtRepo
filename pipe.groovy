//def gitUrl = "https://github.com/example/project.git"

pipelineJob("MyProject-Build") {
    description "Builds MyProject from master branch."
    parameters {
        stringParam('COMMIT', 'HEAD', 'Commit to build')
    }
    scm {
        //git repo
        git {
            remote {
                url('git@github.com:dajxennx/FisrtRepo.git')
                branch('origin/master')
            }
            extensions {
                wipeOutWorkspace()
                localBranch master
            }
        }
        // script path
        scriptPath('Jenkinsfile')

    }
    steps {
        shell "Look: I'm building master!"
    }
}