package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DirectoryEmployeeSearchPage {
    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> directoryNavigationMenu;

    @FindBy(css = "input[data-v-75e744cd]")
    WebElement searchNameInputField;

    @FindBy(css = "[data-v-08ed484c]")
    List<WebElement> suggestEmployee;

    @FindBy(className = "oxd-button")
    List<WebElement> searchButton;


    public DirectoryEmployeeSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchEmployeeByName(String firstName) throws InterruptedException {
        directoryNavigationMenu.get(8).click();
        searchNameInputField.sendKeys(firstName);
        Thread.sleep(3000);
        suggestEmployee.get(1).click();
        searchButton.get(1).click();
    }

    public void searchEmployeeByWrongName(String firstName) throws InterruptedException {
        directoryNavigationMenu.get(8).click();
        searchNameInputField.sendKeys(firstName);
        Thread.sleep(1000);
        searchButton.get(1).click();
    }
}
