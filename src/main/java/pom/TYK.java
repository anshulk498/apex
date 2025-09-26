package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_utility.WebDriver_Utility;

public class TYK {
      public WebDriver driver;
      //TYK tyk=new TYK(driver);
      WebDriver_Utility wu=new WebDriver_Utility();
      
     //Actions act=new Actions(driver);
     public TYK(WebDriver driver) {
    	 this.driver=driver;
    	 PageFactory.initElements(driver, this);
     }
     
     @FindBy(xpath = "//span[contains(.,'Add Test')]") private WebElement addtest;
     
     @FindBy(xpath = "(//div[contains(@class,'rc-virtual-list-holder-inner')])[1]/div") private List<WebElement> dropdownListTaskLangauge;
     
     @FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div") private List<WebElement> dropdownListcategorytype;
     
     @FindBy(xpath = "//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'hidden'))]//div[@class='ant-select-item-option-content']") private List<WebElement> dropdownRequiredLanaguage;
     
     @FindBy(xpath = "//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'hidden'))]//div[@class='ant-select-item-option-content']") private List<WebElement> dropdown_Deadline;
     
     @FindBy(xpath = "(//div[@class='rc-virtual-list-holder-inner'])[4]/div") private List<WebElement> dropdownOccupation;
     
     @FindBy(xpath = "//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'hidden'))]//div[@class='ant-select-item-option-content']") private List<WebElement> dropdown_ExtendDeadline;
     
     @FindBy(xpath = "//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'hidden'))]//div[@class='ant-select-item-option-content']") private List<WebElement> dropdownSuper_Reviwer_Deadline;
     
     @FindBy(xpath = "//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'hidden'))]//div[@class='ant-select-item-option-content']") private List<WebElement> dropdownSuper_Reviwer_ExtendDeadline;
     
     @FindBy(xpath = "(//div[.='None'])[2]") private WebElement move_to_None;
     
     
     @FindBy(id="validateOnly_task_lang") private WebElement tasklanguage;
     
     @FindBy(xpath = "//span[.='Static']") private WebElement categorytype;
     
     @FindBy(id="validateOnly_description") private WebElement taskDescrtiontextArea;
     
     @FindBy(id="validateOnly_min_duration") private WebElement minduration;
     
     @FindBy(id="validateOnly_max_duration") private WebElement maxduration;
     
     @FindBy(id="validateOnly_coins") private WebElement addcoins;
     
     @FindBy(xpath = "(//div[@class='ant-select-selection-overflow'])[1]") private WebElement requiredLanguage;
     
     @FindBy(xpath = "(//div[@class='ant-select-selection-overflow'])[2]") private WebElement Occupation;
     
     @FindBy(xpath="//input[@aria-controls='rc_select_6_list']") private WebElement Deadline;
     
     @FindBy(xpath="//input[@aria-controls='rc_select_9_list']") private WebElement Extend_Deadline;
     
     @FindBy(xpath="//input[@aria-controls='rc_select_12_list']") private WebElement SuperReviwer_Deadline;
      
     @FindBy(xpath="//input[@aria-controls='rc_select_15_list']") private WebElement SuperReviwer_Extend_Deadline;
     
     @FindBy(xpath = "//button[@type='submit']") private WebElement create;
     
     
     public WebElement getMove_to_None() {
    	 return move_to_None;
     }
     public WebElement getAddTest() {
    	 return addtest;
     }
     
     public void clickOnAddTest(WebDriver driver) {
    	 addtest.click();
     }
     
     public WebElement getcategorytype() {
    	 return categorytype;
     }
     
     public void clickcategorytype(WebDriver driver) {
    	 categorytype.click();
     }
     
     
     public WebElement gettaskDescrtiontextArea() {
    	 return taskDescrtiontextArea;
     }
     
     public WebElement getTasklanguage() {
    	 return tasklanguage;
     }
     
     public void clicktasklanguage(WebDriver driver) {
    	 tasklanguage.click();
     }
     
     public WebElement getOccupation() {
    	 return Occupation;
     }
     
     public void clickOccupation(WebDriver driver) {
    	 Occupation.click();
     }

     
 
     
     public List<WebElement> getdropdownListTaskLangauge() {
    	 return dropdownListTaskLangauge;
     }
     
     public List<WebElement> getdropdownListcategorytype() {
    	 return dropdownListcategorytype;
     }
     
     public void selectdropdown(WebDriver driver,String text) {
    	 wu.dropdownHandling(driver, dropdownListTaskLangauge, text);
     }
     
     public void selectdropdownCategoryType(WebDriver driver,String text) {
    	 wu.dropdownHandling(driver, dropdownListcategorytype, text);
     }
     
     public void selectdropdownRequiredLanaguage(WebDriver driver,String text) {
    	 wu.dropdownHandling(driver, dropdownRequiredLanaguage, text);
     }
     
     public void selectdropdown_Deadline(WebDriver driver,String text) {
    	 wu.dropdownHandling(driver, dropdown_Deadline, text);
     }
     
     public void selectdropdown_ExtendDeadline(WebDriver driver,String text) {
    	 wu.dropdownHandling(driver, dropdown_ExtendDeadline, text);
     }
     
     public void selectdropdownOccupation(WebDriver driver,String text) {
    	 wu.dropdownHandling(driver, dropdownOccupation, text);
     }
     
     public void selectdropdownSuper_Reviwer_Deadline(WebDriver driver,String text) {
    	 wu.dropdownHandling(driver, dropdownSuper_Reviwer_Deadline, text);
     }
     
     public void dropdownSuper_Reviwer_ExtendDeadline(WebDriver driver,String text) {
    	 wu.dropdownHandling(driver, dropdownSuper_Reviwer_ExtendDeadline, text);
     }
	
     
     public void createTyk_ByAudio_Spantanous(WebDriver driver,String Task_Language,String Categorytype,String description,String Min_duration,String max_duration,String cost,String RequiredLangauge,String Occuption,String deadline,String extend_deadline,String sup_deadline,String sup_extend_deadline) throws Throwable {
    	 
    	clicktasklanguage(driver);
 		Thread.sleep(1000);
 		selectdropdown(driver, Task_Language);
 	    clickcategorytype(driver);
 	    Thread.sleep(1000);
 	    selectdropdownCategoryType(driver, Categorytype);
 		gettaskDescrtiontextArea().sendKeys(description);
 		minduration.click();
 		Thread.sleep(2000);
 		minduration.sendKeys(Min_duration);
 		maxduration.click();
 		Thread.sleep(2000);
 		maxduration.sendKeys(max_duration);
 		addcoins.sendKeys(cost);
		Thread.sleep(1000);
        requiredLanguage.click();
        Thread.sleep(2000); // wait for options to render

        
		
        
      
        
		selectdropdownRequiredLanaguage(driver, RequiredLangauge);
       
		clickOccupation(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		selectdropdownOccupation(driver, Occuption);
 	
 		js.executeScript("arguments[0].scrollIntoView(true);", create);
 		Deadline.click();
 		Thread.sleep(1000);
 		
 		selectdropdown_Deadline(driver, deadline);
 		Extend_Deadline.click();
 		Thread.sleep(1000);
 		selectdropdown_ExtendDeadline(driver, extend_deadline);
 		SuperReviwer_Deadline.click();
 		Thread.sleep(1000);
 		selectdropdownSuper_Reviwer_Deadline(driver, sup_deadline);
 		SuperReviwer_Extend_Deadline.click();
 		Thread.sleep(1000);
 		selectdropdownSuper_Reviwer_Deadline(driver, sup_extend_deadline);
 		create.click();
 		
     }
     
     
}
