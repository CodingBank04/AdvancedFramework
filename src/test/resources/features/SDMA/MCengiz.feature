Feature: MCengiz tests

  Background: User is logged in
    Given I am on the MCengizLoginPage page
    When I login
    Then I am on the MCengizStaffPage page


  @MCengiz  @UI @Staff @SDMA3
  Scenario: Check Add new hire info section
    When I click on newHireButton
    Then I validate all sections are present
         |Salutation:|
         |First Name:|
         |Middle Name:|
         |Last Name:|
         |Vacant Positions:|
         |Email:|
         |Personal Email:|
         |Cell Phone:|
         |file upload|


  @MCengiz  @UI @Positions  @SDMA22  @Smoke
  Scenario: Check Add new position popup page displayed
    Then I click on PositionsMenu
    And I click on AddNewPosition
    Then I wait for staffPositionForm to be visible
    Then I validate staffPositionForm is displayed

  @MCengiz  @UI @Staff @SDMA13
  Scenario: Validate job filter dropdown list
    Then I click on JobFilter
    Then I Validate the "jobFilterList" drop down list below
      |-- Job --|
      |PSR Teacher (5-8)|
      |Director of Guidance|
      |Administrative Staff|
      |Teacher - Sci - (9-12)|
      | |
      |IT Specialist|
      |Teacher - ELA - (9-12)|
      |Director of Special Projects|
      |Teacher - Elementary|
      |Teacher - SPED- (K-4)|
      |Receptionist|
      |Teacher - Reading Specialist (K-4)|
      |Data Coordinator|
      |Executive Director|
      |Teacher Aid (K-4)|
      |Teacher - Social (5-8)|
      |Teacher - Math - (5-8)|
      |Social Worker (K-4)|
      |Teacher - ENL|
      |Dean of Students|
      |Principal|
      |Support Teacher 5-8|
      |Cleaning Crew|
      |Teacher - Comp/Tech (9-12)|
      |Teacher - ELA - (5-8)|
      |Teacher - Math - (9-12)|
      |Teacher - Art -(9-12)|
      |Security/ Hall Monitor|
      |Substitute Teachers|
      |Teacher - Music -(5-8)|
      |Social Workers (9-12)|
      |Teacher - Spanish|
      |Teacher - SPED - (5-8)|
      |College Guidance|
      |Librarian (K-4)|
      |SPED Coordinator|
      |Teacher - Social - (9-12)|
      |Custodian|
      |Teacher - SPED - (9-12)|
      |HR Coordinator|
      |Teacher - Turkish|
      |Teacher - Comp/Tech (K-8)|
      |Teacher - Math Specialist (K-4)|
      |Operation / Business Manager|
      |Support Teacher K-4|
      |PSR Teacher (9-12)|
      |Nurse|
      |Teacher - PE (5-8)|
      |CFO|
      |Teacher - PE (9-12)|
      |Teacher - Art- (5-8)|
      |Director of Curr Ins|
      |IT Support|
      |Teacher - Specialty (K-4)|
      |Teacher - Sci - (5-8)|
      |Teacher - PE (K-4)|
      |Social Worker (5-8)|


  @MCengiz  @UI @Positions  @SDMA25
  Scenario: Validate New position popup page position types dropdown list
    Then I click on PositionsMenu
    And I click on AddNewPosition
    Then I click on NewPositionType
    Then I Validate the "newPositionsTypesList" drop down list below
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
      ||
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



  @MCengiz  @UI @Staff @SDMA14
  Scenario: Check termination pop up page is displayed
    Then I click on terminateButton
    Then I wait for terminatePopUp to be visible
    Then I validate terminatePopUp is displayed
    
  @MCengiz  @UI @Staff @SDMA10  @Smoke
  Scenario: Job filter department Validation.
    Then I validate when only selected department employee displayed

  @MCengiz  @UI @Staff  @SDMA18-1
  Scenario: Edit home address and confirm changes
    Then I click on sampleStaff
    Then I click on editHomeButton
    Then I enter "1234 maple street" in HomeAddressLine1
    Then I enter "apt 321" in HomeAddressLine2
    Then I enter "Buffalo" in HomeAddressCity
    Then I enter "14201" in HomeAddressZipCode
    Then I click on HomeAddressSaveButton
    Then I validate Home Address is changed
    Then I click on sampleStaff
    Then I click on editHomeButton
    Then I enter "1234 oak street" in HomeAddressLine1
    Then I enter "apt 123" in HomeAddressLine2
    Then I enter "New York" in HomeAddressCity
    Then I enter "10118" in HomeAddressZipCode
    Then I click on HomeAddressSaveButton
    Then I validate Home address reverted

  @MCengiz  @UI @Staff @SDMA18-2
  Scenario: Edit basic info and confirm changes
    Then I click on sampleStaff
    Then I click on EditBasicInfoButton
    Then I click on EditBasicInfoStatusSelect
    Then I click on EditBasicInfoStatusInactive
    Then I click on EditBasicInfoSalutationSelect
    Then I click on EditBasicInfoSalutationMs
    Then I enter "Jane" in EditBasicInfoFirstName
    Then I enter "Emily" in EditBasicInfoMiddleName
    Then I enter "Brown" in EditBasicInfoLastName
    Then I enter "1651" in EditBasicInfoPhoneExtension
    Then I enter "182" in EditBasicInfoRoom
    Then I enter "jbrown@buffaloscience.org" in EditBasicInfoEmail
    Then I enter "jbrown@gmail.com" in EditBasicInfoPersonalEmail
    Then I enter "7778885566" in EditBasicInfoCellPhone
    Then I click on EditBasicInfoSaveButton
    #validate
    Then I wait for 2000 milliseconds
    Then I validate BasicInfoStatus text is "Inactive"
    Then I validate BasicInfoFirstName text is "Jane E. Brown"
    Then I validate BasicInfoPhoneExtension text is "1651"
    Then I validate BasicInfoRoom text is "182"
    Then I validate BasicInfoEmail text is "jbrown@buffaloscience.org"
    Then I validate BasicInfoPersonalEmail text is "jbrown@gmail.com"
    Then I validate BasicInfoCellPhone text is "(777) 888-5566"
    #Revert info
    Then I click on EditBasicInfoButton
    Then I click on EditBasicInfoStatusSelect
    Then I click on EditBasicInfoStatusActive
    Then I click on EditBasicInfoSalutationSelect
    Then I click on EditBasicInfoSalutationMr
    Then I enter "John" in EditBasicInfoFirstName
    Then I enter "Michael" in EditBasicInfoMiddleName
    Then I enter "Doe" in EditBasicInfoLastName
    Then I enter "1561" in EditBasicInfoPhoneExtension
    Then I enter "281" in EditBasicInfoRoom
    Then I enter "jdoe@buffaloscience.org" in EditBasicInfoEmail
    Then I enter "jdoe@gmail.com" in EditBasicInfoPersonalEmail
    Then I enter "8887776655" in EditBasicInfoCellPhone
    Then I click on EditBasicInfoSaveButton
    #validate Revert
    Then I wait for 2000 milliseconds
    Then I validate BasicInfoStatus text is "Active"
    Then I validate BasicInfoFirstName text is "John M. Doe"
    Then I validate BasicInfoPhoneExtension text is "1561"
    Then I validate BasicInfoRoom text is "281"
    Then I validate BasicInfoEmail text is "jdoe@buffaloscience.org"
    Then I validate BasicInfoPersonalEmail text is "jdoe@gmail.com"
    Then I validate BasicInfoCellPhone text is "(888) 777-6655"


  @MCengiz @Rest
  Scenario: get staff info by staff ID

    Given I store parameters in userId map
      | staff_id| 67986|

    Given I verify getService for "SDMA" has status 200 on "getStaffInfo" with header params "", path params "userId", query params "", form params "", auth "", body ""

    Then I verify rest response data for SDMA
      | room       | 744           |
      | full_name  | Douglas Fox   |
      | location   | High School   |
      | job        | Teacher - ENL |

  @MCengiz @Rest
  Scenario: get self info

    Given I verify getService for "SDMA" has status 200 on "getSelfInfo" with header params "", path params "", query params "", form params "", auth "", body ""
    Then I verify rest response data for SDMA
      | room       |300                 |
      | full_name  |Betty C. Jackson    |
      | location   | District Office    |
      | job        | Executive Director |

  @MCengiz @Rest
  Scenario: get staff list 1

    Given I verify getService for "SDMA" has status 200 on "getStaffList" with header params "", path params "", query params "", form params "", auth "", body ""

    Then I verify rest response data for SDMA
      |staff_list.id[0]          |67986         |
      | staff_list.full_name[0]  | Douglas Fox  |
      | staff_list.location[0]   | High School  |
      | staff_list.job[0]        | Teacher - ENL|

  @MCengiz @Rest
  Scenario: get staff list 2

    Given I verify getService for "SDMA" has status 200 on "getStaffList" with header params "", path params "", query params "", form params "", auth "", body ""

    Then I verify rest response data contains for "SDMA"
      |{"id":67986,"full_name":"Douglas Fox","location":"High School","job":"Teacher - ENL"}          |
      |{"id":78213,"full_name":"Amanda Daly","location":"High School","job":"Teacher - ELA - (9-12)"} |


  @MCengiz @Rest
  Scenario: Post new Staff

    Given I store parameters in postBody map
  |email       |mjackson32@buffaloscience.org |
  |position_id |123                         |
  |salutation  |Mr.                         |
  |first_name  |Michael                     |
  |middle_name |Joseph                      |
  |last_name   |Jackson                     |
  |cell_phone  |7754483302                  |

    Given I verify postService for "postNewStaff" has status 200 on "postNew" with header params "", path params "", query params "", form params "postBody", auth "", body ""
    Then I verify "postNewStaff" postMethod created data with "postBody"
    Then I delete "postNewStaff" staff


  @MCengiz  @UI @Positions  @SDMA29
  Scenario: Validate search box in positions page
    Then I click on PositionsMenu
    Then I validate searchBoxInPositions is displayed
    Then I enter "Teacher - SPED- (K-4)" in searchBoxInPositions
    Then I validate positionsTitle text is "Teacher - SPED- (K-4)"














