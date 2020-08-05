package stepDefs;

import PageFactory.KadirHomePage;
import Utilities.AutomationContext;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KadirStepDefs {
   AutomationContext context;
   public KadirStepDefs(AutomationContext context){
      this.context = context;
   }

   /**  step to validate keyword search on table with 3 columns
    * @param keyWord
    * @param tableNm
    */
   @Then("I validate \"([^\"]*)\" on the result table of (\\w+)$")
   public void i_validate_on_the_result_table_of_positionTypeTable(String keyWord, String tableNm) throws Exception {

      WebElement table = (WebElement)
      WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(),tableNm);
      WebElement tP = KadirHomePage.getPositionTypeTableResultDropdown;
      //to find the result table has many rows
      int row = 0;
      //String show = KadirPage.
      String show = KadirHomePage.positionTypeShowNumber.getText();

      show = show.replaceAll("[^0-9]+"," ");

      List<String> list1 = Arrays.asList(show.trim().split(" "));

      List<Integer> list2 = new ArrayList<>();

      for(String s : list1){
         int i = Integer.parseInt(s);
         list2.add(i);
      }
      Collections.sort(list1);
      row = list2.get(list2.size()-2);
      System.out.println("rowNumber: " + row);

      //putting the result table in the List with each column has own list
      List<WebElement> listclmn1 = new ArrayList<>();
      List<WebElement> listclmn2 = new ArrayList<>();
      List<WebElement> listclmn3 = new ArrayList<>();
         for(int i=1; i<= row; i++){
            listclmn1.add(table.findElement(By.xpath("tr[" + i + "]/td[1]")));
            listclmn2.add(table.findElement(By.xpath("tr[" + i + "]/td[2]")));
            listclmn3.add(table.findElement(By.xpath("tr[" + i + "]/td[3]")));
         }
      try{
         int count = 0;
         if (row != 0){
            boolean b1 = false;
            boolean b2 = false;
            boolean b3 = false;
            for(int i=0; i<row; i++){
               count = 0;
               b1=listclmn1.get(i).getText().toLowerCase().contains(keyWord.toLowerCase());
               b2=listclmn2.get(i).getText().toLowerCase().contains(keyWord.toLowerCase());
               b3=listclmn3.get(i).getText().toLowerCase().contains(keyWord.toLowerCase());
                     if(b1||b2||b3){
                        count++;
                     }
                     try {
                        if (count != 0 ){
                           context.getScenarioManager().getScenario().write((i+1)+ ". Pass; \n Expected: " + keyWord + "\n" +
                                   "Actual: " + listclmn1.get(i).getText() + " | " + listclmn2.get(i).getText() + " | "
                            + listclmn3.get(i).getText());
                        }
                        else {
                           context.getScenarioManager().getScenario().write(" Failed; \n Expected: " +
                                   keyWord + " \n Not found in at least one results of the table row");
                        }
                     }catch (Exception e){
                        context.getScenarioManager().getScenario().write("Not able to find " + keyWord + " in results");
                     }
            }
         }
         else {
            context.getScenarioManager().getScenario().write(" there is no any result to filtered!");
         }
      }catch (Exception e){
         throw new Exception("there is no result! " + e.getMessage());
      }

   }

}