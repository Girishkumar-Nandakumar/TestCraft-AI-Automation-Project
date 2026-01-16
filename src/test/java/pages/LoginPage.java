package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	    private WebDriver driver;

	    // Correct Selectors
	    private By usernameField = By.xpath("//input[@name='username']");
	    private By passwordField = By.xpath("//input[@name='password']");
	    private By loginButton = By.xpath("//button[@type='submit']");
	    private By errorMessage = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }

	    public String getErrorMessage() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(errorMessage)
	        ).getText();
	    }
	}