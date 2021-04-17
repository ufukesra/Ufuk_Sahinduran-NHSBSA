@nhsChecker

  Feature: Nhs Checker

    Scenario: As a person from Wales I need to know what help I can get NHS costs So that I can get the threatment I need
      Given Navigate landing page and verify it then click start button
      And Select "Wales" as country where you live
      When I put my following Circumstances into Checker tool

     |What is your date of birth?                                      |10/03/2000                               |
     |Do you live with a partner?                                      |Yes                                      |
     |Do you or your partner claim any benefits or tax credits?        |Yes                                      |
     |Do you or your partner get paid Universal Credit?                |Yes, we receive Universal Credit payments|
     |As part of your joint Universal Credit, do you have any of these?|Yes                                      |
     |Did you and your partner have a combined take-home pay of £935 or less in your last Universal Credit period?| Yes                                        |

      Then I should get a result of whether I will get help or not


    Scenario: As auser I should't be able to continue unless selecting my country
      Given Navigate landing page and verify it then click start button
      When click next button
      Then verify error text "There is a problem" and error type "Select the country you live in"