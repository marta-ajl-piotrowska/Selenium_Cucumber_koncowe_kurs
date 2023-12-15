package pl.coderslab.shop.addingAddress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopMyAccountPage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@href='https://mystore-testlab.coderslab.pl/index.php?controller=addresses']")
    private WebElement addressesTile;

    @FindBy(xpath = "//span[text()='Home']")
    private WebElement HomeLink;

    public ShopMyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAddressesDisplayed() {
        return addressesTile.isDisplayed();
    }

    public void goToAddresses() {
        addressesTile.click();
    }

    public void returHome() {
        HomeLink.click();
    }
}
