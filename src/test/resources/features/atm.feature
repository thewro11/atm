Feature: ATM
    Feature for ATM machine

  Scenario: User logs in with a valid bank account
    Given start the ATM machine
    Then user with bank account id "20250928001" should be able to log in

  Scenario Outline: Successful Deposits
    Given start the ATM machine
    When user logs in with bank account id "<bankAccountId>"
    Then user should deposit <money>THB into their bank account successfully

    Examples:
        | bankAccountId | money |
        | 20250928014 | 2000 |
        | 20250928014 | 300 |
        | 20250928014 | 25.50 |

  Scenario Outline: Fail deposits
    Given start the ATM machine
    When user logs in with bank account id "<bankAccountId>"
    Then user should not deposit <money>THB into their bank account

    Examples:
      | bankAccountId | money |
      | 20250928014 | 0 |
      | 20250928014 | -2000 |

  Scenario Outline: Successful Withdraws
    Given start the ATM machine
    When user logs in with bank account id "<bankAccountId>"
    Then user should withdraw <money>THB from their bank account successfully

    Examples:
      | bankAccountId | money |
      | 20250928014 | 100 |
      | 20250928014 | 150 |
      | 20250928014 | 500.50 |

  Scenario Outline: Fail Withdraws
    Given start the ATM machine
    When user logs in with bank account id "<bankAccountId>"
    Then user should not withdraw <money>THB from their bank account

    Examples:
      | bankAccountId | money |
      | 20250928014 | 0 |
      | 20250928014 | -20.20 |
      | 20250928014 | 20000000 |
