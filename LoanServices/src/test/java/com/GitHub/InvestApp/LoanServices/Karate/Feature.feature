Feature: Testing Database Connectivity

  Background:
    * url  'localhost:8080'
  #{http://${eureka.client.instance.hostname}:${server.port}


  Scenario: Testing the GET landing page
    Given path 'hello'
    When method GET
    Then Status 200
    And match response == 'success'


  Scenario: testing the GET "all" end point
    Given path '/api/v0.1/Loans/vall/0'
    When method POST
    Then status 200

    * def first =response(0)

    Given path '/api/v0.1/loans/vall/10'>
    When method GET
    Then status 200

  Scenario: Testing the exact response of a GET endpoint
    Given path '/api/v0.1/loans/vall/08'
    When method GET
    Then status 200
    And match $ =={uid:"08"}




