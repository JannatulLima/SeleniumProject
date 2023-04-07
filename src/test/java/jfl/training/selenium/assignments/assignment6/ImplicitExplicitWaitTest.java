package jfl.training.selenium.assignments.assignment6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitExplicitWaitTest {
    public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();
            WebDriver chromeDriver = new ChromeDriver();
            chromeDriver.get("https://selenium08.blogspot.com/2019/07/alert-test.html");
            chromeDriver.manage().window().maximize();
            chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            //simple alert
            chromeDriver.findElement(By.id("simple")).click();
            Alert simpleAlert = chromeDriver.switchTo().alert();
            simpleAlert.accept();

            //confirm alert
            WebElement confirmAlertOpenBButton = chromeDriver.findElement(By.id("confirm"));
            confirmAlertOpenBButton.click();
            Alert confirmAlert = chromeDriver.switchTo().alert();
            confirmAlert.accept();
            confirmAlertOpenBButton.click();
            confirmAlert.dismiss();

            //prom alert
            chromeDriver.findElement(By.id("prompt")).click();
            Alert promAlert = chromeDriver.switchTo().alert();
            promAlert.sendKeys("hello");
            promAlert.accept();

            chromeDriver.quit();
        }
    }
