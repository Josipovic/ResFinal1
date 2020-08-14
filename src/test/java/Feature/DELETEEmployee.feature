Feature: DELETE feature

  Scenario: Verify DELETE operation after POST
    Given Server is up and running
    When I perform POST request for "api/Employees"
    Then I should see status code 201
    When I perform GET for "api/Employees"
    Then I should see employees first name as "Maca"
    And  last name as "Lukas"
    When I perform DELETE request at "api/Employees/7"
    Then status code has to be 200
    When I use GET operation at "api/Employees"
    Then I should not see employees first name as "Maca"
    And I should not see employees last name as "Lukas"
