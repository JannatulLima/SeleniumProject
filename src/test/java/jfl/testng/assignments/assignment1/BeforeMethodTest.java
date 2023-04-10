package jfl.testng.assignments.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BeforeMethodTest extends BaseBeforeMethodTest{
    @Test
    public void viewProductShouldSucceed(){
        WebElement userName = chromeDriver.findElement(By.id("user-name"));  //id locator
        userName.sendKeys("standard_user");

        WebElement password = chromeDriver.findElement(By.name("password")); //name locator
        password.sendKeys("secret_sauce");

        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement viewProductSauceLabsBikeLight = chromeDriver.findElement(By.partialLinkText("Bike Light")); //partial link text locator
        viewProductSauceLabsBikeLight.click();

        WebElement backToProductList = chromeDriver.findElement(By.id("back-to-products"));
        String backToProductTitle = backToProductList.getText().trim();
        Assert.assertEquals(backToProductTitle, "Back to products");
        backToProductList.click();
    }

    @Test
    public void productPurchaseShouldSucceed(){
        WebElement userName = chromeDriver.findElement(By.id("user-name"));  //id locator
        userName.sendKeys("standard_user");

        WebElement password = chromeDriver.findElement(By.name("password")); //name locator
        password.sendKeys("secret_sauce");

        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        loginButton.click();

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
