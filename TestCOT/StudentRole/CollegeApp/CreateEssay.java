package TestCOT.StudentRole.CollegeApp;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateEssay {
    Functions func;
    private WebDriver driver;
    private String[] Tracking = null;
    private String TrackingValues = "";
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        func = new Functions(driver);
        driver.manage().timeouts().implicitlyWait(func.timeoutOFAllElement, TimeUnit.SECONDS);

        driver.get(func.baseUrl + "/");
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(func.baseUrl + "/college-search");
    }

    @Test
    public void testCreateEssay() throws Exception {
        // Click Essay
        driver.findElement(By.linkText("ESSAYS")).click();

        if(isElementPresent(By.linkText("Create Your First Essay"))) {
            // Click "Create Your First Essay"
            driver.findElement(By.linkText("Create Your First Essay")).click();
        } else if (isElementPresent(By.linkText("Add Essay Topic"))) {
            // Click "Add Essay Topic"
            driver.findElement(By.linkText("Add Essay Topic")).click();
        }

        // Add Essay Topic
        // Select Type
        new Select(driver.findElement(By.id("edit-field-essay-type-und"))).selectByVisibleText("Scholarship");
        // Enter University
        driver.findElement(By.id("edit-field-essay-university-und-0-value")).clear();
        Tracking = func.RandomWords(1);
        driver.findElement(By.id("edit-field-essay-university-und-0-value")).sendKeys(Tracking[0]);
        // Enter Topic
        driver.findElement(By.id("edit-body-und-0-value")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-body-und-0-value")).sendKeys(Tracking[0] + " " + Tracking[1]);
        // Click "+" Symbol
        driver.findElement(By.xpath("//div[6]/input")).click();

        // Create Essay
        // Click "+" Symbol
        driver.findElement(By.xpath("//td[4]/a")).click();
        // Click Source
        driver.findElement(By.id("cke_8_label")).click();
        // Enter Essay
        driver.findElement(By.cssSelector("textarea.cke_source.cke_enable_context_menu")).clear();
        Tracking = func.RandomWords(8);
        for(int i= 0 ; i < Tracking.length ; i++) {
            TrackingValues = TrackingValues + " " + Tracking[i];
        }
        driver.findElement(By.cssSelector("textarea.cke_source.cke_enable_context_menu")).sendKeys("<p>" + TrackingValues + " </p>");
        // Click Save
        driver.findElement(By.id("edit-save-temp")).click();

        // Click Essay
        driver.findElement(By.linkText("ESSAYS")).click();
        Thread.sleep(300);
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

