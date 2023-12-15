package pl.coderslab.shop.orderPlacing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ShopOrderPage {
    private final WebDriver driver;

    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddressBtn;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmShippingBtn;

    @FindBy(id = "payment-option-1")
    private WebElement checkPaymentRadio;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsOfServiceCheckbox;

    @FindBy(xpath = "//div[@id='payment-confirmation']/div/button")
    private WebElement placeOrderBtn;

    public ShopOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void confirmAddress() {
        confirmAddressBtn.click();
    }

    public void confirmShipping() {
        confirmShippingBtn.click();
    }

    public void chooseCheck() {
        checkPaymentRadio.click();
    }

    public void placeAnOrder() throws InterruptedException {
        termsOfServiceCheckbox.click();
        Thread.sleep(800);
        placeOrderBtn.click();
    }


}
