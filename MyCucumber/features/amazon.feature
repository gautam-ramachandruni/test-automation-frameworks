Feature: Amazon Login and Search
  The scope of this feature is to log in and search products on Amazon

  Scenario: Amazon Login and Search
    Given I navigate to home page
    When I log in as user
    And I log out
    Then I search products to add to cart
    And I close the browser
