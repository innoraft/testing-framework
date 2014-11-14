package TestCOT.SchoolAdminRole.AdminApp;

/**
 * Created by om on 11/12/2014.
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import TestCOT.Common.Functions;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.experimental.max.MaxCore;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SaveGradePercentage {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private int Max = 50;
    private Double DecimalValue = 0.0;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testSaveGradePercentage() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("SchoolAdmin");
        driver.get(baseUrl + "/discipline-admin");

        driver.findElement(By.linkText("Grade Percentages")).click();
        // Check radioButton "Letter Grading" selected or not. If not, than select it.
        if (!driver.findElement(By.id("edit-system-1")).isSelected()) {
            driver.findElement(By.id("edit-system-1")).click();
        }
        driver.findElement(By.id("edit-passing-marks")).clear();
        DecimalValue = func.RandomDecimalNumber(Max);
        driver.findElement(By.id("edit-passing-marks")).sendKeys(String.valueOf(DecimalValue));
        driver.findElement(By.id("edit-min-pass-t")).clear();
        DecimalValue = func.RandomDecimalNumber(Max);
        driver.findElement(By.id("edit-min-pass-t")).sendKeys(String.valueOf(DecimalValue));
        driver.findElement(By.id("edit-submit--4")).click();
        driver.findElement(By.id("edit-submit--5")).click();

        // Check "Remove" button for "Signature" presented or not. If present than click it.
        if(isElementPresent(By.id("edit-field-transcript-signature-und-0-remove-button"))) {
            driver.findElement(By.id("edit-field-transcript-signature-und-0-remove-button")).click();
        }
        driver.findElement(By.id("edit-field-transcript-signature-und-0-upload")).sendKeys("C:\\Users\\om\\Downloads\\Business Process Outsourcing (BPO) Services_Market Segments_Healthcare BPO Services.jpg");

        // Check "Remove" button for "School logo" presented or not. If present than click it.
        if(isElementPresent(By.id("edit-field-transcript-school-logo-und-0-remove-button"))) {
            driver.findElement(By.id("edit-field-transcript-school-logo-und-0-remove-button")).click();
        }
        driver.findElement(By.id("edit-field-transcript-school-logo-und-0-upload")).sendKeys("C:\\Users\\om\\Downloads\\Business Process Outsourcing (BPO) Services_Service Portfolio_Technical Support Services (2).jpg");
        driver.findElement(By.id("edit-submit--7")).click();
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

