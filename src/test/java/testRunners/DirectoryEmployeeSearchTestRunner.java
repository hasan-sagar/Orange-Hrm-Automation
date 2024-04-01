package testRunners;

import config.SetupConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DirectoryEmployeeSearchPage;
import pages.LoginPage;
import utils.Utils;

import java.io.IOException;

public class DirectoryEmployeeSearchTestRunner extends SetupConfig {
    @BeforeTest
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "admin";
        String password = "admin123";
        loginPage.loginTest(username, password);
    }

    @Test(priority = 1 , description = "Directory employee name wrong search")
    public void searchWrongEmployeeName() throws InterruptedException {
        DirectoryEmployeeSearchPage directoryEmployeeSearchPage = new DirectoryEmployeeSearchPage(driver);
        //get employee id from last json
        //set firstname to search
        directoryEmployeeSearchPage.searchEmployeeByWrongName("asdasdasd");

        //Assertion
        Thread.sleep(1000);
        String expectedMessage = "Invalid";
        String actualMessage = driver.findElement(By.className("oxd-input-field-error-message")).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test(priority = 2, description = "Directory employee name search")
    public void searchEmployeeByName() throws IOException, ParseException, InterruptedException {
        DirectoryEmployeeSearchPage directoryEmployeeSearchPage = new DirectoryEmployeeSearchPage(driver);
        //get employee id from last json
        JSONArray jsonArray = Utils.getUserJson();
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size() - 1);
        //set firstname to search
        String employeeFirstName = ((String) userObj.get("firstName"));
        Thread.sleep(3000);
        directoryEmployeeSearchPage.searchEmployeeByName(employeeFirstName);

        //Assertion
        Thread.sleep(3000);
        String expectedMessage = "(1) Record Found";
        String actualMessage = driver.findElements(By.className("oxd-text")).get(14).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}
