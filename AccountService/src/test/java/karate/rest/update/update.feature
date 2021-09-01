Feature: Updating certain columns in an Account

  Background:
    * url baseUrl
    * def creditUpdate = '/credit/'
    * def fundsUpdate = '/funds/'

  Scenario: Updates the credit in a specific account
    Given path creditUpdate + '3'
    And request '5000.00'
    When method PUT
    Then status 200

  Scenario:Same as above but for funds
    Given path fundsUpdate + '2'
    And request '54321.00'
    When method PUT
    Then status 200