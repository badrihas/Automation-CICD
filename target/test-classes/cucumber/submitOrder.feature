
@tag
Feature: Placing an order from Ecommerce website.
  I want to use this template for my feature file
  Background:
  Given I landed on Ecommerce page
  @tag2
  Scenario Outline: Positive test of submitting the order
    Given logged in with username <name> and password <password>
    When I added the product <productName> to the cart
    And checkout <productName> and submit the order
    Then "THANK YOU FOR THE ORDER" message is displayed on confirmationPage

    Examples: 
      | name              | password | productName|
      | bhavani@gmail.com | Badri@123| ZARA COAT3 |
    