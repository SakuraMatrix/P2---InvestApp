Feature: Reads Credit Card /creditcards information from the database...
  -Dio.netty.tryReflectionSetAccessible=true
  Background:
    * url baseUrl
    * def accountBase = '/creditcards/'

  Scenario: Read an Account
    Given path accountBase + '1'
    When method GET
    Then status 200
    And match response == {account_id: 1, card_num: '111111111111111' ,first_name: 'Rolando', last_name: 'Leiva', type: 'Discover', ccv: '012',  exp_date: '12-26'}

  Scenario: Read another Account
    Given path accountBase + '2'
    When method GET
    Then status 200
    And match response == {account_id: 2, card_num: '12345678912345' ,first_name: 'James',last_name: 'Bond', type: 'MasterCard', ccv: '007', exp_date: '10-21'}

  Scenario: Read a third Account
    Given path accountBase + '3'
    When method GET
    Then status 200
    And match response ==  {account_id: 3, card_num: '9876543210' ,first_name: 'Luke', last_name: 'Skywalker', type: 'Visa', ccv: '456', exp_date: '05-77'}


