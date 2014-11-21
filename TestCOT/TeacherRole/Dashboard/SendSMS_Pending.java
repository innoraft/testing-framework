package TestCOT.TeacherRole.Dashboard;

/**
 * Created by om on 11/12/2014.
 */
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import TestCOT.Common.Functions;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SendSMS_Pending {
    private WebDriver driver;
    private String baseUrl;
    private String[] Tracking = null;
    private String TrackingValues = null;
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
    public void testSendSms() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/students-dashboard/75486");

        // Click SMS
        driver.findElement(By.linkText("SMS")).click();

        // Send Message
        // Click Individuals
        driver.findElement(By.id("edit-recipient-type-0")).click();
        // Select Options
        WebElement dropdown1 = driver.findElement(By.id("dtDD"));
        Select selectDropdown1 = new Select(dropdown1);
        List<WebElement> all1 = selectDropdown1.getOptions();
        for(WebElement we:all1) {
            if(we.getText().equals("[10] Basant Sharma"))
                we.click();
        }
        // Enter Message
        driver.findElement(By.id("edit-body")).click();
        driver.findElement(By.id("edit-body")).clear();
        Tracking = func.RandomWords(7);
        for(int i= 0 ; i < Tracking.length ; i++) {
            TrackingValues = TrackingValues + " " + Tracking[i];
        }
        driver.findElement(By.id("edit-body")).sendKeys(TrackingValues);
        // Click Send Message
        driver.findElement(By.id("edit-submit")).click();

        // Send message
        // Click Groups
        driver.findElement(By.id("edit-recipient-type-1")).click();
        // Select Options
        WebElement dropdown2 = driver.findElement(By.id("dtDD"));
        Select selectDropdown2 = new Select(dropdown2);
        List<WebElement> all2 = selectDropdown2.getOptions();
        for(WebElement we:all2) {
            if(we.getText().equals("ABC"))
                we.click();
        }
        // Enter Message
        driver.findElement(By.id("edit-body")).click();
        driver.findElement(By.id("edit-body")).clear();
        Tracking = func.RandomWords(7);
        for(int i= 0 ; i < Tracking.length ; i++) {
            TrackingValues = TrackingValues + " " + Tracking[i];
        }
        driver.findElement(By.id("edit-body")).sendKeys(TrackingValues);
        // Click Send Message
        driver.findElement(By.id("edit-submit")).click();
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

// Write code for single chosen select list.