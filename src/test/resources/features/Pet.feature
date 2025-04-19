Feature: Pet Tests
  Tests for pet store api about pets


  Scenario Outline: Create and retrieve pet
    Given create pet with given information <id> <name> <status> <photoUrls> <categoryName> <tagName>
    When get pet by petId <id>
    Then check the results for given <id> <name> <status>
    Examples:
      | id  | name     | status      | photoUrls                    | categoryName | tagName    |
      | 100 | "Takao"  | "available" | "https://example.com/Takao"  | "Dogs"       | "friendly" |
      | 101 | "Lolita" | "pending"   | "https://example.com/lolita" | "Cats"       | "sleepy"   |