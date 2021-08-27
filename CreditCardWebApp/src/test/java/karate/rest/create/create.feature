Feature: Create many Credit Cards...
  -Dio.netty.tryReflectionSetAccessible=true
  Background:
    * url baseUrl
    * def accountBase = '/add'


  Scenario: Create an Credit Card with all fields
    Given path accountBase
    And request {account_id: 1, card_num: '111111111111111' ,first_name: 'Rolando', last_name: 'Leiva', type: 'Discover', ccv: '012', exp_date: '12-26'}
    And header Accept = 'application/json'
    When method post
    Then status 200
    And match response == {account_id: 1, card_num: '111111111111111' ,first_name: 'Rolando', last_name: 'Leiva', type: 'Discover', ccv: '012',  exp_date: '12-26'}

  Scenario: Create an Account with out any funds...
    Given path accountBase
    And request {account_id: 2, card_num: '12345678912345' ,first_name: 'James', last_name: 'Bond', type: 'MasterCard', ccv: '007', exp_date: '10-21'}
    And header Accept = 'application/json'
    When method post
    Then status 200
    And match response == {account_id: 2, card_num: '12345678912345' ,first_name: 'James', last_name: 'Bond', type: 'MasterCard', ccv: '007', exp_date: '10-21'}

  Scenario: Create an Account with out any credit...
    Given path accountBase
    And request {account_id: 3, card_num: '9876543210' ,first_name: 'Luke', last_name: 'Skywalker', type: 'Visa', ccv: '456', exp_date: '05-77'}
    And header Accept = 'application/json'
    When method post
    Then status 200
    And match response == {account_id: 3, card_num: '9876543210' ,first_name: 'Luke', last_name: 'Skywalker', type: 'Visa', ccv: '456', exp_date: '05-77'}