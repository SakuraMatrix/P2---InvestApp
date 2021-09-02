Feature: Testing Database Connectivity
  Scenario: testing the GET "all" end point

    Given url '/api/v0.1/Loans/vall'
    When method GET
    Then status 200

  Scenario: Testing the exact response of a GET endpoint

    Given url '/api/v0.1/loans/vall'
    When method GET
    Then status 200
    And match $ =={uid:"08"}

  Scenario: Testing the GET landing page

    Given url: '/"
    When method GET
    Then Status 200
    And Match $ contains {"Welcome to Loan Service"}


