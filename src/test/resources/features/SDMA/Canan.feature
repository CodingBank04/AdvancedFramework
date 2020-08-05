Feature: Canan tests
  @Canan @UI @Login @Test
    Scenario: Login
    Given I am on the CananHomePage page
    When I navigate to "https://hr-testing.buffsci.org" url
    When I wait for loadLogin to be visible
    Then I click on loadLogin
    Then I wait for 1000 milliseconds
    Then I enter "admin@staging-buffsci.org" in emailSection
    Then I wait for 1000 milliseconds
    Then I enter "admin123test" in passwordSection
    Then I wait for loginButton to be clickable
    Then I click on loginButton
    Then I validate current page url is "https://hr-testing.buffsci.org/home"


  @Canan @UI @SDMA2
    Scenario: Validate New Hire Pop-Up Window After Clicking New Hire Button.
    Given I am on the CananHomePage page
    When I navigate to "https://hr-testing.buffsci.org" url
    When I login
    Then I click on StaffButton
    Then I click on NewHireButton
    Then I wait for 1000 milliseconds
    Then I validate NewHireWindow is displayed

  @Canan @UI @SDMA6
    Scenario: Check Select Drop Down Elements on New Hire Page
    Given I am on the CananHomePage page
    When I navigate to "https://hr-testing.buffsci.org" url
    When I login
    Then I click on StaffButton
    Then I click on NewHireButton
    Then I wait for 1000 milliseconds
    Then I validate Select on New Hire drop down list below
    |-- Select --|
    |Ms.         |
    |Mrs.        |
    |Miss        |
    |Mr.         |
    |Dr.         |

  @Canan @UI @SDMA15
    Scenario: Check Select Drop Down Elements on Termination Page
    Given I am on the CananHomePage page
    When I navigate to "https://hr-testing.buffsci.org" url
    When I login
    Then I click on StaffButton
    Then I click on TerminationButton
    Then I wait for 1000 milliseconds
    Then I validate Select on Termination drop down list below
    |-- Select --                   |
    |Resignation                    |
    |Retirement                     |
    |Performance related termination|
    |Other                          |

    #As an admin, when I am on the Edit Basic Info Sub-Page, I want to be able to change the basic information of the worker and save the changes, So when I click the save button I can see it on the Basic Info Updated green Pop-Up Notification Box appear at the top on the right corner of the page.

  @Canan @UI @SDMA20
    Scenario: get green box after editing the basic staff info at Edit Basic Info Page
    Given  I am on the CananHomePage page
    When I navigate to "https://hr-testing.buffsci.org" url
    When I login
    Then I click on StaffButton
    Then I click on EditBasicInfoButton
    Then I wait for 1000 milliseconds
    Then I click on EditBasicInfoStatusActive
    Then I wait for 1000 milliseconds
    Then I select by index 4 from EditBasicInfoSalutation dropdown
    #Then I wait for 5000 milliseconds
    Then I enter "Betty" in EditBasicInfoFirstName
    Then I enter "C" in EditBasicInfoMiddleName
    Then I enter "Jackson" in EditBasicInfoLastName
    Then I wait for 1000 milliseconds
    Then I enter "0001" in EditBasicInfoPhoneExtension
    Then I wait for 1000 milliseconds
    Then I enter "300" in EditBasicInfoRoomNumber
    Then I wait for 1000 milliseconds
    #Then I enter "admin@staging-buffsci.org" in EditBasicInfoEmail
#    Then I wait for 1000 milliseconds
    Then I enter "betty@hotmail.com" in EditBasicInfoPersonalEmail
    Then I wait for 1000 milliseconds
    Then I enter "1000000000" in EditBasicInfoCellPhone
    Then I enter "/Users/canansaricelik/Desktop/Sonia.jpg" in EditBasicInfoPhotoUpload
    Then I wait for 2000 milliseconds
    Then I click on EditBasicInfoSave
    Then I wait for 1000 milliseconds
    Then I wait for BasicInfoUpdated to be visible
    Then I validate BasicInfoUpdated text is "Basic Info is updated"
    Then I wait for 5000 milliseconds

  @Canan @UI @SDMA21
    Scenario: Verify the Positions subpage
    Given I am on the CananHomePage page
    When I navigate to "https://hr-testing.buffsci.org" url
    When I login
    Then I click on PositionsButton
    Then I wait for PositionsSubPage to be visible
    Then I validate PositionsSubPage text is "Positions"

  @Canan @UI @SDMA4
    Scenario: Check if the New Worker is on the Staff List
    Given I am on the CananHomePage page
    When I navigate to "https://hr-testing.buffsci.org" url
    When I login
    Then I click on NewHireButton
    Then I select by index 4 from NewHireStatus dropdown
    Then I enter "TestF" in NewHireFirstName
    Then I enter "TestM" in NewHireMiddleName
    Then I enter "TestL" in NewHireLastName
    Then I select by index 3 from NewHireVacantPosition dropdown
    #Then I enter "test21@hotmail.com" in NewHireEmail
    Then I enter "personal@test.com" in NewHirePersonalEmail
    Then I enter "1111111111" in NewHireCellPhone
    Then I enter "/Users/canansaricelik/Desktop/Sonia.jpg" in NewHireImage
    Then I wait for NewHireImage to be visible
    Then I click on NewHireSave
    Then I wait for 3000 milliseconds
    Then I enter "TestF" in SearchByName
    Then I wait for 3000 milliseconds
    Then I validate NamesOnStaffPage text is "TestF T. TestL"

    @Canan @UI @SDMA23
      Scenario: Verify the sections on new positions sub page
      Given I am on the CananHomePage page
      When I navigate to "https://hr-testing.buffsci.org" url
      When I login
      Then I click on PositionsButton
      Then I click on AddNewPosition
      Then I wait for 2000 milliseconds
      Then I validate PositionTitleLabel text is "Title"
      Then I validate PositionAssignedStaffLabel text is "Assigned Staff"
      Then I validate PositionTypeLabel text is "Position Type"
      Then I validate PositionReportsToLabel text is "Reports To"
      Then I validate PositionLocationLabel text is "Location"
      Then I validate PositionSupervisorLabel text is "Supervisor"
      Then I validate PositionPostedLabel text is "Posted"
      Then I validate PositionAddNewNoteLabel text is "Add New Note"

    @Canan @UI @SDMA24
      Scenario: Verify the sections on Locations box on New positions sub page
      Given I am on the CananHomePage page
      When I navigate to "https://hr-testing.buffsci.org" url
      When I login
      Then I click on PositionsButton
      Then I click on AddNewPosition
      Then I wait for 2000 milliseconds
      Then I validate sections on Locations drop down list below
      |               |
      |BuffSci 2      |
      |District Office|
      |Elementary     |
      |High School    |
      |Middle School  |

    @Canan @UI @SDMA28
    Scenario: Verify the new added positions on position sub page
      Given I am on the CananHomePage page
      When I navigate to "https://hr-testing.buffsci.org" url
      When I login
      Then I click on PositionsButton
      Then I click on AddNewPosition
      Then I wait for 2000 milliseconds
      Then I enter "Test Title" in PositionTitle
      Then I select by index 15 from PositionAssignedStaff dropdown
      Then I click on ConfirmOk
      Then I wait for 1000 milliseconds
      Then I select by index 15 from PositionType dropdown
      Then I wait for 1000 milliseconds
      Then I select by index 4 from PositionReportsTo dropdown
      Then I wait for 1000 milliseconds
      Then I select by index 1 from PositionLocation dropdown
      Then I wait for 1000 milliseconds
      Then I click on PositionSupervisorYes
      Then I click on PositionPostedYes
      Then I enter "This is a test" in PositionAddNewNote
      Then I click on PositionSave
      Then I wait for 2000 milliseconds
      Then I validate StaffPositionIsSaved text is "Staff position is saved"
      Then I wait for 2000 milliseconds
      Then I enter "Test Title" in SearchUnderPosition
      Then I validate TitleUnderPosition text is "Test Title"

    @Canan @UI @SDMA41
    Scenario: Verify the elements on the Position-Location Drop Down Menu
      Given I am on the CananHomePage page
      When I navigate to "https://hr-testing.buffsci.org" url
      When I login
      Then I click on PositionsButton
      Then I wait for 2000 milliseconds
      Then I validate Select on Position Location drop down list below
      |- Select Location -|
      |BuffSci 2          |
      |District Office    |
      |Elementary         |
      |High School        |
      |Middle School      |


    @Canan @UI @SDMA42
    Scenario: Verify the the filter working on Position Location Drop Down Menu
      Given I am on the CananHomePage page
      When I navigate to "https://hr-testing.buffsci.org" url
      When I login
      Then I click on PositionsButton
      Then I wait for 2000 milliseconds
      Then I click one by one on given WebElement from  PositionLocationDropDown and validate the PositionLocationTable dropdown

    @Canan @UI @SDMA47
    Scenario: Verify the Positions Pop Up Page is Editable
      Given I am on the CananHomePage page
      When I navigate to "https://hr-testing.buffsci.org" url
      When I login
      Then I click on PositionsButton
      Then I click on AddNewPosition
      Then I wait for 2000 milliseconds
      #Creating a Position
      Then I enter "Test Title" in PositionTitle
      Then I select by index 15 from PositionAssignedStaff dropdown
      Then I click on ConfirmOk
      Then I wait for 1000 milliseconds
      Then I select by index 15 from PositionType dropdown
      Then I wait for 1000 milliseconds
      Then I select by index 4 from PositionReportsTo dropdown
      Then I wait for 1000 milliseconds
      Then I select by index 1 from PositionLocation dropdown
      Then I wait for 1000 milliseconds
      Then I click on PositionSupervisorYes
      Then I click on PositionPostedYes
      Then I enter "This is a test" in PositionAddNewNote
      Then I click on PositionSave
      Then I wait for 2000 milliseconds
      #Editing Part
      Then I click on PositionSearch
      Then I enter "Test Title" in PositionSearch
      Then I wait for 2000 milliseconds
      Then I click on PositionEditSign
      Then I validate EditPositionHeader is enabled
      Then I wait for 2000 milliseconds
      Then I enter "Test Title Edited" in PositionTitle
      Then I wait for 2000 milliseconds
      Then I select by index 1 from PositionAssignedStaff dropdown
      Then I wait for 2000 milliseconds
      Then I click on ConfirmOk
      Then I wait for 1000 milliseconds
      Then I select by index 2 from PositionType dropdown
      Then I wait for 1000 milliseconds
      Then I select by index 35 from PositionReportsTo dropdown
      Then I wait for 1000 milliseconds
      Then I select by index 2 from PositionLocation dropdown
      Then I wait for 1000 milliseconds
      Then I click on PositionSupervisorNo
      Then I click on PositionPostedNo
      Then I enter "This is a test editing" in PositionAddNewNote
      Then I click on PositionSave
      Then I wait for 2000 milliseconds
      #Validation
      Then I validate StaffPositionUpdated text is "Staff position is updated"
      #Revert Back
      Then I enter "Test Title Edited" in PositionSearch
      Then I click on PositionDelete
      Then I click on PositionDeleteConfirmOk
      Then I wait for 2000 milliseconds
      Then I validate StaffPositionDeleted text is "Staff position is deleted"

    @Canan @UI @SDMA53
    Scenario: Verify the Positions Type Page is Editable
      Given I am on the CananHomePage page
      When I navigate to "https://hr-testing.buffsci.org" url
      When I login
      Then I wait for PositionTypeButton to be clickable
      Then I click on PositionTypeButton
      Then I wait for 2000 milliseconds
      Then I wait for PositionTypeSearch to be visible
      Then I enter "Test" in PositionTypeSearch
      Then I wait for 2000 milliseconds
      Then I click on PositionTypeEditButton
      Then I wait for 2000 milliseconds
      Then I enter "Test Edited" in PositionTypeEditName
      Then I wait for 2000 milliseconds
      #TODO please take a look here again.
      Then I select by index 5 from PositionTypeEditStateCode dropdown
      Then I select by index 3 from PositionTypeEditBudgetCode dropdown
      Then I wait for 2000 milliseconds
      Then I enter "This test is edited" in PositionTypeEditDescription
      Then I click on PositionTypeEditSave
      Then I wait for 1000 milliseconds
      Then I validate PositionTypeUpdated text is "Position Type is updated"

    @Canan @UI @LoginApplicationModule
    Scenario: Verify login to application module
      Given I am on the CananHomePage page
      When I login to application module

    @Canan @UI @SDMA61
    Scenario: Verify the new profile page after click apply
      Given I am on the CananHomePage page
      When I login to application module
      Then I validate selectPositionToApply text is "Select a position to apply"
      Then I click on applyButton
      Then I wait for 2000 milliseconds
      Then I validate jobsHeader text is "Jobs"

    @Canan @UI @SDMA69
  Scenario: Verify the re-login functionality and the  profile info
    Given I am on the CananHomePage page
      When I login to application module
      Then I click on updateProfileButton
      Then I wait for inputFirstName to be visible
      Then I enter "test" in inputFirstName
      Then I click on saveProfileButton
      Then I click on logoutButton
      Then I wait for jobAppSignIn to be visible
      Then I login to application module
      Then I click on updateProfileButton
      Then I validate jobsHeader text is "Jobs"
      Then I validate inputFirstName text is "test"
      Then I validate inputLastName text is ""
      Then I click on NoRadioButtonAtProfile
      Then I validate inputAddress text is "123 Street "
      Then I validate inputCity text is "Utopia"
      Then I validate inputState text is "Colorado"
      Then I validate inputZipCode text is "00001"
      Then I validate inputEmail text is "test@email.com"
      Then I validate inputPhone text is "9999999999"

