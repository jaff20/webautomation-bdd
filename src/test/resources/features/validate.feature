@Validate

  Feature: Verify and Validate the eshop (amazon) for the Given Test Scenarios

    Glue: ../src/main/java/com/amazon/step_definitions/HomePageGlue.java


  @AddItems
  Scenario Outline: Goto eShop (amazon), add two most expensive items to the shopping cart
    Given IsTest Runnable <RunMode>
    When Launch www.amazon.com page and validate PageHeader
    | Title |
    | Amazon.com |
    And Click on the login link
    And Provide correct username/password, Validate Home Page Header
      | username            | password  | title      |
      | jaff20@outlook.com  | Welcome1  | Amazon.com |
    Then Search for product
      | productName    |
      | iPhone x 64gb  |
    And click on <firstproduct> and move to product page
    Then capture product name, price and add <quantity> quantity to basket
    And Logout

    Examples:
      |RunMode|firstproduct | quantity |
      | Y     | 1           | 2        |