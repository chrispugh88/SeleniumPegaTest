package com.company;

import org.openqa.selenium.WebElement;

/**
 * Created by chris on 08/08/15.
 */
public class RunTest extends BaseTest {
    public static void main(String[] args) {
        getDriver();
        login("User@SAE", "rules");
        createCase("Candidate Case");
        sleep(2000);
        switchIFrame("PegaGadget1Ifr");
        completeTextBox("FirstName", "Test First Name");
        completeTextBox("LastName", "Test Last Name");
        completeTextBox("Email", "test@company.com");
        //completeTextBox("SSN", "12345");
        completeTextBox("PositionAppliedFor", "Senior Software Engineer");
        getButton("Submit").click();
        switchIFrame("PegaGadget1Ifr");
        clickLink("Add Item");
    }
}
