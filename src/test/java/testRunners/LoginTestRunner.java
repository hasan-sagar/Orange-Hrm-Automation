package testRunners;

import config.SetupConfig;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestRunner extends SetupConfig {
    @Test(priority = 1, description = "Admin login using wrong credentials")
    public void loginTestWrong() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "admin";
        String password = "123";
        loginPage.loginTest(username, password);

        //Assertion
        String expectedMessage = "Invalid credentials";
        String actualMessage = driver.findElements(By.className("oxd-text")).get(1).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test(priority = 2, description = "Admin login")
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "admin";
        String password = "admin123";
        loginPage.loginTest(username, password);
    }
}
