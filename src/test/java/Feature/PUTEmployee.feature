Feature: Verify PUT request

  Scenario: Verify PUT operation after POST
    Given I perform POST request for "api/Employees" with body as
      | Id | FirstName | LastName | Age | Salary | Department  |
      | 15 | Shane     | Reese    | 24  | 14000  | Development |
    And I perform PUT request for "api/Employees/{Id}"
      | Id | FirstName | LastName | Age | Salary | Department  |
      | 15 | NotShane  | Reese    | 24  | 14000  | Development |
    And I perform GET operation with path parameter for "api/Employees/{Id}"
      | Id |
      | 15 |
    Then I should see the body with First Name as "NotShane"