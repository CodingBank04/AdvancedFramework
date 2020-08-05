Feature: Zhannat tests

  //Background: User is logged in
   // Given I am on the MCengizLoginPage page
  //  When I login
  //  Then I am on the ZhannatHomePage

  @Zhannat @UI @Login @Test
  Scenario: Login
    Given I am on the ZhannatHomePage page
    When I wait for loadLogin to be visible
    Then I click on loadLogin
    Then I wait for 1000 milliseconds
    Then I enter "admin@staging-buffsci.org" in loginEmail
    Then I wait for 1000 milliseconds
    Then I enter "admin123test" in loginPassword
    Then I wait for loginButton to be clickable
    Then I click on loginButton
    Then I validate current page url is "https://hr-staging.buffsci.org/home"


  @SDMA#50 @PositionTypePage @UI @Zhannat
    Scenario: Navigate to Position Type Page
      Given I am on the MCengizLoginPage page
      When I login
      Then I am on the ZhannatHomePage page
      Then I click on positionTypesTab
      Then I wait for 1000 milliseconds
      Then I validate positionTypesTable is displayed
      Then I should see following columns on the Position Types Page
        |Name       |
        |State Code |
        |Budget Code|
        |Edit       |


  @SDMA#54 @PositionTypePage @UI @Zhannat
    Scenario: Add and Delete item on Position Types Page (for testing purpose I Add New Item)
    Given I am on the MCengizLoginPage page
    When I login
    Then I am on the ZhannatHomePage page
    Then I click on positionTypesTab
    Then I click on addNewButton
    Then I enter "SDMA54Test" in addNewNameSection
    Then I wait for 5000 milliseconds
    Then I click on saveButton
    Then I wait for 5000 milliseconds
    Then I click on positionTypesSearch
    Then I enter "SDMA54Test" in positionTypesSearch
    Then I click on editButton
    Then I click on deleteButton
    Then I validate alert page is displayed
    Then I validate alert page has option OK to delete entry
    Then I validate toastMessage text is "Position type is deleted"











