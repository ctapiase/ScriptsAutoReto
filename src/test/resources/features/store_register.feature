Feature: register test

  @Register
  Scenario Outline: Successful Registration
    Given the user is on the registration page
    When the user enters the registration form data
      | username   | password   |
      | <username> | <password> |
    Then the system should display the message <message>
    Examples:
      | username                    | password     | message                                |
      | 11112us3r111ddgd7f2ds1sdwd1 | Password123! | Sign up successful.                    |
      | 11112us3r111ddgd7f2ds1sdwd1 | Password123! | This user already exist.               |
      |                             |              | Please fill out Username and Password. |

  @Login
  Scenario: Successful Login
    Given the user is on the login page
    When the user enters the login form data
      | username          | password     |
      | us3r111ddg72ds1sw | Password123! |
    Then the system should display in the Home Page the message "Welcome us3r111ddg72ds1sw"

  @Logino
  Scenario Outline: Failed Login
    Given the user is on the login page
    When the user enters the login form data
      | username   | password   |
      | <username> | <password> |
    Then the system should display the message <message>
    Examples:
      | username          | password      | message                               |
      | us3r111ddg72ds1sw | Password1233! | Sign up successful.                   |
      |                   | Password123!  | Please fill out Username and Password |

