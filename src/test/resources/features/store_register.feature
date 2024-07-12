Feature: Register and LogIn
  Me as a user
  I want to validate the login and registration forms
  To validate outgoing messages

  @Registerp
  Scenario Outline: Successful Registration
    Given the user are on home page
    When attempts to sign up
      | username   | password   |
      | <username> | <password> |
    Then the system should display the message <message>
    Examples:
      | username     | password     | message                                |
      | userlatamm12 | Password123! | Sign up successful.                    |
      | userlatamm12 | Password123! | This user already exist.               |
      |              |              | Please fill out Username and Password. |

  @Login
  Scenario: Successful Login
    Given the user are on home page
    When attempts to log in
      | username     | password     |
      | userlatamm12 | Password123! |
    Then the system should display in the Home Page the message "Welcome userlatamm12"

  @Login
  Scenario Outline: Failed Login
    Given the user are on home page
    When attempts to log in
      | username   | password   |
      | <username> | <password> |
    Then the system should display the message <message>
    Examples:
      | username     | password      | message                                |
      | userlatamm12 | Password1233! | Wrong password.                        |
      |              | Password123!  | Please fill out Username and Password. |

