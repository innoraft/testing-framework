package TestCOT.TeacherRole.Homework;

import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDigitalTest_Pending {
    private WebDriver driver;
    private String baseUrl;
    private String[] Tracking = null;
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
    public void testCreateDigital() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/lesson-library");

        // Click Online Tests
        driver.findElement(By.linkText("ONLINE TESTS")).click();
        // Create Online Tests
        driver.findElement(By.linkText("Create Online Tests")).click();

        // Online Test Form
        // Enter Test Title
        driver.findElement(By.id("edit-title")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + " " + Tracking[1]);
        // Click Save Button
        driver.findElement(By.xpath("//form[@id='onlinetest-title-form']/div/input")).click();

        // Create Test
        // Add a Field

        // Enter Title
        driver.findElement(By.id("edit-title")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + " " + Tracking[1]);
        // Click Options
        driver.findElement(By.xpath("//form[@id='form-builder-field-configure']/div/ul/li[2]/span")).click();
        // Remove One Option
        driver.findElement(By.xpath("//table[@id='edit-options-options-field-widget']/tbody/tr[3]/td[3]/a[2]")).click();
        // Enter Value For First Option
        driver.findElement(By.xpath("//input[@value='Choice 1']")).clear();
        driver.findElement(By.xpath("//input[@value='Choice 1']")).sendKeys("0");
        // Enter Value For Second Option
        driver.findElement(By.xpath("//input[@value='Choice 2']")).clear();
        driver.findElement(By.xpath("//input[@value='Choice 2']")).sendKeys("1");
        // Click Save Test Button
        driver.findElement(By.linkText("Save Test")).click();

        driver.findElement(By.id("edit-new-1415860870029")).click();
        driver.findElement(By.id("edit-max-marks")).clear();
        driver.findElement(By.id("edit-max-marks")).sendKeys("5");
        driver.findElement(By.xpath("//form[@id='form-builder-field-configure']/div/ul/li[2]/span")).click();
        driver.findElement(By.name("edit-options-options-field-widget-default")).click();
        driver.findElement(By.xpath("//form[@id='form-builder-field-configure']/div/ul/li/span")).click();
        driver.findElement(By.linkText("Save Test")).click();
        driver.findElement(By.linkText("Publish Test")).click();
        driver.findElement(By.linkText("Assign")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=assign_students | label=[10] Basant Sharma]]
        driver.findElement(By.cssSelector("option[value=\"75486\"]")).click();
        driver.findElement(By.id("edit-due-date-datepicker-popup-0")).click();
        driver.findElement(By.linkText("25")).click();
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

// Write code for drag and drop of element.