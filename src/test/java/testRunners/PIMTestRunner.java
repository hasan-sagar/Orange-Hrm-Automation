package testRunners;

import com.github.javafaker.Faker;
import config.SetupConfig;
import config.UserModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMPage;
import utils.Utils;

import java.io.IOException;

public class PIMTestRunner extends SetupConfig {
    @BeforeTest
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "admin";
        String password = "admin123";
        loginPage.loginTest(username, password);
    }

    @Test(priority = 2, description = "Create wrong employee")
    public void createWrongEmployee() throws IOException, ParseException, InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        //get employee id from last json
        JSONArray jsonArray = Utils.getUserJson();
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size() - 1);
        //fake data
        String firstName = (String) userObj.get("firstName");
        String lastName = (String) userObj.get("lastName");
        String employeeId = (String) userObj.get("employeeId");
        Thread.sleep(2000);
        String userName = (String) userObj.get("userName");
        String password = (String) userObj.get("password");

        pimPage.createNewEmployee(firstName, lastName, employeeId, userName, password);
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
    }

    @Test(priority = 1, description = "Create a new employee")
    public void createNewEmployee() throws IOException, ParseException, InterruptedException {
        //object create of pim page class to call methods
        PIMPage pimPage = new PIMPage(driver);
        //faker using for fake input fields
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String employeeId = String.valueOf(faker.number().numberBetween(10000, 99999999));
        String userName = faker.name().username();
//        String password = faker.internet().password(7, 10, true, true);
        String password = faker.internet().password();
        //create employee method call
        pimPage.createNewEmployee(firstName, lastName, employeeId, userName, password);

        //save json user
        UserModel userModel = new UserModel();
        userModel.setFirstName(firstName);
        userModel.setLastName(lastName);
        userModel.setEmployeeId(employeeId);
        userModel.setUserName(userName);
        userModel.setPassword(password);
        Utils.saveJsonUser(userModel);
    }
}
