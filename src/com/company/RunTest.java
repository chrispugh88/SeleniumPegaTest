package com.company;

/**
 * Created by chris on 08/08/15.
 */
public class RunTest extends BaseTest {
    public static void main(String[] args) {
        getDriver();
        login("User@SAE", "rules");
        createCase("Candidate Case");
        sleep(2000);
        completeTextBox("FirstName", "Test First Name");
        completeTextBox("LastName", "Test Last Name");
    }
}
