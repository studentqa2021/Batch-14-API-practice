Feature: Testing all API methods
#Description:req
#Background:common steps

Scenario Outline: As an API user, i am trying to check HTTP get & delete methods
Given select HTTP methods "<HTTP method>" and go to URL "<URL>"
Then validate my test
Examples:
|HTTP method|URL						 |
|GET		|http://localhost:3000/posts/|
|DELETE		|http://localhost:3000/posts/|


Scenario Outline: As an API user, i am trying to check post & put HTTP get methods
When pass test data"<HTTP method>"
Given select HTTP methods "<HTTP method>" and go to URL "<URL>"
Then validate my test
Examples:
|HTTP method|URL						 |
|POST		|http://localhost:3000/posts/|
|PUT		|http://localhost:3000/posts/|