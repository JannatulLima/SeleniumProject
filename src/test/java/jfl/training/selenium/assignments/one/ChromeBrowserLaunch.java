package jfl.training.selenium.assignments.one;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeBrowserLaunch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://www.aiub.edu/");
        chromeDriver.manage().window().maximize();
        System.out.println("Webpage title is: " + chromeDriver.getTitle());
        System.out.println("Current page's URL is: " + chromeDriver.getCurrentUrl());
        chromeDriver.manage().window().minimize();
        chromeDriver.quit();
    }
}
