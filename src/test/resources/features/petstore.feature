Feature: CRUD Operations for pet endpoint

  @Create
  Scenario: When post a new pet should return ok with given pet
    Given request "newPet-request.json"
    When post to "/pet"
    Then status code should be 200
    And status field should be "available"

  @Read
  Scenario: When get pet endpoint with id should return given pet
    When get "/pet" wih pet id "/3"
    Then status code should be 200
    And id should be 3
    And status field should be "available"

  @Update
  Scenario: When put an exist pet should return ok with updated pet
    Given request "updatePet-request.json"
    When put to "/pet"
    Then status code should be 200
    And status field should be "available"

  @Delete
  Scenario: When delete an exist pet with id should return ok
    When delete to "/pet" with id "/1"
    Then status code should be 200
    And message field should be "1"

