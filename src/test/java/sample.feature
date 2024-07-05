
@tag
Feature: login to page

#  Background:
#    Given Open Web Page
  @Regression
  Scenario Outline: <login> Test
    Given Open Web Page
    When Logged in with username <name> and password <password>
    Then message is displayed

    Examples:
     | login | name  	|  password	     |
     | pos   | student  |  Password123   |
     | neg   | studen   |  Password123   |
     | neg 2 | student  |  Password12    |

