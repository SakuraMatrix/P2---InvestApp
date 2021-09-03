Feature: Testing Database Connectivity

  Background:
    * url  localhost:8080
    * def accountBase ='/loans'
  


  Scenario: Testing the GET landing page
    Given path 'hello'
    When method GET
    Then Status 200
    And match response == 'success'


  Scenario: testing the GET "all" end point
    Given path '/api/v0.1/Loans/vall/0'
    When method POST
    Then status 200

    * def first =response(0)

    Given path '/api/v0.1/loans/vall/10'>
    When method GET
    Then status 200

  Scenario: Testing the exact response of a GET endpoint
    Given path '/api/v0.1/loans/vall/08'
    When method GET
    Then status 200
    And match $ =={uid:"08"}
    
  Scenario: Create and account with account_id 123456789
    Given path '/loans/new/'
    And request {account_id:123456789 , loan_id: , timestamp: , loan_amount: 999000, purpose:'TESTING', gross_earning:249999, total_expenses:4999, loan_term:36, loan_status:'SUBMITTED', approved: FALSE}
    And header Accept = 'application/json'
    When method POST
    Then status 200
    And match response == ({account_id:123456789 , loan_id:UUID() , timestamp: toTIMESTAMP(NOW()), loan_amount: 999000, purpose:'TESTING', gross_earning:249999, total_expenses:4999, loan_term:36, loan_status:'SUBMITTED', approved: FALSE}

  Scenario: return the account_id: 123456789
    Given path '/loans/vall/0'
    And request {account_id:123456789 }
    And header Accept = 'application/json'
    When method POST
    Then status 200
    And match response == ({account_id:123456789 , loan_id:"" , timestamp: "", loan_amount: 999000, purpose:'TESTING', gross_earning:249999, total_expenses:4999, loan_term:36, loan_status:'SUBMITTED', approved: FALSE}



