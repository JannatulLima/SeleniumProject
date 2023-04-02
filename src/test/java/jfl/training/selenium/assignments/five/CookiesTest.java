package jfl.training.selenium.assignments.five;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CookiesTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.pokemon.com/us/cookie-page/");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        chromeDriver.manage().addCookie(new Cookie("language", "English"));
        chromeDriver.manage().addCookie(new Cookie("timezone", "UTC"));
        System.out.println(chromeDriver.manage().getCookieNamed("language"));
        chromeDriver.manage().deleteCookieNamed("language");
        Set<Cookie> cookieSet = chromeDriver.manage().getCookies();
        System.out.println(cookieSet.size());
        for (Cookie cookie : cookieSet) {
            System.out.println(cookie.getName() + " " + cookie.isHttpOnly());
        }
        chromeDriver.quit();
    }
}