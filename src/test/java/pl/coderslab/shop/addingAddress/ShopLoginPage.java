package pl.coderslab.shop.addingAddress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopLoginPage {
    private final WebDriver driver;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passInput;

    @FindBy(id = "submit-login")
    private WebElement signInBtn;

    public ShopLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmailAndPassAndSubmit(String email, String pass) {
        emailInput.click();
        emailInput.sendKeys(email);
        passInput.click();
        passInput.sendKeys(pass);
        signInBtn.click();
    }
}
