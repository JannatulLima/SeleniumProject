package jfl.training.selenium.assignments.four;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SelectListTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Select select = new Select(chromeDriver.findElement(By.cssSelector("select[name='country']")));
        select.selectByValue("AI");
        Thread.sleep(2000);
        select.selectByIndex(3);
        Thread.sleep(2000);
        select.selectByVisibleText("Argentina");
        Thread.sleep(2000);

        for (WebElement options: select.getOptions()) {
            System.out.println(options.getText());
        }

        chromeDriver.quit();
    }
}
