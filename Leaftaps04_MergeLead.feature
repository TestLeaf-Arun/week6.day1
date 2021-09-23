Feature: Merge Lead functionality of Leaftaps Application

#Background:
#Given Open the chrome browser
#And Load the application url 'http://leaftaps.com/opentaps'

Scenario Outline: Merge Lead Page
Given Enter the username as 'demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then Homepage should be displayed
When Click on CRMSFA link
When Click on Leads link
When Click on Merge Leads link
When Click on From Lead lookup <firstname>
When Click on To Lead lookup <lastname>
When Click on Merge button
When Handle the alert
When Click on Find Leads link
When Search by Lead ID
When Click on Find Leads button
Then Verify the Leads are Merged

Examples:
|firstname|lastname|
|'Arun'|'Prakash'|
|'Rajesh'|'K'|