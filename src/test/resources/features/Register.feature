Feature: Registration functionality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to Register Account page
    When User enters the details into below fields
      | firstName | Soufiane        |
      | lastName  | Faker           |
      | telephone |      1234567890 |
      | password  |           12345 |
    And User selects Privacy Policy
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates an account with all fields
    Given User navigates to Register Account page
    When User enters the details into below fields
      | firstName | Soufiane        |
      | lastName  | Faker           |
      | telephone |      1234567890 |
      | password  |           12345 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates a duplicate account
    Given User navigates to Register Account page
    When User enters the details into below fields with duplicate email
      | firstName | Soufiane        |
      | lastName  | Faker           |
      | email     | sfaker@yahoo.fr |
      | telephone |      1234567890 |
      | password  |           12345 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on continue button
    Then User should get a proper warning about duplicate email

  Scenario: User creates an account without filling any details
    Given User navigates to Register Account page
    When User dont enter any details into fields
    And User clicks on continue button
    Then User should get proper warning messages for every mandatory field
