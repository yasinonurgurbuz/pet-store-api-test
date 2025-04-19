Feature:User Tests
  Tests for pet store api about user

  Scenario Outline: Create a new user
    Given create user with given information <id> <username> <firstName> <lastName> <e-mail> <phone> <password> <userStatus>
    When get user by <username>
    Then check the results for given <firstName> <lastName> <e-mail>
    Examples:
      | id | username          | firstName    | lastName | e-mail                      | phone         | password   | userStatus |
      | 1  | "yasinonurgurbuz" | "Yasin Onur" | "Gurbuz" | "yasinonurgurbuz@gmail.com" | "5369119511"  | "248191"   | 1          |
      | 2  | "tulaygurbuz"     | "Tulay"      | "Gurbuz" | "tulaygurbuz@gmail.com"     | "5369119512"  | "248123"   | 2          |
      | 3  | "lolitagurbuz"    | "Lolita"     | "Gurbuz" | "lolitagurbuz@gmail.com"    | "5369119513"  | "248194"   | 3          |

  Scenario: Create a new user with given array
    Given create users with given array of user
    When get one of user
    Then check the results for given user

  Scenario Outline: Update information about user
    Given create user with given information <id> <username> <firstName> <lastName> <e-mail> <phone> <password> <userStatus>
    And login with <username> <password>
    When update user information with the <id> <username> <secondFirstName> <lastName> <e-mail> <phone> <password> <userStatus>
    Then check the results for given <username> <secondFirstName>
    Examples:
      | id | username      | firstName  | lastName   | e-mail                  | phone         | password   | userStatus | secondFirstName |
      | 1  | "fatihyildiz" | "Fatih"    | "Yildiz"   | "fatihyildiz@gmail.com" | "5369119514"  | "248196"   | 1          |  "Tolga"        |
      | 2  | "gulyildirim" | "Gul"      | "Yildirim" | "gulyildirim@gmail.com" | "5369119515"  | "248127"   | 2          |  "Selma"        |

  Scenario Outline: Delete user
    Given create user with given information <id> <username> <firstName> <lastName> <e-mail> <phone> <password> <userStatus>
    When delete user with <username>
    Then verify user is deleted by trying to get <username>
    Examples:
      | id | username      | firstName  | lastName   | e-mail                  | phone         | password   | userStatus |
      | 1  | "testuser1"   | "Test"     | "User1"    | "testuser1@gmail.com"   | "5369119516"  | "248198"   | 1          |
      | 2  | "testuser2"   | "Test"     | "User2"    | "testuser2@gmail.com"   | "5369119517"  | "248199"   | 2          |