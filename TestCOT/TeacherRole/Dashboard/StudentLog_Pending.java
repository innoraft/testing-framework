package TestCOT.TeacherRole.Dashboard;

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
import org.openqa.selenium.support.ui.Select;

public class StudentLog_Pending {
    private WebDriver driver;
    private String baseUrl;
    private String[] Tracking = null;
    private String CheckEntry = null;
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
    public void testStudentLog() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/students-dashboard/75486");

        driver.findElement(By.linkText("Student Log")).click();
        if(isElementPresent(By.linkText("Click here to create a log entry"))) {
            driver.findElement(By.linkText("Click here to create a log entry")).click();
//        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
//        driver.findElement(By.cssSelector("#edit_field_stu_log_message_type_und_chzn > a.chzn-single > span")).click();
            driver.findElement(By.id("edit-title")).click();
            driver.findElement(By.id("edit-title")).clear();
            Tracking = func.RandomWords(2);
            driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + " " + Tracking[1]);
            CheckEntry = Tracking[0] + " " + Tracking[1];
//        driver.findElement(By.cssSelector("input.default")).click();
//        driver.findElement(By.cssSelector("#student-log-entry-node-form > div")).click();
            driver.findElement(By.id("edit-field-log-entry-description-und-0-value")).clear();
            Tracking = func.RandomWords(2);
            driver.findElement(By.id("edit-field-log-entry-description-und-0-value")).sendKeys(Tracking[0] + " " + Tracking[1]);
            // TODO: Write code for submit button.
        } else if(isElementPresent(By.linkText("+"))) {
            driver.findElement(By.linkText("Click here to create a log entry")).click();
//        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
//        driver.findElement(By.cssSelector("#edit_field_stu_log_message_type_und_chzn > a.chzn-single > span")).click();
            driver.findElement(By.id("edit-title")).click();
            driver.findElement(By.id("edit-title")).clear();
            Tracking = func.RandomWords(2);
            driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + " " + Tracking[1]);
            CheckEntry = Tracking[0] + " " + Tracking[1];
//        driver.findElement(By.cssSelector("input.default")).click();
//        driver.findElement(By.cssSelector("#student-log-entry-node-form > div")).click();
            driver.findElement(By.id("edit-field-log-entry-description-und-0-value")).clear();
            Tracking = func.RandomWords(2);
            driver.findElement(By.id("edit-field-log-entry-description-und-0-value")).sendKeys(Tracking[0] + " " + Tracking[1]);
            // TODO: Write code for submit button.
        }

        driver.findElement(By.linkText(CheckEntry)).click();
        driver.findElement(By.cssSelector("span.close-button > img")).click();
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

// Write code for single chosen select list at step
// Write code for multiple chosen select list at step