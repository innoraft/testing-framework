package TestCOT.TeacherRole.Iplan;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddMilestoneInItask_Pending {
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
    public void testAddMilestoneInItask() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/student-planner");

        driver.findElement(By.linkText("ITASKS")).click();
        // Career & Majors
        driver.findElement(By.cssSelector("div.careers-major-link")).click();
        driver.findElement(By.cssSelector("div.close-button > img")).click();
        // Add milestone
        driver.findElement(By.linkText("Add Milestone")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("Magnetic field");
        driver.findElement(By.id("edit-field-ltp-milestone-task-und-0-value")).clear();
        driver.findElement(By.id("edit-field-ltp-milestone-task-und-0-value")).sendKeys("create magnet");
        driver.findElement(By.id("edit-field-ltp-milestone-task-und-1-value")).clear();
        driver.findElement(By.id("edit-field-ltp-milestone-task-und-1-value")).sendKeys("create magnetic field");
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.id("edit-field-ltp-milestone-order-und-0-value")).clear();
        driver.findElement(By.id("edit-field-ltp-milestone-order-und-0-value")).sendKeys("4");
        driver.findElement(By.id("edit-field-ltp-milestone-notes-und-0-value")).clear();
        driver.findElement(By.id("edit-field-ltp-milestone-notes-und-0-value")).sendKeys("also very important chapter in physics");
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.cssSelector("#April-891691 > div.title")).click();
        driver.findElement(By.cssSelector("#ltp-milestone-overlay-April-891691 > div.close-button-wrapper > span.close-button > img")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div[4]/div/div/div/div/ul[2]/li")).click();
        driver.findElement(By.cssSelector("li.student--grades--month-text.grade-10-month-April")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div[4]/div/div/div/div/ul/li")).click();
        driver.findElement(By.cssSelector("div.careers-major-link")).click();
        driver.findElement(By.cssSelector("div.close-button > img")).click();
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

// Write code for single chosen select list and submit button.