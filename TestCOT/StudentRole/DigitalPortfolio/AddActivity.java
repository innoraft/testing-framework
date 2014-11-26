package TestCOT.StudentRole.DigitalPortfolio;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddActivity {
    private WebDriver driver;
    private String baseUrl;
    private int Max = 12;
    private int Min = 6;
    private int IntegerValue = 0;
    private WebDriverWait wait;
    private String[] Tracking = null;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 400);
        baseUrl = "http://satishtest.devcloud.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testAddActivity() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/journals");

        // Click Activities
        driver.findElement(By.linkText("ACTIVITIES")).click();
        // Click Create Activity
        driver.findElement(By.linkText("CREATE ACTIVITY")).click();

        // Create Activity
        // Enter Activity
        driver.findElement(By.id("edit-field-activity-activities-und-0-value")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-field-activity-activities-und-0-value")).sendKeys(Tracking[0] + " " + Tracking[1]);
        // Enter Grade
        driver.findElement(By.id("edit-field-activity-grade-und-0-value")).clear();
        IntegerValue = func.RandomIntegerNumberBetweenRange(Max, Min);
        driver.findElement(By.id("edit-field-activity-grade-und-0-value")).sendKeys(String.valueOf(IntegerValue));
        // Enter Hours Per Week
        driver.findElement(By.id("edit-field-activity-hours-p-week-und-0-value")).clear();
        Max = 168;
        IntegerValue = func.RandomIntegerNumber(Max);
        driver.findElement(By.id("edit-field-activity-hours-p-week-und-0-value")).sendKeys(String.valueOf(IntegerValue));
        // Enter Weeks Per Year
        driver.findElement(By.id("edit-field-activity-weeks-p-year-und-0-value")).clear();
        Max = 52;
        IntegerValue = func.RandomIntegerNumber(Max);
        driver.findElement(By.id("edit-field-activity-weeks-p-year-und-0-value")).sendKeys(String.valueOf(IntegerValue));
        // Enter Positions
        driver.findElement(By.id("edit-field-activity-positions-und-0-value")).clear();
        Tracking = func.RandomWords(1);
        driver.findElement(By.id("edit-field-activity-positions-und-0-value")).sendKeys(Tracking[0]);
        // Check Citizenship
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-citizenship")).click();
        // Check Self-Motivation
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-self-motivation")).click();
        // Check Initiative
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-initiative")).click();
        // Check Leadership
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-leadership")).click();
        // Check Technical Mastery
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-technical-mastery")).click();
        // Click Save Button
        driver.findElement(By.xpath("//form/div/div[9]/input")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("//form/div/div[9]/input")));
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