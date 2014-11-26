package TestCOT.SchoolAdminRole.AdminApp;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SaveIplan {
    private WebDriver driver;
    private String baseUrl;
    private String[] Tracking = null;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://satishtest.devcloud.acquia-sites.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testSaveIplan() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("SchoolAdmin");
        driver.get(baseUrl + "/grad-req");

        // Click IPlan
        driver.findElement(By.cssSelector("a.long_term_planner_admin-link.admin-menu-tab-link")).click();
        // Click Add Milestone
        driver.findElement(By.linkText("Add Milestone")).click();

        // Add Milestone
        // Enter Milestone
        driver.findElement(By.id("edit-title")).clear();
        Tracking = func.RandomWords(4);
        driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + Tracking[1] + Tracking[2] + Tracking[3]);
        // Click Add To Calender
        driver.findElement(By.linkText("Add to Calendar")).click();
        driver.findElement(By.id("edit-field-task-due-date-und-0-value-datepicker-popup-0")).click();
        driver.findElement(By.linkText("25")).click();
        // Click "+" Symbol And Enter Task
        driver.findElement(By.id("edit-field-ltp-milestone-task-und-add-more")).click();
        Tracking = func.RandomWords(4);
        driver.findElement(By.id("edit-field-ltp-milestone-task-und-1-value")).sendKeys(Tracking[0] + Tracking[1] + Tracking[2] + Tracking[3]);
        // Select Grade
        driver.findElement(By.xpath("//div[5]/div/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"edit_field_ltp_milestone_grade_dummy_chzn_o_3\"]")).click();
        // Select Team
        driver.findElement(By.xpath("//div[6]/div/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"edit_field_ltp_milestone_month_dummy_chzn_o_2\"]")).click();
        // Enter Order
        driver.findElement(By.id("edit-field-ltp-milestone-order-und-0-value")).clear();
        driver.findElement(By.id("edit-field-ltp-milestone-order-und-0-value")).sendKeys("4");
        // Enter Notes
        driver.findElement(By.id("edit-field-ltp-milestone-notes-und-0-value")).clear();
        Tracking = func.RandomWords(4);
        driver.findElement(By.id("edit-field-ltp-milestone-notes-und-0-value")).sendKeys(Tracking[0] + Tracking[1] + Tracking[2] + Tracking[3]);
        // Click Save Button
        driver.findElement(By.xpath("//div[11]/input")).click();
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

