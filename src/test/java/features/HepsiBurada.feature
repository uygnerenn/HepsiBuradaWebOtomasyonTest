@SelectProduct

Feature: UI Test Automation for Hepsiburada

  @SelectProduct
  Scenario: Add the highest-priced Apple tablet to the cart and verify the price
    Given The user navigates to hepsiburada
    When The user selects elektonik>Bilgisayartablet>Tablet category
    And The user applies filters
    And The user clicks on the most expensive product without using the sorting filter
    And The user clicks the Add to Cart button on the product detail page
    Then The user verifies that the product is added to the cart
    And The user verifies that the price in the cart matches the product detail page
