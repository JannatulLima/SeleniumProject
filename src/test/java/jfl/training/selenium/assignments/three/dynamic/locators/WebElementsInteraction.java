package jfl.training.selenium.assignments.three.dynamic.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebElementsInteraction {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.get("https://www.saucedemo.com/"); //get
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement userName = chromeDriver.findElement(By.id("user-name"));
        userName.clear(); //clear
        userName.sendKeys("standard_user"); //sendKeys

        WebElement password = chromeDriver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("secret_sauce");

        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        loginButton.submit(); //submit

        WebElement viewProductSauceLabsBikeLight = chromeDriver.findElement(By.partialLinkText("Bike Light"));
        viewProductSauceLabsBikeLight.click(); //click
        chromeDriver.quit();
    }
}
