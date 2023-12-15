package pl.coderslab.shop.orderPlacing;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.shop.addingAddress.ShopLoginPage;
import pl.coderslab.shop.addingAddress.ShopMyAccountPage;
import pl.coderslab.shop.orderPlacing.ShopHummingbirdPage;
import pl.coderslab.shop.orderPlacing.ShopOrderPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShopPlacingOrderSteps {
    private WebDriver driver;

    ShopHummingbirdPage hummingBirdPage;
    ShopOrderPage orderPage;

   @Given("I'm on shop's login page")
    public void iOnShopSLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("I enter email {string} and pass {string}")
    public void iEnterEmailAndPass(String email, String pass) {
        ShopLoginPage loginPage = new ShopLoginPage(driver);
        loginPage.enterEmailAndPassAndSubmit(email, pass);
    }

    @And("I go to shop's main page")
    public void iGoToShopSMainPage() {

        ShopMyAccountPage accountPage = new ShopMyAccountPage(driver);
        accountPage.returHome();
    }

    @Then("I can order Hummingbird Printed Sweater")
    public void iCanOrderHummingbirdPrintedSweater() {
        WebElement hummingbirdSweater = driver.findElement(By.xpath("//a[text()='Hummingbird printed sweater']"));
        hummingbirdSweater.click();
    }

//    @And("I verify if discount for it is {int}%")
//    public void iVerifyIfDiscountForItIs(int arg0) {
//    }

    @Then("^I can choose size (.*)$")
    public void iCanChooseSize(String size) {
        hummingBirdPage = new ShopHummingbirdPage(driver);
        hummingBirdPage.chooseSize(size);
    }

    @And("^I can choose quantity (.*)$")
    public void iCanChooseQuantity(String qty) throws InterruptedException {
        WebElement quantityInput = driver.findElement(By.id("quantity_wanted"));
        quantityInput.click();
        quantityInput.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        Thread.sleep(800);
        quantityInput.sendKeys(Keys.DELETE);
        quantityInput.sendKeys(qty);
        quantityInput.click();
    }

    @Then("I can add product to cart")
    public void iCanAddProductToCart() {
        hummingBirdPage.addToCart();
    }

    @Then("I can go to checkout")
    public void iCanGoToCheckout() {
        WebElement goToCheckout = driver.findElement(By.xpath("//a[text()='Proceed to checkout']"));
        goToCheckout.click();
        WebElement proceedToCheckout = driver.findElement(By.className("checkout"));
        proceedToCheckout.click();
    }

    @And("I can confirm shipping address")
    public void iCanConfirmShippingAddress() {
        orderPage = new ShopOrderPage(driver);
        orderPage.confirmAddress();
    }

    @And("I can choose pickup method")
    public void iCanChoosePickupMethod() {
        orderPage.confirmShipping();
    }

    @And("I can choose payment method")
    public void iCanChoosePaymentMethod() {
        orderPage.chooseCheck();
    }

    @Then("I can place an order")
    public void iCanPlaceAnOrder() throws InterruptedException {
        orderPage.placeAnOrder();
    }

    @And("I take a screenshot {string}")
    public void iTakeScreenshot(String pathname) throws IOException {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formatedDateTime = date.format(format);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("src/Cucumber/screenshots/order" + formatedDateTime + ".png"));
    }

//    @Then("Then I go to orders history")
//    public void iGoToHistoryOfTheOrders() {
//    }

//    @And("I verify if my order is on the list od awaiting check payment list with valid cost")
//    public void iVerifyIfMyOrderIsOnTheListOdAwaitingCheckPaymentListWithValidCost() {
//    }

    @And("I close the browser")
    public void iCloseMyBrowser() {
        driver.quit();
    }
}
