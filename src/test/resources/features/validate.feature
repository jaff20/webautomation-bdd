@Validate

  Feature: Verify and Validate favourite e-shop (Amazon) for the Given Test Scenarios

    Glue: ../src/main/java/com/eshop/step_definitions/HomePageGlue.java

    @AddQuantity
    Scenario Outline: Goto favourite eShop (amazon.com) and navigate to some category and add two most expensive items to the shopping cart
      Given IsTest Runnable <RunMode>
      When Launch www.amazon.com page and validate PageHeader
        | Title |
        | Amazon.com |
      And Click on the login link
      And Provide correct username/password, Validate Home Page Header
        | username            | password  | title      |
        | jaff20@outlook.com  | Welcome1  | Amazon.com |
      Then Search for product
        | productName   |
        | iphone x 64gb |
      #And click on <firstproduct> and move to product page
      #Then capture product name, price and add <quantity> quantity to basket

      Examples:
        |RunMode| firstproduct | quantity |
        | Y     | 1            | 1        |