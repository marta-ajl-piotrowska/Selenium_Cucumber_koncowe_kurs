Feature: Placing an order

    Scenario Outline: I can place an order
      Given I'm on shop's login page
      When I enter email "kaczka.w.rabarbarze@gmail.com" and pass "3*9[;+AMA{4yAbMNa]ntu[dzPvg:"
      And I go to shop's main page
      Then I can order Hummingbird Printed Sweater
#    And I verify if discount for it is 20%
      Then I can choose size <size>
      And I can choose quantity <quantity>
      Then I can add product to cart
      Then I can go to checkout
      And I can confirm shipping address
      And I can choose pickup method
      And I can choose payment method
      Then I can place an order
      And I take a screenshot "order.png"
##    Then I go to orders history
##    And I verify if my order is on the awaiting check payment list with valid cost
      And I close the browser
      Examples:
      |size| quantity|
      | M  | 5       |

