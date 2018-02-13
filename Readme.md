#Step 1: Create Tier 1 Question

Api: http://localhost:8080/maintenance/create
Method: POST
Request: {
           "changeType":"Are you rolling out new or modifying hardware?"
         }

Response: {
          "id": 7,
          "changeType": "Are you rolling out new or modifying hardware?",
          "createdAt": 1518367614392,
          "updatedAt": 1518367614392
          }
          
          
#Step 2: Add all the Tier 2 question into tier 1

Api: http://localhost:8080/tierTwoQuestion/create
Method: POST
Request: {
           "question":"Is this new software for AWS/production?",
           "maintenanceType":{
             "id":9 
           }
         }

Response: {
          "id": 14,
          "question": "Is this new software for AWS/production?",
          "createdAt": 1518375135034,
          "updatedAt": 1518375135034,
          "maintenanceType":{
          "id": 9,
          "changeType": null,
          "createdAt": null,
          "updatedAt": null,
          "tierTwoQuestion":[]
          }
          }
 Special comments: here maintenanceType id is tier one question id.
 
 #Step 3: Add all tier 3 question into tier 2 question
 
Api: http://localhost:8080/tierThreeQuestion/create
Method: POST
Request: {
           "question":"Is this Business Critical functionality?",
           "weight": 3.0,
           "tierTwoQuestion":{
             "id":20
           }
         }

Response: {
          "id": 23,
          "question": "Is this Business Critical functionality?",
          "weight": 3,
          "createdAt": 1518456697338,
          "updatedAt": 1518456697338
          }
 Special comments: here we will pass tierTwoQuestion id.
 
 #Step 4: To dispaly all the question on the screen.
 
 Api: http://localhost:8080/maintenance/all
 Method: GET
 
 Response: [
           {
           "id": 18,
           "changeType": "Are you rolling out new/modified software?",
           "createdAt": 1518380484934,
           "updatedAt": 1518380484934,
           "tierTwoQuestion":[
           {"id": 20, "question": "Is this new software for AWS/production?", "tierThreeQuestion":[{"id": 23,…},
           {"id": 22, "question": "Is this release modifying existing code?", "tierThreeQuestion":[], "createdAt": 1518451898646,…}
           ]
           },
           {
           "id": 19,
           "changeType": "Are you rolling out new or modifying hardware?",
           "createdAt": 1518380512788,
           "updatedAt": 1518380512788,
           "tierTwoQuestion":[]
           }
           ]
           
   #Step 5: Calculate risk score:
   
   Api: http://localhost:8080/score/evaluate
   Method: POST
   Request: {
  				"bap" : "BAP1",
   			 	"releaseVersion": "1.0",
  				"questionAnswer":[{
    					"questionId" : 23,
    					"answer" : false
  				},
  				{
    					"questionId" : 31,
    					"answer" : false
  				}]
			}
   
   Response: {
				"performanceTestingRequired": false,
				"riskcategory": "Low",
				"score": 0,
				"bap": "BAP1",
				"releaseVersion": "1.0"
			}
