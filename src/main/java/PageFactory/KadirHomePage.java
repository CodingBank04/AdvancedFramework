package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class KadirHomePage {
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Position Types')]")
    public static WebElement positionTypes;

    @FindBy(how = How.XPATH, using = "//input[@type='search']")
    public static WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//table[@id='DataTables_Table_0']/tbody")
    public static WebElement positionTypeTable;

    @FindBy(how = How.CSS, using = "//div[@id='DataTables_Table_0_paginate']/ul")
    public static WebElement positionTypeTableResultPage;

    @FindBy(how = How.XPATH, using = "//div[@id='DataTables_Table_0_info']")
    public static WebElement positionTypeShowNumber;

    @FindBy(how = How.XPATH, using = "//select[@name='DataTables_Table_0_length']")
    public static WebElement getPositionTypeTableResultDropdown;

}
