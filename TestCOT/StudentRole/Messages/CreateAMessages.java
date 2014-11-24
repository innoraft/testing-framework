package TestCOT.StudentRole.Messages;

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

public class CreateAMessages {
    private WebDriver driver;
    private String baseUrl;
    private String[] Tracking = null;
    private String TrackingValues = "";
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
    public void testCreateAMessages() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/messages");

        // Click Dialog
        driver.findElement(By.linkText("DIALOG")).click();

        // Send Message
        // Select Options
        driver.findElement(By.xpath("//div[@id='edit_recipient_individuals_chzn']/ul")).click();
        driver.findElement(By.xpath("//*[@id=\"edit_recipient_individuals_chzn_o_1\"]")).click();
        // Enter Subject
        driver.findElement(By.id("edit-subject")).click();
        driver.findElement(By.id("edit-subject")).clear();
        Tracking = func.RandomWords(1);
        driver.findElement(By.id("edit-subject")).sendKeys(Tracking[0]);
        // Enter Message
        driver.findElement(By.id("edit-body-value")).clear();
        Tracking = func.RandomWords(5);
        for(int i= 0 ; i < Tracking.length ; i++) {
            TrackingValues = TrackingValues + " " + Tracking[i];
        }
        driver.findElement(By.id("edit-body-value")).sendKeys(TrackingValues);
        // Click Send Message
        driver.findElement(By.xpath("//div[@id='edit-actions--2']/input")).click();

        // Send Message
        // Click Subject
        driver.findElement(By.cssSelector("a.use-ajax.ajax-processed")).click();
        // Enter Message
        driver.findElement(By.id("edit-body-value--2")).clear();
        Tracking = func.RandomWords(10);
        for(int i= 0 ; i < Tracking.length ; i++) {
            TrackingValues = TrackingValues + " " + Tracking[i];
        }
        driver.findElement(By.id("edit-body-value--2")).sendKeys("this is a dummy message");
        // Click Send Message
        driver.findElement(By.xpath("//div[@id='edit-actions--3']/input")).click();

        // To Remove Message
        driver.findElement(By.linkText("Remove")).click();
        // Click "Yes" Button
        driver.findElement(By.xpath("//div[11]/div/button")).click();
        // To Undone Removed Message
        driver.findElement(By.linkText("undone")).click();
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