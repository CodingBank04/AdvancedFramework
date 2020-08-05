Feature: Login Test

  @UI @Login @Smoke
  Scenario: Login
    Given I am on the MCengizLoginPage page
    When I wait for loadLogin to be visible
    Then I click on loadLogin
    Then I wait for 1000 milliseconds
    Then I enter "admin@staging-buffsci.org" in emailSection
    Then I wait for 1000 milliseconds
    Then I enter "admin123test" in passwordSection
    Then I wait for loginButton to be clickable
    Then I click on loginButton
    Then I validate current page url is "https://hr-staging.buffsci.org/home"
