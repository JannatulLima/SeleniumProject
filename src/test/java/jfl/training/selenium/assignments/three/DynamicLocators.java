package jfl.training.selenium.assignments.three;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement userName = chromeDriver.findElement(By.cssSelector("input[name*='userna']"));  //tag[attribute*='value']
        userName.sendKeys("Admin"); //sendkeys

        WebElement password = chromeDriver.findElement(By.cssSelector("input[name^='pass']")); //tag[attribute^='value']
        password.sendKeys("admin123");

        WebElement loginButton = chromeDriver.findElement(By.cssSelector("button[class$='login-button']")); //tag[attributeS='value']
        loginButton.submit();
        chromeDriver.quit();
    }
}
