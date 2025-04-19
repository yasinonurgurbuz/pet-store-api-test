Feature:Fulfillment Tests
  Tests for pet store api

  Scenario Outline: Create a new user
    Given create user with given information <id> <username> <firstName> <lastName> <e-mail> <phone> <password> <userStatus>
    When get user by <username>
    Then check the results for given <firstName> <lastName> <e-mail>
    Examples:
      | id | username          | firstName    | lastName | e-mail                      | phone         | password   | userStatus |
      | 1  | "yasinonurgurbuz" | "Yasin Onur" | "Gurbuz" | "yasinonurgurbuz@gmail.com" | "5369119511"  | "248191"   | 1          |
      | 2  | "tulaygurbuz"     | "Tulay"      | "Gurbuz" | "tulaygurbuz@gmail.com"     | "5369119512"  | "248123"   | 2          |
      | 3  | "lolitagurbuz"    | "Lolita"     | "Gurbuz" | "lolitagurbuz@gmail.com"    | "5369119513"  | "248194"   | 3          |