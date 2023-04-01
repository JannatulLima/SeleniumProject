package jfl.training.selenium.assignments.three;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebElementsInformation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.saucedemo.com/");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement userName = chromeDriver.findElement(By.id("user-name"));
        System.out.println("Tag name of username element is: " + userName.getTagName()); //get tagname
        System.out.println("Position of x coordinate is: " + userName.getRect().x); //get rect
        System.out.println("Css is: " + userName.getCssValue("color"));
        userName.sendKeys("standard_user");

        WebElement password = chromeDriver.findElement(By.name("password"));
        WebElement staticPasswordForAllUsers = chromeDriver.findElement(By.className("login_password"));
        System.out.println(staticPasswordForAllUsers.getText());
        password.sendKeys("secret_sauce");

        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        Boolean buttonDisplayStatus = loginButton.isDisplayed(); //is element displayed
        Boolean buttonEnableStatus = loginButton.isEnabled(); ////is element enabled
        if(buttonDisplayStatus == true) {
            if (buttonEnableStatus == true) {
                loginButton.click();
                WebElement viewProductSauceLabsBikeLight = chromeDriver.findElement(By.partialLinkText("Bike Light"));
                viewProductSauceLabsBikeLight.click();

                String getProductImageSource = chromeDriver.findElement(By.tagName("img")).getAttribute("src"); //attributes
                System.out.println("First Selected Product's image source is: " + getProductImageSource);

                WebElement backToProductList = chromeDriver.findElement(By.id("back-to-products"));
                backToProductList.click();

                WebElement viewProductSauceLabsBackpack = chromeDriver.findElement(By.linkText("Sauce Labs Backpack"));
                viewProductSauceLabsBackpack.click();

                WebElement addToCartFirstItem = chromeDriver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
                addToCartFirstItem.click();

                WebElement viewCart = chromeDriver.findElement(By.className("shopping_cart_container"));
                viewCart.click();

                WebElement checkout = chromeDriver.findElement(By.name("checkout"));
                checkout.click();

                WebElement checkoutFormFirstName = chromeDriver.findElement(By.cssSelector("#first-name"));
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
        else {
            System.out.println("Login button  is not displayed/enabled");
        }
    }
}
