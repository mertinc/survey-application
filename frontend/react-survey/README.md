# Survey Application

## Endpoints

#### Create Submission
POST  /submission/createSubmission
Host: localhost:8080
Content-Type: application/json

{
    "comment":"comment",
    "id": 1,
    "score": 10,
    "topicId": {
            "topicId": 2,
        }
}


#### Get submission list by topicId
GET   submission/getSubmissionsbyTopicId/{id}
Host: localhost:8080

####  Get list of topics with their Net Promoter Score
GET   topics/getAllTopics
Host: localhost:8080