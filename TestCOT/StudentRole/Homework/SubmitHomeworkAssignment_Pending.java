package TestCOT.StudentRole.Homework;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import TestCOT.Common.Functions;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SubmitHomeworkAssignment_Pending {
    private WebDriver driver;
    private String baseUrl;
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
    public void testSubmitHomeworkAssignment() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/assigned-lesson");

        driver.findElement(By.linkText("Homework Assignments")).click();
        driver.findElement(By.linkText("Homework Assignments")).click();
        driver.findElement(By.linkText("number system")).click();
        driver.findElement(By.id("edit-task-status")).click();
        driver.findElement(By.id("edit-task-status--2")).click();
        driver.findElement(By.id("edit-task-status--3")).click();
        driver.findElement(By.linkText("View Workspace")).click();
        driver.findElement(By.cssSelector("html.CSS1Compat")).click();
        driver.findElement(By.linkText("Submit")).click();
        driver.findElement(By.id("edit-submit-workspace")).click();
        driver.findElement(By.linkText("Homework Assignments")).click();
        driver.findElement(By.linkText("Homework Assignments")).click();
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
