Feature: Pet Tests
  Tests for pet store api about pets

  Scenario Outline: Create and retrieve pet
    Given create pet with given information <id> <name> <status> <photoUrls> <categoryName> <tagName>
    When get pet by petId <id>
    Then check the results for given <id> <name> <status>
    Examples:
      | id  | name     | status      | photoUrls                    | categoryName | tagName    |
      | 102 | "Takao"  | "available" | "https://example.com/Takao"  | "Dogs"       | "friendly" |
      | 101 | "Lolita" | "pending"   | "https://example.com/lolita" | "Cats"       | "sleepy"   |

  Scenario Outline: Create, update and verify pet
    Given create pet with given information <id> <name> <status> <photoUrls> <categoryName> <tagName>
    When update pet with new information <id> <newName> <newStatus> <newPhotoUrls> <newCategoryName> <newTagName>
    Then verify pet is updated with <id> <newName> <newStatus>
    Examples:
      | id  | name     | status      | photoUrls                    | categoryName | tagName    | newName    | newStatus     | newPhotoUrls                 | newCategoryName | newTagName  |
      | 103 | "Max"    | "available" | "https://example.com/max"    | "Dogs"       | "active"   | "Maximus"  | "pending"     | "https://example.com/maximus"| "Dogs"         | "loyal"     |
      | 104 | "Milo"   | "pending"   | "https://example.com/milo"   | "Cats"       | "playful"  | "Miles"    | "available"   | "https://example.com/miles"  | "Cats"         | "curious"   |

  Scenario Outline: Create, delete and verify pet deletion
    Given create pet with given information <id> <name> <status> <photoUrls> <categoryName> <tagName>
    When delete pet with petId <id>
    Then verify pet is deleted by trying to get <id>
    Examples:
      | id  | name     | status      | photoUrls                     | categoryName | tagName    |
      | 105 | "Rex"    | "available" | "https://example.com/rex"     | "Dogs"       | "loyal"    |
      | 106 | "Whiskers"| "pending"  | "https://example.com/whiskers"| "Cats"       | "playful"  |