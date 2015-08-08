package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.List;

import static java.lang.System.*;


public class BaseTest {

    public static void main(String[] args) {
        out.println("Hello Selenium");
        setProperty("webdriver.chrome.driver", "/home/chris/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://paex23-use.pegacloud.com/prweb/PRServlet/beEBp4uRVTogorRwSwWqbKQhhojtVn9i8J9Zo5ruyviHnzw4qg1rm3s7oD3yApZr*/!STANDARD");

        WebElement idBox = driver.findElement(By.id("txtUserID"));
        idBox.sendKeys("User@SAE");
        WebElement passBox = driver.findElement(By.id("txtPassword"));
        passBox.sendKeys("rules");
        WebElement submitButton = driver.findElement(By.id("sub"));
        submitButton.click();
        /*int ms = 5000;
        sleep(ms);
        WebElement createMenu = driver.findElement(By.linkText("Create"));
        createMenu.click();
        */
//        driver.findElement(By.linkText("Create"));
        getElementWhenReady(By.linkText("Create")).click();
        //java.util.List<WebElement> newList = (java.util.List<WebElement>) new List();
        //newList = driver.findElements(By.id("ItemMiddle"));
        //for
        //String tempString = new String();
        //getElementWhenReady(By.id("ItemMiddle")).click();
        //out.println("Test " + getElementWhenReady(By.id("ItemMiddle")).getText());

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
        out.println("SelLog   " + message);
    }

    protected static void getDriver() {
        setProperty("webdriver.chrome.driver", "/home/chris/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://paex18-eu.pegacloud.com/prweb/PRServlet/rP_YUoU5v4VpHC7zgKdtRfYWDHA1OZuBuy0m0RSuAe3jprP1sRDOB97lQGjOixzt*/!STANDARD?pzPostData=1733018079");
    }
}
