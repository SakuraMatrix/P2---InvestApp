Feature: Deletes Accounts from the database

  Background:
    * url baseUrl
    * def deleteUrl = '/accounts/delete/'
    * def accountSetup = call read('classpath:create.feature')

  Scenario: Delete account number 1
    Given deleteUrl + '1'
    When method DELETE
    And response 200

  Scenario: Delete account number 2
    Given deleteUrl + '2'
    When method DELETE
    And response 200

  Scenario: Delete account number 3
    Given deleteUrl + '3'
    When method DELETE
    And response 200
