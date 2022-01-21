Feature: User Operations

  @Get
  Scenario: When get user endpoint validated response status and data sizing
    When get "/api/users"
    Then status code should be 200
    And current page should be 1
    Then per_page value should be 6
    And data list must have 6 element

  @Get @SchemaValidation
  Scenario: When get user with id endpoint validated response schema
    When get "/api/users/1"
    Then status code should be 200
    And response schema must be same as "get-UserWithId-ResponseSchema.json"

  @Get
  Scenario: When get user with page parameter validated response status and paging
    Given set query parameter as name "page" value "2"
    When get "/api/users"
    Then status code should be 200
    And current page should be 2
    Then per_page value should be 6
    And data list must have 6 element
