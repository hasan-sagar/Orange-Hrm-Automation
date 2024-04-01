package testRunners;

import config.SetupConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyInfoPage;
import utils.Utils;

import java.io.IOException;

public class MyInfoTestRunner extends SetupConfig {
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

    @Test(priority = 1, description = "Update employee info")
    public void updateEmployeeInfo() throws InterruptedException {
        MyInfoPage myInfoPage = new MyInfoPage(driver);
        myInfoPage.updateEmployeeInfo();
    }

    @AfterTest
    public void closeBrowser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logoutTest();
        driver.quit();
    }
}
