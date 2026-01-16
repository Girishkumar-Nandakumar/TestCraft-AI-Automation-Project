package test;

import pages.LoginPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	@Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        Assert.assertTrue(
                driver.getPageSource().contains("Dashboard"),
                "Dashboard not displayed after login"
        );
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("InvalidUser");
        loginPage.enterPassword("InvalidPass");
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Invalid credentials"),
                "Error message not displayed for invalid login"
        );
    }

    @Test
    public void emptyUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Required"),
                "Required message not shown for empty username"
        );
    }

    @Test
    public void emptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("Admin");
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Required"),
                "Required message not shown for empty password"
        );
    }
}