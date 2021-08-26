Feature: Create many Accounts...

  Background:
    * url baseUrl
    * def accountBase = '/accounts'


  Scenario: Create an Account with all fields
    Given path accountBase
    And request {id: 1, firstName: 'Andrew', lastName: 'Gregersen', funds: 50987.51, credit: 9542.00}
    And header Accept = 'application/json'
    When method post
    Then status 200
    And match response == {id: 1, firstName: 'Andrew', lastName: 'Gregersen', funds: 50987.51, credit: 9542.00}

  Scenario: Create an Account with out any funds...
    Given path accountBase
    And request {id: 2, firstName: 'John', lastName: 'Doe', credit: 9542.00}
    And header Accept = 'application/json'
    When method post
    Then status 200
    And match response == {id: 2, firstName: 'John', lastName: 'Doe', credit: 9542.00}

  Scenario: Create an Account with out any credit...
    Given path accountBase
    And request {id: 3, firstName: 'Joe', lastName: 'Shmoe', funds: 50987.51}
    And header Accept = 'application/json'
    When method post
    Then status 200
    And match response == {id: 3, firstName: 'Joe', lastName: 'Shmoe', funds: 50987.51}


