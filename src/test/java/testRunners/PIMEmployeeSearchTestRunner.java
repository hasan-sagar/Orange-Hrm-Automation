package testRunners;

import com.github.javafaker.Faker;
import config.SetupConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMEmployeeSearchPage;
import utils.Utils;

import java.io.IOException;

public class PIMEmployeeSearchTestRunner extends SetupConfig {
    @BeforeTest
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "admin";
        String password = "admin123";
        loginPage.loginTest(username, password);
    }

    @Test(priority = 1, description = "Search employee by wrong id")
    public void searchEmployeeByWrongId() throws InterruptedException {
        PIMEmployeeSearchPage pimEmployeeSearchPage = new PIMEmployeeSearchPage(driver);

        Faker faker = new Faker();
        String employeeId = String.valueOf(faker.number().randomDigit());
        Thread.sleep(2000);
        pimEmployeeSearchPage.searchEmployeeById(employeeId);

        //Assertion
        Thread.sleep(2000);
        String expectedMessage = "No Records Found";
        String actualMessage = driver.findElements(By.className("oxd-text--span")).get(12).getText();
        Thread.sleep(1000);
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test(priority = 2, description = "Search employee by id")
    public void searchEmployeeById() throws IOException, ParseException, InterruptedException {
        PIMEmployeeSearchPage pimEmployeeSearchPage = new PIMEmployeeSearchPage(driver);
        //get employee id from last json
        JSONArray jsonArray = Utils.getUserJson();
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size() - 1);
        //get employee and pass it in method
        String employeeId = ((String) userObj.get("employeeId"));
        pimEmployeeSearchPage.searchEmployeeById(employeeId);

        //Assertion
        Thread.sleep(3000);
        String expectedMessage = "(1) Record Found";
        String actualMessage = driver.findElements(By.className("oxd-text--span")).get(12).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}
