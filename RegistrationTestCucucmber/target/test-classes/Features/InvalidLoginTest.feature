 
 @TESTING
 Feature: Agreements
 
	@Testing1
	Scenario: Enter invalid email
	
		Given user is on signup page
		And user clicks submit
    Then user gets error
    
	@Testing2
 	Scenario:
 	
 		Given user entered username
 		And user clicks submit1
 		Then user gets error1
 		
 	@Testing3
 	Scenario:
 	
 		Given user entered username and pass
 		And user clicks submit2
 		Then user gets error2
 		
 	@Testing4
 	Scenario:
 	
 		Given user entered pass less char
 		And user clicks submit23
 		Then user gets error23
 		
 	@Testing5
 		 	Scenario:
 		 	
 		Given user entered unmaching pass
 		And user clicks submit232
 		Then user gets error232
 		
 	@Testing6
 	Scenario:
 	
 		Given user entered username pass gender 
 		And user clicks submit
 		Then user gets error
 		
 	@Testing7
 	Scenario:
 	
 		Given user entered username pass gender date
 		And user clicks submit3
 		Then user gets error3
 		
 	@Testing8
 	Scenario:
 	
 		Given user entered username pass gender date and agreed
 		And user clicks submit4
 		Then user gets error4
	