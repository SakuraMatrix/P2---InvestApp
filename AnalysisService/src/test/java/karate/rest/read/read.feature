
Feature: Reads account/account information from the database...

  Background:
    * url baseUrl
    * def stocksBase = '/stocks/'



  Scenario: Read all stocks
    Given path stocksBase
    When method GET
    Then status 200
    And match response == [{id: 1, owned: 1, symbol: 'TEST', name: 'TEST', price: 5.0, changesPercentage: 5.0, change: 5.0, dayLow: 5.0, dayHigh: 5.0, yearHigh: 5.0, yearLow: 5.0, marketCap: 5.0, priceAvg50: 5.0,  priceAvg200: 5.0,  volume: 5.0, avgVolume: 5.0, exchange:'TEST',  open: 5.0, previousClose: 5.0, eps: 5.0,  pe: 5.0, earningsAnnouncement:'TEST', sharesOutstanding: 5.0, timestamp: 5.0, account_Id: 1}]

  Scenario: Read stocks for one account 
    Given path stocksBase + '1'
    When method GET
    Then status 200
    And match response == [{id: 1, owned: 1, symbol: 'TEST', name: 'TEST', price: 5.0, changesPercentage: 5.0, change: 5.0, dayLow: 5.0, dayHigh: 5.0, yearHigh: 5.0, yearLow: 5.0, marketCap: 5.0, priceAvg50: 5.0,  priceAvg200: 5.0,  volume: 5.0, avgVolume: 5.0, exchange:'TEST',  open: 5.0, previousClose: 5.0, eps: 5.0,  pe: 5.0, earningsAnnouncement:'TEST', sharesOutstanding: 5.0, timestamp: 5.0, account_Id: 1}]

 
