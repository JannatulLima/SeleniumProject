package jfl.training.selenium.assignments.assignment3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IsSelectedTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement radioButton = chromeDriver.findElement(By.cssSelector("input[value='red']"));
        System.out.println(radioButton.isSelected());
        radioButton.click();
        Thread.sleep(2000);
        System.out.println(radioButton.isSelected());
        Thread.sleep(2000);
        chromeDriver.quit();
    }
}
