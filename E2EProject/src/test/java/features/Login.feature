Feature: Application login

Scenario Outline: Home page login
Given user initialised browser
And user navigate to <Url> landing page
And user clicks on login link
When User Login into home page with <UserName> and Password <Password>
Then user is sucessfully logged in
And browsers are closed

Examples:
|Url							|UserName 		  			|Password 			|
|http://qaclickacademy.com		|pgpawangoswami88@gmail.com |Pawantopper@88 	|
|http://qaclickacademy.com		|test98@gmail.com 			|1234590 			|