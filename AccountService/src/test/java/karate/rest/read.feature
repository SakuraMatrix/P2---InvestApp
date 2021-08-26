Feature: Reads accounts from the database...

  Background:
    * url baseUrl
    * def accountBase = '/accounts/'

  Scenario:
    Given path accountBase + '1'
    When method GET
    Then status 200
    And match response == {id: 1, firstName: 'Andrew', lastName: 'Gregersen', funds: 50987.51, credit: 9542.00}

  Scenario:
    Given path accountBase + '2'
    When method GET
    Then status 200
    And match response == {id: 2, firstName: 'John', lastName: 'Doe', credit: 9542.00}

  Scenario:
    Given path accountBase + '3'
    When method GET
    Then status 200
    And match response ==  {id: 3, firstName: 'Joe', lastName: 'Shmoe', funds: 50987.51}
