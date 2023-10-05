Feature: Admin Console Login 

Scenario Outline: COnsole Page Validation for invalid login credentials 
	Given I am on the login page 
	When I enter invalid credentials "<username>" and "<password>" 
	And I click the login 
	Then I should see an error message 
	
	Examples: 
		| username             | password       |
		| admin@sens.com       | Sensiple*203   |
	
Scenario Outline: COnsole Page Validation for successful login 
	When I enter my valid "<username>" and "<password>" 
	And I click the login button 
	Then I should be redirected to the dashboard 
	
	Examples: To run test 1 specific data 
		| username | password |
		| admin@sensipleucx.com    | Jan2023@   |  
		
Scenario: Ensure Jenie Bot Properties 
	When User click on Bot Management 
	And User click on action button 
	And User click on user management 
	And User click on Skill Group 
	Then Bot properties ensured 

Scenario Outline: Logging into Microsoft Teams with Different User Types 
	Given I am on the Microsoft Teams login page 
	When I enter "<username>" into the username field 
	And I enter "<password>" into the password field 
	Then I should see Teams dashboard 
	
	Examples: 
		| username        | password      | 
		| AutomationTestAgent1@lab.ontryvium.com | Gos85664 | 
	
	
Scenario: Ensure Webconnect Bot Chat 
	When User Open Url in New Tab 
	And User Passing Values 
	And Initiating chat in Bot 
	Then Closing the chat with Bot	
	
Scenario: Ensure Webconnect InQueue 
	When Open Url in New Tab 
	And User Passing Credentials 
	And Initiating chat as new user Bot 
	Then user close the chat		
	