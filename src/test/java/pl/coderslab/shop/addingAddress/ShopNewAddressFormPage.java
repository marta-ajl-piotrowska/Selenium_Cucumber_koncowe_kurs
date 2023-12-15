package pl.coderslab.shop.addingAddress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopNewAddressFormPage {
    private final WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement postalcodeInput;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(name = "id_country")
    private WebElement countryList;

    @FindBy(className = "form-control-submit")
    private  WebElement saveBtn;

    public ShopNewAddressFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterAddressAndSave(String alias, String address, String city, String code, String country, String phone) {
        aliasInput.click();
        aliasInput.sendKeys(alias);
        addressInput.click();
        addressInput.sendKeys(address);
        cityInput.click();
        cityInput.sendKeys(city);
        postalcodeInput.click();
        postalcodeInput.sendKeys(code);
        countryList.click();
        countryList.sendKeys(country);
        phoneInput.sendKeys(phone);
        saveBtn.click();
    }
}
