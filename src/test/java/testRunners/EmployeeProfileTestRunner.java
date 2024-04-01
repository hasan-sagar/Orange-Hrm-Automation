package testRunners;

import config.SetupConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

import java.io.IOException;

public class EmployeeProfileTestRunner extends SetupConfig {
    @BeforeTest
    public void loginTest() throws IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
        //get employee username and password from last json
        JSONArray jsonArray = Utils.getUserJson();
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size() - 1);
        String username = (String) userObj.get("userName");
        String password = (String) userObj.get("password");
        loginPage.loginTest(username, password);
    }

    @Test(priority = 1, description = "Show employee profile")
    public void checkProfileName() {
        WebElement profileName = driver.findElement(By.className("oxd-userdropdown-name"));
        Assert.assertTrue(profileName.isDisplayed());
    }
}
