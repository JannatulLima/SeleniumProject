package jfl.training.selenium.assignments.two.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.ous.jtoml.impl.ValuedToken;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LocatorsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.get("https://www.saucedemo.com/");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement userName = chromeDriver.findElement(By.id("user-name"));  //id locator
        userName.sendKeys("standard_user");

        WebElement password = chromeDriver.findElement(By.name("password")); //name locator
        password.sendKeys("secret_sauce");

        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement viewProductSauceLabsBikeLight = chromeDriver.findElement(By.partialLinkText("Bike Light")); //partial link text locator
        viewProductSauceLabsBikeLight.click();

        String getProductImageSource = chromeDriver.findElement(By.tagName("img")).getAttribute("src"); //tag name locator
        System.out.println("First Selected Product's image source is: " + getProductImageSource);

        WebElement backToProductList = chromeDriver.findElement(By.id("back-to-products"));
        backToProductList.click();

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

        Thread.sleep(3000);
        chromeDriver.quit();

    }
}
