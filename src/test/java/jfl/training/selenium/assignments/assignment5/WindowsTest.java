package jfl.training.selenium.assignments.assignment5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

        String mainWindow = chromeDriver.getWindowHandle();  //main window
        chromeDriver.switchTo().newWindow(WindowType.TAB);  //open tab type window
        chromeDriver.navigate().to("https://demoqa.com/sample"); //navigate to provided URL after opening tab
        System.out.println(chromeDriver.findElement(By.id("sampleHeading")).getText()); //print opened tab page's content
        Set<String> windows = chromeDriver.getWindowHandles();  //get total windows after opening tab
        System.out.println(windows.size()); //print total windows
        chromeDriver.close(); //close opened tab
        chromeDriver.switchTo().window(mainWindow); //switch to main window

        chromeDriver.switchTo().newWindow(WindowType.WINDOW); //open window type window
        chromeDriver.navigate().to("https://demoqa.com/sample"); //navigate to provided URL after opening tab
        System.out.println(chromeDriver.findElement(By.id("sampleHeading")).getText()); //print opened window page's content
        chromeDriver.close(); //close opened window
        chromeDriver.switchTo().window(mainWindow); //switch to main window

        chromeDriver.quit();
    }
}
