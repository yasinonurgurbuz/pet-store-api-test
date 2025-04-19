Feature: Store Tests
  Tests for pet store api about store

  Scenario Outline: Create and retrieve store order
    Given create store order with given information <id> <petId> <quantity> <shipDate> <status> <complete>
    When get order by orderId <id>
    Then check the results for given <id>
    Examples:
      | id | petId | quantity | shipDate              | status    | complete   |
      | 47 | 47   | 1        | "2024-03-20T10:00:00" | "placed"   | "true"     |
      | 48 | 48   | 2        | "2024-03-21T11:00:00" | "approved" | "false"    |

  Scenario Outline: Create and delete store order
    Given create store order with given information <id> <petId> <quantity> <shipDate> <status> <complete>
    When delete order by orderId <id>
    Then verify order is deleted by trying to get <id>
    Examples:
      | id | petId | quantity | shipDate              | status    | complete   |
      | 49 | 49   | 1        | "2024-03-22T10:00:00" | "placed"   | "true"     |
      | 50 | 50   | 2        | "2024-03-23T11:00:00" | "approved" | "false"    |