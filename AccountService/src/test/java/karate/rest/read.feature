Feature: Reads account/account information from the database...

  Background:
    * url baseUrl
    * def accountBase = '/accounts'
    * def fundsBase = '/funds'
    * def creditBase = '/credit'
    * def accountSetup = call read('classpath:create.feature')

  Scenario:
    Given path accountBase + '1'
    When method GET
    Then status 200
    And match response == {id: 1, firstName: 'Andrew', lastName: 'Gregersen', funds: 50987.51, credit: 9542.00}

  Scenario:
    Given path accountBase + '2'
    When method GET
    Then status 200
    And match response == {id: 2, firstName: 'John', lastName: 'Doe', funds: 0.0, credit: 9542.00}

  Scenario:
    Given path accountBase + '3'
    When method GET
    Then status 200
    And match response ==  {id: 3, firstName: 'Joe', lastName: 'Shmoe', funds: 50987.51, credit: 0.0}

  Scenario:
    Given path fundsBase + '1'
    When method GET
    Then status 200
    And match response == '50987.51'

  Scenario:
    Given path creditBase + '3'
    When method GET
    Then status 200
    And match response == '0.0'

