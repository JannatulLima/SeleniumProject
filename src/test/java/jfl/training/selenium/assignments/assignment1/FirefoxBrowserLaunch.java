package jfl.training.selenium.assignments.assignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserLaunch {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver = new FirefoxDriver();

        firefoxDriver.get("https://www.aiub.edu/");
        firefoxDriver.manage().window().maximize();
        System.out.println("Webpage title is: " + firefoxDriver.getTitle());
        System.out.println("Current page's URL is: " + firefoxDriver.getCurrentUrl());
        firefoxDriver.quit();
    }
}
