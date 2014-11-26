package TestCOT.TeacherRole.Gradebook;

/**
 * Created by om on 11/19/2014.
 */

import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnterMarksSubmitGrades_Pending {
    private WebDriver driver;
    private String baseUrl;
    private int IntegerValue = 0;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testEnterMarksSubmitGrade() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/my-assignments");

        // Click Submit Grades
        driver.findElement(By.linkText("SUBMIT GRADES")).click();

        // Assign Assignment Number To Student
        driver.findElement(By.id("edit-4341-marks-75486")).clear();
        IntegerValue = func.RandomIntegerNumber(5);
        driver.findElement(By.id("edit-4341-marks-75486")).sendKeys(String.valueOf(IntegerValue));
        driver.findElement(By.id("edit-4346-marks-75486")).clear();
        IntegerValue = func.RandomIntegerNumber(8);
        driver.findElement(By.id("edit-4346-marks-75486")).sendKeys(String.valueOf(IntegerValue));
        driver.findElement(By.id("edit-4351-marks-75486")).clear();
        IntegerValue = func.RandomIntegerNumber(3);
        driver.findElement(By.id("edit-4351-marks-75486")).sendKeys(String.valueOf(IntegerValue));
        driver.findElement(By.id("edit-comments-75486")).clear();
        driver.findElement(By.id("edit-comments-75486")).sendKeys("Good.");
        // Click Save Button
        driver.findElement(By.xpath("//form[@id='gradebook-grade-submit--2']/div/input[3]")).click();
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

// Unable to find the steps on site.