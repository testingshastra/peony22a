Feature: This feature explains parameterization in Cucumber

	@Smoke
  Scenario: Pass two numbers as parameter
    Given I have numbers 5 and 6
    When I add them
    Then Check if its addition is prime
	@Regression @Smoke
  Scenario: Pass a string as parameter
    Given I have a string "Hello"
    Then Print this string on console

  Scenario: Passing a table as argument
    Given I have numbers as follow:
      | 1 |  5 |  6 |  7 |
      | 2 | 11 | 13 | 14 |
      | 3 |  5 | 56 | 45 |
      | 4 |  8 | 19 | 21 |

  Scenario Outline: Data driven test case
    Given I have username and password from <row_number>
    Then Print them 
    

    Examples: 
      | row_number |
      |          2 |
      |          3 |
      |          4 |
      |          5 |
