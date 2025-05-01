package Pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver ldriver;

    
    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    
    @FindBy(name = "username")
    WebElement textusername;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;

    public void setUserName(String uName) {
        textusername.sendKeys(uName);
    }

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
        btnLogin.click();
    }
}