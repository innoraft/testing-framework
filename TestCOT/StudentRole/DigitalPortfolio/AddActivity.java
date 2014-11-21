package TestCOT.StudentRole.DigitalPortfolio;

/**
 * Created by om on 11/12/2014.
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import TestCOT.Common.Functions;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
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
        // Fill Activity form
        driver.findElement(By.id("edit-field-activity-activities-und-0-value")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-field-activity-activities-und-0-value")).sendKeys(Tracking[0] + " " + Tracking[1]);
        driver.findElement(By.id("edit-field-activity-grade-und-0-value")).clear();
        IntegerValue = func.RandomIntegerNumberBetweenRange(Max, Min);
        driver.findElement(By.id("edit-field-activity-grade-und-0-value")).sendKeys(String.valueOf(IntegerValue));
        driver.findElement(By.id("edit-field-activity-hours-p-week-und-0-value")).clear();
        Max = 168;
        IntegerValue = func.RandomIntegerNumber(Max);
        driver.findElement(By.id("edit-field-activity-hours-p-week-und-0-value")).sendKeys(String.valueOf(IntegerValue));
        driver.findElement(By.id("edit-field-activity-weeks-p-year-und-0-value")).clear();
        Max = 52;
        IntegerValue = func.RandomIntegerNumber(Max);
        driver.findElement(By.id("edit-field-activity-weeks-p-year-und-0-value")).sendKeys(String.valueOf(IntegerValue));
        driver.findElement(By.id("edit-field-activity-positions-und-0-value")).clear();
        Tracking = func.RandomWords(1);
        driver.findElement(By.id("edit-field-activity-positions-und-0-value")).sendKeys(Tracking[0]);
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-citizenship")).click();
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-self-motivation")).click();
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-initiative")).click();
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-leadership")).click();
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-technical-mastery")).click();
        // Save the activity form
        driver.findElement(By.xpath("//*[@id=\"edit-submit--5\"]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("//*[@id=\"edit-submit--5\"]")));
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