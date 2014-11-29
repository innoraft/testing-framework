package TestCOT.StudentRole.Iplan;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddCourseRequest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://satishtest.devcloud.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testAddCourseRequest() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/student-planner");

        // Click Course Planner
        driver.findElement(By.linkText("COURSE PLANNER")).click();
        // Click Add Class
        driver.findElement(By.linkText("Add Class")).click();

        // Click Subject
        driver.findElement(By.id("subject-history_social_science")).click();
        // Click Course Title
        driver.findElement(By.id("node-17164")).click();
        // Click Grade
        driver.findElement(By.id("grade-12")).click();
        // Click Duration
        driver.findElement(By.xpath("//div[3]/input")).click();
        // Click Save
        driver.findElement(By.xpath("//div[@id='edit-actions']/input")).click();

        // Click Subject
        driver.findElement(By.id("subject-physical_education")).click();
        // Click Course Title
        driver.findElement(By.id("node-17188")).click();
        // Click Grade
        driver.findElement(By.id("grade-11")).click();
        // Click Duration
        driver.findElement(By.xpath("//div[3]/input")).click();
        // Click Save
        driver.findElement(By.xpath("//div[@id='edit-actions']/input")).click();

        // Click Finish
        driver.findElement(By.linkText("Finish")).click();
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

