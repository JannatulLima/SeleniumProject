package jfl.testng.assignments.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class BeforeClassTest extends BaseBeforeClassTest {
    @Test(priority = 0)
    public void loginShouldSucceed(){
        WebElement userName = chromeDriver.findElement(By.id("user-name"));  //id locator
        userName.sendKeys("standard_user");

        WebElement password = chromeDriver.findElement(By.name("password")); //name locator
        password.sendKeys("secret_sauce");

        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        loginButton.click();

        String productPageTitle = chromeDriver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span")).getText().trim();
        Assert.assertEquals(productPageTitle, "Products");
    }

    @Test(priority = 1)
    public void productPurchaseShouldSucceed(){
        WebElement viewProductSauceLabsBackpack = chromeDriver.findElement(By.linkText("Sauce Labs Backpack")); //link text locator
        viewProductSauceLabsBackpack.click();

        WebElement addToCartFirstItem = chromeDriver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartFirstItem.click();

        WebElement viewCart = chromeDriver.findElement(By.className("shopping_cart_container")); //class name locator
        viewCart.click();

        WebElement checkout = chromeDriver.findElement(By.name("checkout")); //name locator
        checkout.click();

        WebElement checkoutFormFirstName = chromeDriver.findElement(By.cssSelector("#first-name")); //css selector locator
        checkoutFormFirstName.sendKeys("Jannatul");

        WebElement checkoutFormLastName = chromeDriver.findElement(By.cssSelector("#last-name"));
        checkoutFormLastName.sendKeys("Lima");

        WebElement checkoutFormPostalCode = chromeDriver.findElement(By.cssSelector("#postal-code"));
        checkoutFormPostalCode.sendKeys("123");

        WebElement checkoutFormSubmit = chromeDriver.findElement(By.id("continue"));
        checkoutFormSubmit.click();

        WebElement checkoutFormFinishButton = chromeDriver.findElement(By.id("finish"));
        checkoutFormFinishButton.click();

        String orderSuccessfulMessage = chromeDriver.findElement(By.className("complete-header")).getText().trim();
        Assert.assertEquals(orderSuccessfulMessage, "Thank you for your order!");
    }
}
