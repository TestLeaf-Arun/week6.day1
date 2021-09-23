Feature: Create Lead functionality of Leaftaps Application

#Background:
#Given Open the chrome browser
#And Load the application url 'http://leaftaps.com/opentaps'

Scenario Outline: Create Lead Page
Given Enter the username as 'demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then Homepage should be displayed
When Click on CRMSFA link
When Click on Leads link
When Click on Create Lead link
Then Create Lead Page should be displayed
Given Enter the Company name as <companyname>
And Enter the First Name as <firstname>
And Enter the Last Name as <lastname>
When Click on Create Lead button
Then View Lead Page should be displayed

Examples:
|companyname|firstname|lastname|
|'TestLeaf'|'Arun'|'Prakash'|
|'SCB'|'Rajesh'|'K'|