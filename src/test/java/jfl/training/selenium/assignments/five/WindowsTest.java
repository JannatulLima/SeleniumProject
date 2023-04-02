package jfl.training.selenium.assignments.five;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://demoqa.com/browser-windows");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String mainWindow = chromeDriver.getWindowHandle();
        chromeDriver.switchTo().newWindow(WindowType.TAB);
        chromeDriver.navigate().to("https://demoqa.com/sample");
        System.out.println(chromeDriver.findElement(By.id("sampleHeading")).getText());
        Set<String> windows = chromeDriver.getWindowHandles();
        System.out.println(windows.size());
        chromeDriver.close();
        chromeDriver.switchTo().window(mainWindow);

        chromeDriver.switchTo().newWindow(WindowType.WINDOW);
        chromeDriver.navigate().to("https://demoqa.com/sample");
        System.out.println(chromeDriver.findElement(By.id("sampleHeading")).getText());
        chromeDriver.close();
        chromeDriver.switchTo().window(mainWindow);

        chromeDriver.quit();
    }
}
