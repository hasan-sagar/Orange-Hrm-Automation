package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMEmployeeSearchPage {
    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> pimNavigationMenu;
    @FindBy(className = "oxd-input")
    List<WebElement> employeeIdInput;
    @FindBy(className = "oxd-button")
    List<WebElement> searchButton;

    public PIMEmployeeSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchEmployeeById(String employeeId) {
        //pim menu click
        pimNavigationMenu.get(1).click();
        //fill employee id
        employeeIdInput.get(1).sendKeys(employeeId);
        //search button click
        searchButton.get(1).click();
    }
}
