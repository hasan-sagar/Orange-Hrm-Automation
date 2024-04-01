package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {
    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> pimNavigationMenu;

    @FindBy(className = "oxd-button")
    List<WebElement> addButton;

    @FindBy(className = "oxd-switch-input")
    WebElement toggleButton;

    @FindBy(className = "oxd-input")
    List<WebElement> inputField;

    @FindBy(className = "oxd-button")
    List<WebElement> saveButton;


    public PIMPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createNewEmployee(String firstName, String lastName, String employeeId, String userName, String password) throws InterruptedException {
        //pim menu click
        pimNavigationMenu.get(1).click();
        // add button click
        addButton.get(2).click();
        //fill input fields
        inputField.get(1).sendKeys(firstName);
        inputField.get(3).sendKeys(lastName);
        WebElement empId = inputField.get(4);
        Thread.sleep(1000);
        empId.clear();
        empId.sendKeys(Keys.CONTROL + "a");
        empId.sendKeys(employeeId);
        //toggle button click
        toggleButton.click();
        //fill input fields
        inputField.get(5).sendKeys(userName);
        inputField.get(6).sendKeys(password);
        inputField.get(7).sendKeys(password);
        //save employee
        saveButton.get(1).click();
    }
}
