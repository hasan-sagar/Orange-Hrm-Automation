package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(name = "username")
    WebElement inputUsername;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(css = "[type=\"submit\"]")
    WebElement loginButton;

    @FindBy(className = "oxd-userdropdown-tab")
    WebElement loggedinUser;
    @FindBy(css = "[role=\"menuitem\"]")
    List<WebElement> btnLogout;


    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginTest(String username, String password) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        loggedinUser.click();
        loginPage.btnLogout.get(3).click();
    }

}
