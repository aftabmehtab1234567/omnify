package Pageobject;

import org.testng.AssertJUnit;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {
    WebDriver ldriver;
    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
    public PIMPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    
    @FindBy(xpath="//a[text()='Add Employee']")
    WebElement Addemployee;
    @FindBy(xpath="//input[@name='firstName' and @placeholder='First Name'] ")
    WebElement emp_text1;
    @FindBy(xpath="//input[@name='lastName' and @placeholder='Last Name'] ")
    WebElement emp_text2;
    @FindBy(xpath="//input[@class='oxd-input oxd-input--active'] ")
    WebElement emp_id;
    @FindBy(xpath="//button[@type='submit']")
    WebElement btnsave;
    @FindBy(xpath="//a[contains(text(),'List')]")
    WebElement listemployee;
    
    @FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
    WebElement listemployee_name;
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement listemployee_search;
    		
   @FindBy(xpath="(//div[@role='cell'])[3]/div")
   WebElement listemployee_verify;
    
    
    
    public void clickaddempolyee() {
    	 
         wait.until(ExpectedConditions.elementToBeClickable(Addemployee));
         Addemployee.click();
    }
    public void setfirstname( String fname) {
       wait.until(ExpectedConditions.elementToBeClickable(emp_text1));
    	emp_text1.sendKeys(fname);
    }
    public void setlastname( String lname) {
    	emp_text2.sendKeys(lname);
        }
    
    public void setid(String id) {
    	emp_id.sendKeys(id);
        }
    public void clicksave() throws InterruptedException {
        btnsave.click();
        Thread.sleep(5000);
    }
    public void clicklistempolyee() {
   	 
        wait.until(ExpectedConditions.elementToBeClickable(listemployee));
        listemployee.click();
   }
    public void clicksearchList() throws InterruptedException {
    	listemployee_search.click();
    	Thread.sleep(5000);
    	Actions actions = new Actions(ldriver);
        actions.moveToElement(listemployee_verify).build().perform();
    }
    
    public void setnameList( String name) {
        wait.until(ExpectedConditions.elementToBeClickable(listemployee_name));
        listemployee_name.sendKeys(name);
     }
    
    public void verifynameList( String name) {
        wait.until(ExpectedConditions.elementToBeClickable(listemployee_verify));
        AssertJUnit.assertEquals(name, listemployee_verify.getText());
        System.out.println("Employee name with "+name+" is found");
    }
}