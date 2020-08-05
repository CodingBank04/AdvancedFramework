Feature: Yasin tests
  @Ykaya @YKlogin
  Scenario: Main Login
    Given I am on the YasinHomePage page
    When I wait for loadLogin to be visible
    Then I click on loadLogin
    Then I wait for 1000 milliseconds
    Then I enter "admin@staging-buffsci.org" in emailSection
    Then I wait for 1000 milliseconds
    Then I enter "admin123test" in passwordSection
    Then I wait for loginButton to be clickable
    Then I click on loginButton
    Then I wait for 1000 milliseconds
    Then I validate current page url is "https://hr-staging.buffsci.org/home"

  @Ykaya @YKlogin
  Scenario: Main Top Login
    Given I am on the YasinHomePage page
    When I wait for topLoadButton to be visible
    Then I click on topLoadButton
    Then I wait for 1000 milliseconds
    Then I enter "admin@staging-buffsci.org" in emailSection
    Then I wait for 1000 milliseconds
    Then I enter "admin123test" in passwordSection
    Then I wait for loginButton to be clickable
    Then I click on loginButton
    Then I validate current page url is "https://hr-staging.buffsci.org/home"

  @SDMA40 @Ykaya
  Scenario:I want to see Positions Page with positions listed on the page.
    Given I am on the YasinHomePage page
    When I login
    Then I wait for positionsTabButton to be visible
    And I click on positionsTabButton
    Then I wait for positionTabSelectPositionsDropDown to be visible
    And I click on positionTabSelectPositionsDropDown
    Then I validate the positionDropDownList with below
      |- Select Position -|
      |Administrative Staff|
      |Athletic Coach|
      |CFO|
      |Cleaning Crew|
      |College Guidance|
      |Custodian|
      |Data Coordinator|
      |Dean of Students|
      |Director of Curr Ins|
      |Director of Guidance|
      |Director of Special Projects|
      |Executive Director|
      |HR Coordinator|
      |IT Specialist|
      |IT Support|
      |Librarian (K-4)|
      |Nurse|
      |Operation / Business Manager|
      |Principal|
      |PSR Teacher (5-8)|
      |PSR Teacher (9-12)|
      |PSR Teacher (K-4)|
      |Receptionist|
      |Security/ Hall Monitor|
      |Social Worker (5-8)|
      |Social Worker (K-4)|
      |Social Workers (9-12)|
      |SPED Coordinator|
      |Substitute Teachers|
      |Support Teacher 5-8|
      |Support Teacher K-4|
      |Teacher - Art - (K-4)|
      |Teacher - Art -(9-12)|
      |Teacher - Art- (5-8)|
      |Teacher - Comp/Tech (9-12)|
      |Teacher - Comp/Tech (K-8)|
      |Teacher - ELA - (5-8)|
      |Teacher - ELA - (9-12)|
      |Teacher - Elementary|
      |Teacher - ENL|
      |Teacher - Math - (5-8)|
      |Teacher - Math - (9-12)|
      |Teacher - Math Specialist (K-4)|
      |Teacher - Music -(5-8)|
      |Teacher - Music -(9-12)|
      |Teacher - Music -(K-4)|
      |Teacher - PE (5-8)|
      |Teacher - PE (9-12)|
      |Teacher - PE (K-4)|
      |Teacher - Reading Specialist (K-4)|
      |Teacher - Sci - (5-8)|
      |Teacher - Sci - (9-12)|
      |Teacher - Social (5-8)|
      |Teacher - Social - (9-12)|
      |Teacher - Spanish|
      |Teacher - Specialty (K-4)|
      |Teacher - SPED - (5-8)|
      |Teacher - SPED - (9-12)|
      |Teacher - SPED- (K-4)|
      |Teacher - Turkish|
      |Teacher Aid (K-4)|
  @SDMA43 @Ykaya
  Scenario:I want to see Positions Page with positions listed on the page.
    Given I am on the YasinHomePage page
    When I login
    Then I wait for positionsTabButton to be visible
    And I click on positionsTabButton
    Then I click one by one on given WebElement form  positionDropDownList and validate the positionPageTable dropdown
  @SDMA46 @Ykaya
  Scenario:I want to add a new postion
    Given I am on the YasinHomePage page
    When I login
    Then I wait for positionsTabButton to be visible
    And I click on positionsTabButton
    Then I wait for addNewPositions to be visible
    And I click on addNewPositions
    Then I enter "KayaTest" in titleOnNewPosition
    Then I wait for positionTypeOnAddNewPosition to be visible
    Then I click on positionTypeOnAddNewPosition
    Then I wait for reportsToOnNewPosition to be visible
    Then I click on reportsToOnNewPosition
    Then I wait for locationOnNewPosition to be visible
    Then I click on locationOnNewPosition
    Then I wait for saveButtonOnNewPosition to be clickable
    Then I click on saveButtonOnNewPosition
    Then I enter "KayaTest" in searchBoxOnPositionPage
    Then I validate createdNewPositionTitle text is "KayaTest"
    Then I click on deleteCreatedPositionTitle
    Then I click on confirmToDelete









