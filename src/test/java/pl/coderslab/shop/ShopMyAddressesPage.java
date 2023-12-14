package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopMyAddressesPage {
    private final WebDriver driver;

    @FindBy (className = "address-body")
    private List<WebElement> addresses;

    @FindBy (xpath = "//div[2]/article/div[2]/a[2]/span[text()='Delete']")
    private WebElement deleteNextAddressBtn;

    public ShopMyAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean newAddresIsAddded() {
        return addresses.size() > 1;
    }

    public String getAddedAddressAsText() {
     WebElement addedAddress = addresses.get(1);
     String addedAddressText = addedAddress.getText();
     return addedAddressText;
    }

    public void removeAddress() {
       deleteNextAddressBtn.click();
    }


}
