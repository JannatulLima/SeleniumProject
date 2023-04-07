package jfl.training.selenium.assignments.assignment6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ActionsAPITest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://demoqa.com/menu");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebDriverWait explicitWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
        Actions actions = new Actions(chromeDriver);

        //click and release
        WebElement menu3Select = chromeDriver.findElement(By.cssSelector("#nav > li:nth-child(3) > a"));
        actions.click(menu3Select).release().perform();
        actions.clickAndHold(menu3Select).perform();

        //click  and hold
        chromeDriver.navigate().refresh();
        WebElement menu1Select = chromeDriver.findElement(By.cssSelector("#nav > li:nth-child(1) > a"));
        actions.clickAndHold(menu1Select).perform();


        //drag and drop
        chromeDriver.navigate().to("https://selenium08.blogspot.com/2020/01/drag-drop.html");
        WebElement drag = chromeDriver.findElement(By.id("draggable"));
        explicitWait.until(ExpectedConditions.visibilityOf(drag));  //explicit wait
        WebElement drop = chromeDriver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag, drop).perform();

        //double click
        chromeDriver.navigate().to("https://mousetester.com/");
        WebElement clickField = chromeDriver.findElement(By.id("clickMe"));
        actions.doubleClick(clickField).perform();

        //move to element
        chromeDriver.navigate().to("https://www.webfx.com/blog/web-design/50-examples-of-drop-down-navigation-menus-in-web-designs/");
        WebElement whoAreWeMenu = chromeDriver.findElement(By.id("menu-item-131"));
        WebElement contactInfoMenu = chromeDriver.findElement(By.cssSelector("#menu-item-119190 > a > span"));
        actions.moveToElement(whoAreWeMenu).perform();
        explicitWait.until(ExpectedConditions.visibilityOf(contactInfoMenu));
        actions.moveToElement(contactInfoMenu).click().perform();

        //context click
        chromeDriver.navigate().to("https://www.saucedemo.com/");
        WebElement userName = chromeDriver.findElement(By.id("user-name"));
        actions.contextClick(userName).perform();

        chromeDriver.quit();



    }
}
