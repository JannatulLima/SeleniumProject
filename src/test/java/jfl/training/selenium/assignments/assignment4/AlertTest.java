package jfl.training.selenium.assignments.assignment4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://selenium08.blogspot.com/2019/07/alert-test.html");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //simple alert
        chromeDriver.findElement(By.id("simple")).click();
        Thread.sleep(1000);
        Alert simpleAlert = chromeDriver.switchTo().alert();
        simpleAlert.accept();

        //confirm alert
        WebElement confirmAlertOpenBButton = chromeDriver.findElement(By.id("confirm"));
        confirmAlertOpenBButton.click();
        Thread.sleep(1000);
        Alert confirmAlert = chromeDriver.switchTo().alert();
        confirmAlert.accept();
        confirmAlertOpenBButton.click();
        Thread.sleep(1000);
        confirmAlert.dismiss();

        //prom alert
        chromeDriver.findElement(By.id("prompt")).click();
        Thread.sleep(1000);
        Alert promAlert = chromeDriver.switchTo().alert();
        Thread.sleep(2000);
        promAlert.sendKeys("hello");
        promAlert.accept();
        Thread.sleep(2000);

        chromeDriver.quit();
    }
}
