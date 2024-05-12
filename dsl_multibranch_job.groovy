multibranchPipelineJob("$JOB_NAME") {
    displayName("$JOB_NAME")
    branchSources {
        branchSource {
            source {
                gitlab {
                    id("$ID")
                    serverName("$GITLAB_SERVER_NAME")
                    credentialsId("$CREDENTIAL_ID")
                    projectOwner("$PROJECT_OWNER")
                    projectPath("$PROJECT_OWNER/$PROJECT_PATH")
                    traits {
                        WebhookListenerBuildConditionsTrait {
                            alwaysBuildMROpen(true)
                            alwaysBuildMRReOpen(true)
                        }
                        gitLabBranchDiscovery {
                            strategyId(3)
                        }
                        gitLabOriginDiscovery {
                            strategyId(2)
                        }
                        gitTagDiscovery()
                    }
                }
                strategy {
                    allBranchesSame {}
                }
            }
        }
    }
    factory {
        workflowBranchProjectFactory {
            scriptPath("$SCRIPT_PATH")
        }
    }
    triggers {
        computedFolderWebHookTrigger {
            token("$TRIGGER_TOKEN")
        }
    }
    orphanedItemStrategy {
        discardOldItems {}
    }
}