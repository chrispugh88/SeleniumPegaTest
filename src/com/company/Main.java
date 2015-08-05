package com.company;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Selenium");
        System.setProperty("webdriver.chrome.driver", "/home/chris/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://paex18-eu.pegacloud.com/prweb/PRServlet/rP_YUoU5v4VpHC7zgKdtRfYWDHA1OZuBuy0m0RSuAe3jprP1sRDOB97lQGjOixzt*/!STANDARD?pzPostData=1733018079");

        WebElement idBox = driver.findElement(By.id("txtUserID"));
        idBox.sendKeys("HR_Recruiter");
        WebElement passBox = driver.findElement(By.id("txtPassword"));
        passBox.sendKeys("password");
        WebElement submitButton = driver.findElement(By.id("sub"));
        submitButton.click();
        /*int ms = 5000;
        sleep(ms);
        WebElement createMenu = driver.findElement(By.linkText("Create"));
        createMenu.click();
        */
//        driver.findElement(By.linkText("Create"));
        getElementWhenReady(By.linkText("Create")).click();
        //driver.quit();
        //comment Hello everybody
    }

    //System.setProperty("webdriver.chrome.driver", "/home/chris/chromedriver");
    static WebDriver driver;

    protected static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected static WebElement getElementWhenReady(By by) throws NoSuchElementException {
        int i = 0;
        while (!isElementPresent(by)) {
            sleep(20);
            if (++i >= 40) throw new NoSuchElementException("Fucked");
            log(" " + i * 20);
        }
        return driver.findElement(by);
    }

    protected static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            log("NoSuchElementException " + e.getLocalizedMessage());
            return false;
        } catch (StaleElementReferenceException e) {
            log("StaleElementReferenceException " + e.getLocalizedMessage());
            return false;
        }
    }

    protected static void log(String message) {
        System.out.println("SelLog   " + message);
    }

    protected static void getDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/chris/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://paex18-eu.pegacloud.com/prweb/PRServlet/rP_YUoU5v4VpHC7zgKdtRfYWDHA1OZuBuy0m0RSuAe3jprP1sRDOB97lQGjOixzt*/!STANDARD?pzPostData=1733018079");
    }
}
