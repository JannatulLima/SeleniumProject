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

        System.out.println(chromeDriver.findElements(By.tagName("iframe")).size()); //print total iframes

        WebElement mainPageContent = chromeDriver.findElement(By.id("framesWrapper"));
        System.out.println(mainPageContent.getText()); //print main page content

        chromeDriver.switchTo().frame("frame1"); //switch to frame by frame id
        WebElement firstFrameContent = chromeDriver.findElement(By.id("sampleHeading"));
        System.out.println(firstFrameContent.getText()); //print frame content
        chromeDriver.switchTo().defaultContent();

        chromeDriver.switchTo().frame(3); //switch to frame by id
        WebElement SecondFrameContent = chromeDriver.findElement(By.id("sampleHeading"));
        System.out.println(SecondFrameContent.getText());  //print frame content
        chromeDriver.switchTo().defaultContent();

        WebElement frameElement = chromeDriver.findElement(By.id("frame2")); //switch to frame by webElement
        chromeDriver.switchTo().frame(frameElement);
        WebElement RePrintSecondFrameContent = chromeDriver.findElement(By.id("sampleHeading"));
        System.out.println(RePrintSecondFrameContent.getText()); //print frame content
        chromeDriver.switchTo().defaultContent();


        chromeDriver.quit();
    }
}
