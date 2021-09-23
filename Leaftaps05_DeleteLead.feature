Feature: Delete Lead functionality of Leaftaps Application

#Background:
#Given Open the chrome browser
#And Load the application url 'http://leaftaps.com/opentaps'

Scenario Outline: Delete Lead Page
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
When Click on first resulting lead to be deleted
When Click on Delete button
When Click on Find Leads link
When Enter Lead ID
When Click on Find Leads button
Then No search results should be displayed

Examples:
|phoneno|
|'1234567890'|
|'44444444'|