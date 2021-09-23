Feature: Edit Lead functionality of Leaftaps Application

#Background:
#Given Open the chrome browser
#And Load the application url 'http://leaftaps.com/opentaps'

Scenario Outline: Edit Lead Page
Given Enter the username as 'demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then Homepage should be displayed
When Click on CRMSFA link
When Click on Leads link
When Click on Find Leads link
When Click on Phone tab
When Enter Phone number as <phoneno>
When Click on Find Leads button
When Click on first resulting lead
When Click on Edit button
Given Edit Company name as <companyname>
When Click on Update button
Then Company name of Lead should be updated

Examples:
|phoneno|companyname|
|'1234567890'|'TestLeaf'|
|'44444444'|'SCB'|