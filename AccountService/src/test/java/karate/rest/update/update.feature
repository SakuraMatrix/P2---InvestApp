Feature: Updating certain columns in an Account

  Background:
    * url baseUrl
    * def creditUpdate = '/credit/'
    * def fundsUpdate = '/funds/'

  Scenario: Updates the credit in a specific account
    Given path creditUpdate + '3'
    And request {credit:5000.00}
    And header Accept = 'application/json'
    When method PUT
    Then status 200
    And match response == {id: 3, firstName: 'Joe', lastName: 'Shmoe', funds: 50987.51, credit: 5000.0}

  Scenario:Same as above
    Given path fundsUpdate + '2'
    And request {funds: 54321.00}
    And header Accept = 'application/json'
    When method PUT
    Then status 200
    And match response == {id: 2, firstName: 'John', lastName: 'Doe', funds: 0.0, credit: 9542.00}