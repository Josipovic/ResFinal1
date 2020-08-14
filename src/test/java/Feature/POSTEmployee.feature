Feature: POST employee
  Scenario: Send a POST request and validate an employee
    Given Server is up and running
    When I perform a POST request at "api/employees"
    Then I should see status code as 201
    When I perform a GET request at "api/employees/6"
    Then status shall be 200
    And employees age should be 22
    And employees department should be "Testing"