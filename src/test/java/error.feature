
@tag
Feature: error test 2

#  Background:
#    Given Open Web Page

  @Regression
  Scenario: assertion test
   Given Open Web Page
   When Logged in with username student and password anypass
   Then "Your password is invalid!" message is displayed

  @Regression
  Scenario: assertion test 2
    Given Open Web Page
    When Logged in with username studen and password anypass
    Then "Your username is invalid!" message is displayed