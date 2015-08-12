package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.List;

import static java.lang.System.*;


public class BaseTest {

    public static WebDriver driver;

    protected static void completeTextBoxByID(String inputID, String text) {
        WebElement textBox = getElementWhenReady(By.id(inputID));
        textBox.sendKeys(text);
    }

    protected static void completeTextBoxByName(String inputName, String text) {
        WebElement textBox = getElementWhenReady(By.name(inputName));
        textBox.sendKeys(text);
    }

    protected static WebElement getButton(String buttonText) {
        WebElement button = null;
        for (WebElement it : driver.findElements(By.tagName("button"))) {
            //log(it.getText());
            if (it.getText().contains(buttonText)) {
                button = it;
                //log(button.getText());
                return button;
            }
        }
        return null;
    }

    protected static void clickLink(String linkText) {
        getElementWhenReady(By.linkText(linkText)).click();
    }

    protected static void login(String userID, String password) {
        WebElement idBox = getElementWhenReady(By.id("txtUserID"));
        idBox.sendKeys(userID);
        WebElement passBox = getElementWhenReady(By.id("txtPassword"));
        passBox.sendKeys(password);
        WebElement submitButton = getElementWhenReady(By.id("sub"));
        submitButton.click();
    }

    protected static void createCase(String caseName) {
        getElementWhenReady(By.linkText("Create")).click();
        WebElement createCaseButton = null;
        int i = 0;
        while (createCaseButton == null && i < 40) {
            for (WebElement it : driver.findElements(By.id("ItemMiddle"))) {
                if (it.getText().contains(caseName)) {
                    createCaseButton = it;
                }
            }
            sleep(20);
            i++;
        }
        createCaseButton.click();
    }
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
            log("Waited " + i * 20 + " ms for element " + by);
        }
        return driver.findElement(by);
    }

    protected static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            //log("NoSuchElementException " + e.getLocalizedMessage());
            //Suppress NoSuchElementException logging to keep things clean
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
        driver = new ChromeDriver();
        driver.get("https://paex23-use.pegacloud.com/prweb/PRServlet/beEBp4uRVTogorRwSwWqbKQhhojtVn9i8J9Zo5ruyviHnzw4qg1rm3s7oD3yApZr*/!STANDARD");

    }

    protected static void switchIFrame(String iFrameId) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameId));
    }
}
