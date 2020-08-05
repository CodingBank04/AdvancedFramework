Feature: Benjamin tests

    @SDMA-59
    Scenario: Validating the landing page
      Given I am on the Benjamin_HomePage page
      Then I click on signUpButton
      Then I validate current page url is "https://apply-staging.buffsci.org/register"
      Then I validate jobApplicationTitle is displayed
      Then I validate signUpWithGoogleButton is displayed
      Then I validate registerButton is displayed
      Then I validate signUpHeader is displayed
