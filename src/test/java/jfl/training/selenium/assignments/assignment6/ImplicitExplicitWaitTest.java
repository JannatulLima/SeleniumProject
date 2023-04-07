package jfl.training.selenium.assignments.assignment6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ImplicitExplicitWaitTest {
    public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();
            WebDriver chromeDriver = new ChromeDriver();
            chromeDriver.get("https://selenium08.blogspot.com/2019/07/alert-test.html");
            chromeDriver.manage().window().maximize();
            chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait explicitWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));

            //simple alert
            WebElement  simpleAlertButton = chromeDriver.findElement(By.id("simple"));
            explicitWait.until(ExpectedConditions.elementToBeClickable(simpleAlertButton)); //explicit wait
            simpleAlertButton.click();
            explicitWait.until(ExpectedConditions.alertIsPresent()); //explicit wait
            Alert simpleAlert = chromeDriver.switchTo().alert();
            simpleAlert.accept();

            //confirm alert
            WebElement confirmAlertOpenBButton = chromeDriver.findElement(By.id("confirm"));
            explicitWait.until(ExpectedConditions.elementToBeClickable(confirmAlertOpenBButton)); //explicit wait
            confirmAlertOpenBButton.click();
            explicitWait.until(ExpectedConditions.alertIsPresent()); //explicit wait
            Alert confirmAlert = chromeDriver.switchTo().alert();
            confirmAlert.accept();
            explicitWait.until(ExpectedConditions.elementToBeClickable(confirmAlertOpenBButton));  //explicit wait
            confirmAlertOpenBButton.click();
            explicitWait.until(ExpectedConditions.alertIsPresent()); //explicit wait
            confirmAlert.dismiss();

            //prom alert
            WebElement promAlertButton = chromeDriver.findElement(By.id("prompt"));
            explicitWait.until(ExpectedConditions.elementToBeClickable(promAlertButton)); //explicit wait
            promAlertButton.click();
            explicitWait.until(ExpectedConditions.alertIsPresent()); //explicit wait
            Alert promAlert = chromeDriver.switchTo().alert();
            promAlert.sendKeys("hello");
            promAlert.accept();

            chromeDriver.quit();
        }
    }
