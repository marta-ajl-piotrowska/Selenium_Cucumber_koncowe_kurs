package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopMyAccountPage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@href='https://mystore-testlab.coderslab.pl/index.php?controller=addresses']")
    private WebElement addressesTile;

    public ShopMyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAddressesDisplayed() {
        return addressesTile.isDisplayed();
    }

    public void goToAddresses () {
        addressesTile.click();
    }
}
