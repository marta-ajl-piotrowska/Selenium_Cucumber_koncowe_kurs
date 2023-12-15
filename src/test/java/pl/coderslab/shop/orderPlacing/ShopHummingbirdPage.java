package pl.coderslab.shop.orderPlacing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopHummingbirdPage {

    private final WebDriver driver;

    @FindBy(className = "form-control-select")
    private WebElement sizesList;


    @FindBy(className = "add-to-cart")
    private WebElement addToCartBtn;

    public ShopHummingbirdPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseSize(String size) {
        sizesList.click();
        sizesList.sendKeys(size);
        sizesList.click();
    }

    public void addToCart() {
        addToCartBtn.click();
    }
}
