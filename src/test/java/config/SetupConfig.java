package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;

import java.time.Duration;

public class SetupConfig {
    public WebDriver driver;

    @BeforeTest
    public void setupConfiguration() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    //@AfterTest
    public void closeBrowser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logoutTest();
        driver.quit();
    }
}
