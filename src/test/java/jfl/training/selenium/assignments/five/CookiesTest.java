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

        chromeDriver.manage().addCookie(new Cookie("language", "English")); //add cookie
        chromeDriver.manage().addCookie(new Cookie("timezone", "UTC")); //add cookie
        System.out.println(chromeDriver.manage().getCookieNamed("language")); //get cookie by cookie name
        chromeDriver.manage().deleteCookieNamed("language"); //delete cookie by cookie name
        Set<Cookie> cookieSet = chromeDriver.manage().getCookies(); //get all cookies
        System.out.println(cookieSet.size()); //print total cookie count
        for (Cookie cookie : cookieSet) {
            System.out.println(cookie.getName() + " " + cookie.isHttpOnly()); //print all cookies
        }
        chromeDriver.manage().deleteAllCookies(); //delete all cookies
        System.out.println(cookieSet.size()); //print total cookie count
        chromeDriver.quit();
    }
}