Feature: insert product using using POST api

  Scenario Outline: validate post product api works correctly
    Given I hit the url of post products api endpoint
    When I pass the url of products in the request
    Then I pass the request body of product title <ProductTitle>
    Then I receive the response code as 200
    Examples:
      | ProductTitle |
      | 200  |