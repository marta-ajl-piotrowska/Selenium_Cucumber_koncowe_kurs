package pl.coderslab.shop.addingAddress;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AddingAddressSteps {
    private WebDriver driver;

    ShopMyAddressesPage myAddressesPage;

    @Given("I'm on shop's login page")
    public void imOnShopLoginPage() {
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

    @And("I see tile Addresses")
    public void iSeeTileAddresses() {
        ShopMyAccountPage AccountPage = new ShopMyAccountPage(driver);
        if (AccountPage.isAddressesDisplayed()) {
            AccountPage.goToAddresses();
        } else {
            System.out.println("Tile Addresses should be displayed");
        }
    }

    @Then("I can add new address")
    public void iCanAddNewAddress() {
        WebElement addAddress = driver.findElement(By.xpath("//span[text()='Create new address']"));
        addAddress.click();
    }

    @And("^I can enter full address alias (.*) address (.*) city (.*) code (.*) country (.*) and phone (.*)$")
    public void iCanEnterAddress(String alias, String address, String city, String code, String country, String phone) {
        ShopNewAddressFormPage addressesFormPage = new ShopNewAddressFormPage(driver);
        addressesFormPage.enterAddressAndSave(alias, address, city, code, country, phone);
    }

    @Then("I can see that address is added")
    public void iCanSeeNewAddressIsAdded() {
        myAddressesPage = new ShopMyAddressesPage(driver);
        Assertions.assertTrue(myAddressesPage.newAddresIsAddded(), "There is only one address");
    }

    @And("^I verify created address alias (.*) address (.*) city (.*) code (.*) country (.*) and phone (.*)$")
    public void iVerifyCreatedAddress(String alias, String address, String city, String code, String country, String phone) {
        String AddressAsText = myAddressesPage.getAddedAddressAsText();
        Assertions.assertTrue(AddressAsText.contains(alias)&&AddressAsText.contains(address)&&AddressAsText.contains(city)&&AddressAsText.contains(code)&&AddressAsText.contains(country)&&AddressAsText.contains(phone), "Compared addresses differ");
    }

    @And("I remove this address")
    public void iRemoveThisAddress() {
        myAddressesPage.removeAddress();
    }

    @And("I see that address is deleted")
    public void iSeeAddressIsDeleted() {
        WebElement alert = driver.findElement(By.className("alert-success"));
        Assertions.assertFalse(myAddressesPage.newAddresIsAddded(), "There is more than one address");
        Assertions.assertTrue(alert.isDisplayed(), "Success alert should be visible");
    }

    @Then("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }
}
