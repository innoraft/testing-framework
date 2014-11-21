package TestCOT.TeacherRole.Gradebook;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import TestCOT.Common.Functions;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateSubmitGrade_Pending {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;
    private String[] Tracking = null;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 20);
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testCreateSubmitGrade() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/my-assignments");

        // Click Submit Grades
        driver.findElement(By.linkText("SUBMIT GRADES")).click();
        // Click Add Assignment/Test
        driver.findElement(By.linkText("ADD ASSIGNMENT/TEST")).click();

        // Add Assignment/Test
        // Select Course
        new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("algebra");
        // Select Grading Standards
        new Select(driver.findElement(By.xpath("//div[3]/div/select"))).selectByVisibleText("eynwv yrtzy");
        // Select Semester
        new Select(driver.findElement(By.xpath("//div[4]/div/select"))).selectByVisibleText("First Semester");
        // Enter Assignment Title
        driver.findElement(By.id("edit-title")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + " " + Tracking[1]);
        // Assessment
        // Enter Name
        driver.findElement(By.id("edit-field-assessment-collection-und-0-field-grade-assessment-name-und-0-value--4")).clear();
        driver.findElement(By.id("edit-field-assessment-collection-und-0-field-grade-assessment-name-und-0-value--4")).sendKeys("aman");
        // Enter Points
        driver.findElement(By.id("edit-field-assessment-collection-und-0-field-grade-assessment-points-und-0-value--4")).clear();
        driver.findElement(By.id("edit-field-assessment-collection-und-0-field-grade-assessment-points-und-0-value--4")).sendKeys("8");
        // Enter Name
        driver.findElement(By.id("edit-field-assessment-collection-und-1-field-grade-assessment-name-und-0-value")).clear();
        driver.findElement(By.id("edit-field-assessment-collection-und-1-field-grade-assessment-name-und-0-value")).sendKeys("goel");
        // Enter Points
        driver.findElement(By.id("edit-field-assessment-collection-und-1-field-grade-assessment-points-und-0-value")).clear();
        driver.findElement(By.id("edit-field-assessment-collection-und-1-field-grade-assessment-points-und-0-value")).sendKeys("4");
        // Save the activity form
        driver.findElement(By.xpath("//div[@id='edit-actions']/input")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("//div[@id='edit-actions']/input")));
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

// UWrite code for submit button.