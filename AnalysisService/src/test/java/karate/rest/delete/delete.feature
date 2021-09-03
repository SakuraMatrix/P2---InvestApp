Feature: Create many Accounts...

  Background:
    * url baseUrl
    * def sellBase = '/stocks/2/sell/3'


  Scenario: Sell a stock
    Given path sellBase
    When method GET
    Then status 200
