package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyInfoPage {
    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> myInfoNavigationMenu;

    @FindBy(className = "oxd-radio-input")
    List<WebElement> genderRadioButton;

    @FindBy(className = "oxd-select-text--arrow")
    List<WebElement> bloodTypeSelectButton;

    @FindBy(className = "oxd-select-option")
    List<WebElement> bloodTypeSelect;

    @FindBy(className = "oxd-button")
    List<WebElement> submitButton;

    public MyInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void updateEmployeeInfo() throws InterruptedException {
        myInfoNavigationMenu.get(2).click();
        Thread.sleep(2000);
        genderRadioButton.get(1).click();
        submitButton.get(0).click();
        Thread.sleep(1500);
        bloodTypeSelectButton.get(2).click();
        bloodTypeSelect.get(1).click();
        submitButton.get(1).click();
        Thread.sleep(1500);
    }
}
