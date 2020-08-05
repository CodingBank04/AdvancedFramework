Feature: Sabire tests

  @SKaya @UIfunctionality @Test-1
  Scenario: Login
    Given I am on the  MCengizLoginPage page
    When I wait for loadLogin to be visible
    Then I click on loadLogin
    Then I wait for 1000 milliseconds
    Then I enter "admin@staging-buffsci.org" in emailSection
    Then I wait for 1000 milliseconds
    Then I enter "admin123test" in passwordSection
    Then I wait for loginButton to be clickable
    Then I click on loginButton
    Then I validate current page url is "https://hr-staging.buffsci.org/home"

  @SKaya @BuffsciMenuandLinks @TC1
  Scenario: Home Page menu links
    Given I am on the MCengizLoginPage page
    When I login
    Then I am on the SabireHomePage page
    And I want to see menu options
    Then I validate all menu sections are present

  @SKaya @BuffSciLocation @TC2
  Scenario Outline: Location Sub-Page
    Given I am on the MCengizLoginPage page
    When I login
    Then I am on the SabireHomePage page
    Then I validate "--Location--" button under Staff List
    Then I click on Location Box button
    Then I validate all  are present "<--Location-->"
    Examples:
      | --Location--    |
      | Middle School   |
      | District Office |
      | High School     |
      |                 |
      | Elementary      |
      | BuffSci2        |

  @SKaya @BuffSciPositionType @TC4
  Scenario: Position Type Sub check the edit position
    Given I am on the MCengizLoginPage page
    When I login
    Then I am on the SabireHomePage page
    Then I want to click on Position type part
    Then I validate Position Type Sub-page  is displayed
    Then I want to click on edit botton
    Then I validate pop-up page which has options
    Then I click on delete button
    Then I validate pop-up page is displayed

  @SKaya @BuffSciePositionEditButton @TC3
  Scenario: Position Edit Button check
    Given I am on the MCengizLoginPage page
    When I login
    Then I am on the SabireHomePage page
    Then I click on any name on the staff list
    Then I validate edit Basic Info Button
    Then I click on Edit Basic Info Button and validate it with basic info of worker


  @SKaya @BuffSciiPositionFilterClear @TC5
  Scenario: Position filter clear in the edit position
    Given I am on the MCengizLoginPage page
    When I login
    Then I am on the SabireHomePage page
    Then I click on Position Link under the Menu
    Then I click on Select Location and validate it
    Then I click on select Position and validate it
    Then I click on select status and validate it
    Then I click on Clear Filter Button
    Then I validate all selections are clear

  @SKaya @BuffSciiPositonSearchBox @TC6
  Scenario Outline: Search Box Check in the Position Page
    Given I am on the MCengizLoginPage page
    When I login
    Then I am on the SabireHomePage page
    Then I click on Position Link under the Menu
    Then I see searchBox button on the Position page
    Then I enter one by one the "<Position Type>" on the search box and validate them on  dataTable list
    Then I refresh current page
    Then I enter one by one the "<Position Type>" on the search box and validate them on  dataTable list
    Examples:
      | Position Type |
      | Teacher       |
      | IT Support    |
      | Principal     |


  @SKaya @TC8
  Scenario: Sign up and registration for new applicants
    Given I am on the SabireHomePage page
    Then I wait for signUpButton to be visible
    Then I click on signUpButton
    Then I wait for 2000 milliseconds
    Then I enter "Ali Veli" in firstNameOnSignUp
    Then I enter "Kim bu" in lastNameOnSignUp
    Then I enter "aliveli49/50@gmail.com" in emailOnSignUp
    Then I enter "20070022Scm." in passwordOnSignUp
    Then I enter "20070022Scm." in confirmPasswordOnSignUp
    Then I wait for 2000 milliseconds
    Then I click on registration
    Then I validate the new page is displayed


  @SKaya @BuffSciiEditDetails @TC7
  Scenario: Edit Details check in Staff Page
    Given I am on the SabireHomePage page
    When I login
    Then I am on the SabireHomePage page
    Then I click on staff
    Then I wait for 2000 milliseconds
    Then I validate details Button and click on details
    Then I wait for 2000 milliseconds
    Then I validate editDetails Box and click on editDetails
    Then I wait for 7000 milliseconds
    Then I validate pop-up page is displayed
    Then I wait for 7000 milliseconds
    Then I update an information on pop up page
    Then I wait for 7000 milliseconds
    Then I click on save button



