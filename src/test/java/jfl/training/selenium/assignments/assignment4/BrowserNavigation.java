package jfl.training.selenium.assignments.assignment4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserNavigation {
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

        chromeDriver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        Thread.sleep(10000);
        chromeDriver.navigate().back();
        Thread.sleep(10000);
        chromeDriver.navigate().forward();
        Thread.sleep(10000);
        chromeDriver.navigate().refresh();
        chromeDriver.quit();

    }
}
