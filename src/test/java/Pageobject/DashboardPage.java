package Pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    WebDriver ldriver;

    
    public DashboardPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    
    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
    WebElement pin;
  
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement logoutdd;
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutbtn;
    
    public void hoverAndClickPIMLink() {
    	Actions actions = new Actions(ldriver);
        actions.moveToElement(pin).click().build().perform();
    	//pin.click();
    }
    
    public void logout() throws InterruptedException {
    	logoutdd.click();
    	Thread.sleep(2000);
    	logoutbtn.click();
    }
}