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
        //sleep(2000);
        switchIFrame("PegaGadget1Ifr");
        completeTextBoxByID("FirstName", "Test First Name");
        completeTextBoxByID("LastName", "Test Last Name");
        completeTextBoxByID("Email", "test@company.com");
        //completeTextBox("SSN", "12345");
        completeTextBoxByID("PositionAppliedFor", "Senior Software Engineer");
        getButton("Submit").click();
        int rows = 8;
        for (int i = 1; i <= rows; i++) {
            completeTextBoxByName("$PpyWorkPage$pWorkHistory$l" + i + "$pCompanyName", "Text Company " + i);
            completeTextBoxByName("$PpyWorkPage$pWorkHistory$l" + i + "$pStartDate", "11/08/2015");
            if (i < rows) {
                clickLink("Add Item");
            }
        }
        getButton("Submit").click();
        //completeTextBoxByName("$PpyWorkPage$pSkills", "Selenium");

    }
}
