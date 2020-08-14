Feature: POST with auth

  Scenario: Login and verify GET operation with bearer authentication token
    Given Server is up and running
    When I perform authentication for "api/account/register" with login body
    Then I perform POST request at endpoint "/token" with text
    And I perform GET request  for "api/Phones"
    Then status code is 200
    Then I perform POST request for "api/Phones" with body
    When I perform GET request at endpoint "api/Phones"
    Then I should see Name of the phone as ""