multibranchPipelineJob("$JOB_NAME") {
    displayName("$JOB_NAME")
    branchSources {
        git {
            id("$ID")
            remote("$GITLAB_URL")
            credentialsId("$CREDENTIAL_ID")
        }
    }
}