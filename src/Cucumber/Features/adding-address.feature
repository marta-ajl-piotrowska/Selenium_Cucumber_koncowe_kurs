Feature: Adding another address to an account

    Scenario Outline: I can add another address to an account
      Given I'm on shop's login page
      When I enter email "kaczka.w.rabarbarze@gmail.com" and pass "3*9[;+AMA{4yAbMNa]ntu[dzPvg:"
      And I see tile Addresses
      Then I can add new address
      And I can enter full address alias <alias> address <address> city <city> code <code> country <country> and phone <phone>
      Then I can see that address is added
      And I verify created address alias <alias> address <address> city <city> code <code> country <country> and phone <phone>
      And I remove this address
      And I see that address is deleted
      Then I close the browser
      Examples:
      |alias| address| city| code| country| phone|
      |LND  | Lower Thames Street 78 |London | ECR 6DN | United Kingdom| 934569876|