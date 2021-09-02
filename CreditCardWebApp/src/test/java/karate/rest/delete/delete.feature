Feature: Deletes Credit Cards from the database
  -Dio.netty.tryReflectionSetAccessible=true
  Background:
    * url baseUrl
    * def deleteUrl = '/creditcards/delete/'

  Scenario: Delete account number 1
    Given path deleteUrl +'1'
    When method DELETE
    And status 200

  Scenario: Delete account number 2
    Given path deleteUrl +'2'
    When method DELETE
    And status 200

  Scenario: Delete account number 3
    Given path deleteUrl + '3'
    When method DELETE
    And status 200