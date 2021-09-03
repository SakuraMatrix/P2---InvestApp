Feature: Create many Accounts...

  Background:
    * url baseUrl
    * def buyBase = '/stocks/2/buy/GOOG/1'


  Scenario: Create an Account with all fields
    Given path buyBase
    When method GET
    Then status 200

 