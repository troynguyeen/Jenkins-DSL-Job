#!/bin/bash

#Get ID of project
ID=$(curl -fsSL -X GET --header "PRIVATE-TOKEN: $GITLAB_TOKEN" "https://gitlab.com/api/v4/projects?owned=true" | jq '.[0].id')

#Create Jenkins CI integration
curl -fsSL --request PUT --header "PRIVATE-TOKEN: $GITLAB_TOKEN" \
     --data "jenkins_url=$JENKINS_URL" \
     --data "project_name=$JOB_NAME" \
     --data "username=$JENKINS_USERNAME" \
     --data "password=$JENKINS_PASSWORD" \
     --data "push_events=true" \
     --data "merge_requests_events=true" \
     "https://gitlab.com/api/v4/projects/$ID/integrations/jenkins"