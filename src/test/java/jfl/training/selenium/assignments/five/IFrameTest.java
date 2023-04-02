package jfl.training.selenium.assignments.five;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IFrameTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://demoqa.com/frames");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println(chromeDriver.findElements(By.tagName("iframe")).size());

        WebElement mainPageContent = chromeDriver.findElement(By.id("framesWrapper"));
        System.out.println(mainPageContent.getText());

        chromeDriver.switchTo().frame("frame1");
        WebElement firstFrameContent = chromeDriver.findElement(By.id("sampleHeading"));
        System.out.println(firstFrameContent.getText());
        chromeDriver.switchTo().defaultContent();

        chromeDriver.switchTo().frame(3);
        WebElement SecondFrameContent = chromeDriver.findElement(By.id("sampleHeading"));
        System.out.println(SecondFrameContent.getText());
        chromeDriver.switchTo().defaultContent();

        WebElement frameElement = chromeDriver.findElement(By.id("frame2"));
        chromeDriver.switchTo().frame(frameElement);
        WebElement RePrintSecondFrameContent = chromeDriver.findElement(By.id("sampleHeading"));
        System.out.println(RePrintSecondFrameContent.getText());
        chromeDriver.switchTo().defaultContent();


        chromeDriver.quit();
    }
}
