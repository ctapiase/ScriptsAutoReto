Feature: Register and LogIn
  Me as a user
  I want to validate the login and registration forms
  To validate outgoing messages

  @Register
  Scenario Outline: Successful Registration
    Given the user is on the registration page
    When the user enters the registration form data
      | username   | password   |
      | <username> | <password> |
    Then the system should display the message <message>
    Examples:
      | username                        | password     | message                                |
      | 111112us3r111ddgd7f2ds1sdwd1212 | Password123! | Sign up successful.                    |
      | 111112us3r111ddgd7f2ds1sdwd1212 | Password123! | This user already exist.               |
      |                                 |              | Please fill out Username and Password. |

  @Login
  Scenario: Successful Login
    Given the user is on the login page
    When the user enters the login form data
      | username                        | password     |
      | 111112us3r111ddgd7f2ds1sdwd1212 | Password123! |
    Then the system should display in the Home Page the message "Welcome 111112us3r111ddgd7f2ds1sdwd1212"

  @Login
  Scenario Outline: Failed Login
    Given the user is on the login page
    When the user enters the login form fail data
      | username   | password   |
      | <username> | <password> |
    Then the system should display the message <message>
    Examples:
      | username                        | password      | message                                |
      | 111112us3r111ddgd7f2ds1sdwd1212 | Password1233! | Wrong password.                        |
      |                                 | Password123!  | Please fill out Username and Password. |

