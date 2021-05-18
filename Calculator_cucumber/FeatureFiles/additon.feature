
@tag
Feature: Check Additon
  

  @tag1
  Scenario Outline: Check additon in caliApp
    Given I want to open url "http://calc.qedgetech.com"
    When I click "<num1>"
    And I click add
		And I click "<num2>"
		And I click equals
		Then it should display apporptiate result
		Examples:
	| num1 | num2 |
	| 799 | 100 |
	| 3000 | 2000 |

  