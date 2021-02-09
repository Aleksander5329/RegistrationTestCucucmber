
Feature: login test

  @Login
  Scenario: open browser and login
    Given browser is open
    And user is on google search page
    When user enters text in search box
    And hits enter
    And user clicks on home page
    Then user clicks on new registartion
  



   
