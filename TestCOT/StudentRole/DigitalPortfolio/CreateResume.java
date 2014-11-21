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
import org.openqa.selenium.support.ui.Select;

public class CreateResume {
    private WebDriver driver;
    private String baseUrl;
    private int Max = 50;
    private int IntegerValue = 0;
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
    public void testCreateResume() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/journals");

        driver.findElement(By.linkText("RESUME")).click();
        // Click Add Resume
        driver.findElement(By.linkText("ADD RESUME")).click();

        // Enter Contact Info
        driver.findElement(By.id("edit-field-resume-contact-info-und-0-value")).clear();
        Tracking = func.RandomWords(7);
        for(int i= 0 ; i < Tracking.length ; i++) {
            TrackingValues = TrackingValues + " " + Tracking[i];
        }
        driver.findElement(By.id("edit-field-resume-contact-info-und-0-value")).sendKeys(TrackingValues);

        // Enter Objective
        driver.findElement(By.id("edit-field-essay-objective-und-0-value")).clear();
        Tracking = func.RandomWords(10);
        for(int i= 0 ; i < Tracking.length ; i++) {
            TrackingValues = TrackingValues + " " + Tracking[i];
        }
        driver.findElement(By.id("edit-field-essay-objective-und-0-value")).sendKeys(TrackingValues);

        // Education
        // Enter School/College/Course
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-school-college-und-0-value")).clear();
        Tracking = func.RandomWords(3);
        for(int i= 0 ; i < Tracking.length ; i++) {
            TrackingValues = TrackingValues + " " + Tracking[i];
        }
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-school-college-und-0-value")).sendKeys(TrackingValues);
        // Enter Location
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-location-und-0-value")).clear();
        Tracking = func.RandomWords(1);
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-location-und-0-value")).sendKeys(Tracking[0]);
        // Enter Year
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-year-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-year-und-0-value")).sendKeys("June 2014 - April 2015");
        // Enter Brief Info
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-brief-info-und-0-value")).clear();
        Tracking = func.RandomWords(10);
        for(int i= 0 ; i < Tracking.length ; i++) {
            TrackingValues = TrackingValues + " " + Tracking[i];
        }
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-brief-info-und-0-value")).sendKeys(TrackingValues);

        // Enter Awards & Honors
        driver.findElement(By.id("edit-field-essay-award-honors-und-0-value")).clear();
        Tracking = func.RandomWords(3);
        driver.findElement(By.id("edit-field-essay-award-honors-und-0-value")).sendKeys(Tracking[0] + " " + Tracking[1] + " " + Tracking[2]);

        // Enter Experience
        driver.findElement(By.id("edit-field-essay-extracurricular-und-0-value")).clear();
        Tracking = func.RandomWords(1);
        driver.findElement(By.id("edit-field-essay-extracurricular-und-0-value")).sendKeys(Tracking[0]);

        // Enter Work Experience
        // Enter organisation
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-organisation-und-0-value")).clear();
        Tracking = func.RandomWords(1);
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-organisation-und-0-value")).sendKeys(Tracking[0]);
        // Enter Location
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-location-und-0-value")).clear();
        Tracking = func.RandomWords(1);
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-location-und-0-value")).sendKeys(Tracking[0]);
        // Enter Year
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-year-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-year-und-0-value")).sendKeys("June 2013 - April 2014");
        // Save Resume
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.linkText("Print")).click();
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

// How to fill up the form.