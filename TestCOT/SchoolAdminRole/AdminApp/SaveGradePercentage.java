package TestCOT.SchoolAdminRole.AdminApp;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SaveGradePercentage {
    Functions func;
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private int Max = 50;
    private Double DecimalValue = 0.0;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        func = new Functions(driver);
        driver.manage().timeouts().implicitlyWait(func.timeoutOFAllElement, TimeUnit.SECONDS);

        driver.get(func.baseUrl + "/");
        func.CheckLogin();
        func.LoginRole("SchoolAdmin");
        driver.get(func.baseUrl + "/discipline-admin");
    }

    @Test
    public void testSaveGradePercentage() throws Exception {
        // Click Grade Percentage
        driver.findElement(By.linkText("Grade Percentages")).click();

        // Check "Letter Grading" Checked or not. If not, than Check it.
        if (!driver.findElement(By.id("edit-system-1")).isSelected()) {
            driver.findElement(By.id("edit-system-1")).click();
        }
        // Enter Minimum Passing Grade Equivalence
        driver.findElement(By.id("edit-passing-marks")).clear();
        DecimalValue = func.RandomDecimalNumber(Max);
        driver.findElement(By.id("edit-passing-marks")).sendKeys(String.valueOf(DecimalValue));
        // Enter Minimum Passing Grade Transfer
        driver.findElement(By.id("edit-min-pass-t")).clear();
        DecimalValue = func.RandomDecimalNumber(Max);
        driver.findElement(By.id("edit-min-pass-t")).sendKeys(String.valueOf(DecimalValue));
        // Click Save For Minimum Passing Grade Equivalence
        driver.findElement(By.xpath("//form[3]/div/div/input")).click();
        // Click Save For Minimum Passing Grade Transfer
        driver.findElement(By.xpath("//form[4]/div/div/input")).click();
        // Check "Remove" button for "Signature" present or not. If present than click it.
        if(isElementPresent(By.id("edit-field-transcript-signature-und-0-remove-button"))) {
            driver.findElement(By.id("edit-field-transcript-signature-und-0-remove-button")).click();
        }
        // Upload File
        driver.findElement(By.id("edit-field-transcript-signature-und-0-upload")).sendKeys("C:\\Users\\om\\Downloads\\abc.jpg");
        // Check "Remove" button for "School logo" present or not. If present than click it.
        if(isElementPresent(By.id("edit-field-transcript-school-logo-und-0-remove-button"))) {
            driver.findElement(By.id("edit-field-transcript-school-logo-und-0-remove-button")).click();
        }
        // Upload File
        driver.findElement(By.id("edit-field-transcript-school-logo-und-0-upload")).sendKeys("C:\\Users\\om\\Downloads\\xyz.jpg");
        // Click Save
        driver.findElement(By.xpath("//div[4]/input")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

