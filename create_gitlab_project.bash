#!/bin/bash

# # Define GitLab personal access token
# GITLAB_TOKEN=$(cat access_token.txt)

# # Define project details
# PROJECT_NAME="Spring%20App"
# PROJECT_PATH="spring-app"
# PROJECT_NAMESPACE="classic.nct"

# Create the project
curl -fsSL -X POST --header "PRIVATE-TOKEN: $GITLAB_TOKEN" "https://gitlab.com/api/v4/projects?name=$PROJECT_NAME&path=$PROJECT_PATH&namespace=$PROJECT_NAMESPACE" || true