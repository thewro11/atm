Feature: ATM
    Feature for ATM machine

  Scenario: User logs in with a valid bank account
    Given start the ATM machine
    Then user with bank account id "20250928001" should be able to log in
