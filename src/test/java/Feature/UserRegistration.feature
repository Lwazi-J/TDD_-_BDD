Feature: User Registration
  As a new user
  I want to register an account
  So that I can access the system

  Scenario: Successful user registration
    Given I have a valid email "test@example.com"
    And I have a valid password "password123"
    When I register a new account
    Then the registration should be successful
    And the user account should be active

  Scenario: Registration with invalid email
    Given I have an invalid email ""
    And I have a valid password "password123"
    When I register a new account
    Then the registration should fail with message "Email cannot be empty"

  Scenario: Registration with short password
    Given I have a valid email "test@example.com"
    And I have an invalid password "short"
    When I register a new account
    Then the registration should fail with message "Password must be at least 8 characters"
