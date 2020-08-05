Feature: Kadir tests

  Background: User is logged in
    Given I am on the MCengizLoginPage page
    When I login
    Then I am on the KadirHomePage page

  @Kadir  @UI @PositionType @SDMA-52
  Scenario: Verify the search box on the Position Page that works properly
    Then I wait for positionTypes to be clickable
    When I click on positionTypes
    Then I wait for searchBox to be visible
    Then I click on searchBox
    Then I enter "teacher" in searchBox
    Then I select by index 3 from getPositionTypeTableResultDropdown dropdown
    Then I validate "teacher" on the result table of positionTypeTable




