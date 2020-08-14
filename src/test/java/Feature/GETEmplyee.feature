Feature: Verify different GET operations using REST assured

  Scenario: Verify first employee
    Given Server is up and running
    When I perform GET request at "api/Employees/1"
    Then I validate that status code is 200
    And I validate that employees first name is "Andrew"
    And I validate that employees last name is "Smith"


Scenario: Verify second employee
  Given Server is up and running
  When I perform GET request for "api/employees/2"
  Then status code should be 200
  And employees first name should be "Sarah"
  And employees last name should be "Williams"