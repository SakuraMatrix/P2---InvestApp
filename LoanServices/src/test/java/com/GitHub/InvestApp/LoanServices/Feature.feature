Feature: Testing Database Connectivity

  Scenario: Testing the GET landing page
    Given url: '/hello'
    When method GET
    Then Status 200
    And Match $ contains {"Welcome to Loan Service"}

  Scenario: testing the GET "all" end point
    Given path '/api/v0.1/Loans/vall/0'
    When method GET
    Then status 200

    * def first =response(0)

    Given url <'/api/v0.1/loans/vall/10'>
    When method GET
    Then status 200

  Scenario: Testing the exact response of a GET endpoint
    Given url '/api/v0.1/loans/vall/08'
    When method GET
    Then status 200
    And match $ =={uid:"08"}




