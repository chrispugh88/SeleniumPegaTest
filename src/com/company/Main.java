package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Selenium");
        System.setProperty("webdriver.chrome.driver", "/home/chris/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://paex18-eu.pegacloud.com/prweb/PRServlet");
        WebElement idBox = driver.findElement(By.id("txtUserID"));
        idBox.sendKeys("HR_Recruiter");
        WebElement passBox = driver.findElement(By.id("txtPassword"));
        passBox.sendKeys("password");
        WebElement submitButton = driver.findElement(By.id("sub"));
        submitButton.click();
        //driver.quit();
        //comment
    }
}
