Feature: API get method testing
#Description:req
#Background:common steps

Scenario: As an API user, i am trying to prctice HTTP get method
Given pass the URL
Then validate status code
And validate data format is json
And validate responce time
And validate reponse should not be null