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

public class CreateGradingStandard {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;
    private String[] Tracking = null;
    private int percentage = 0;
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
    public void testCreateGradingStandard() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/my-assignments");

        // Click Grading Standards
        driver.findElement(By.linkText("GRADING STANDARDS")).click();
        if(isElementPresent(By.linkText("Click Here"))) {
            // Click "Click Here"
            driver.findElement(By.linkText("Click Here")).click();
            // Select Course
            new Select(driver.findElement(By.id("edit-field-gr-std-course-ref-und"))).selectByVisibleText("algebra");
            // Enter Grading Attributes
            driver.findElement(By.xpath("//form[@id='grading-standard-node-form']/div/div[3]/input")).clear();
            Tracking = func.RandomWords(2);
            driver.findElement(By.xpath("//form[@id='grading-standard-node-form']/div/div[3]/input")).sendKeys(Tracking[0] + " " + Tracking[1]);
            // Enter Weight
            driver.findElement(By.id("edit-field-gr-std-weight-und-0-value")).clear();
            driver.findElement(By.id("edit-field-gr-std-weight-und-0-value")).sendKeys(String.valueOf(1));
            // Click Save Button
            driver.findElement(By.xpath("//div[6]/input")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[6]/input")));
        } else if (isElementPresent(By.linkText("+"))) {
            // Click "+" Symbol
            driver.findElement(By.linkText("+")).click();
            // Select Course
            new Select(driver.findElement(By.id("edit-field-gr-std-course-ref-und"))).selectByVisibleText("algebra");
            // Enter Grading Attributes
            driver.findElement(By.xpath("//form[@id='grading-standard-node-form']/div/div[3]/input")).clear();
            Tracking = func.RandomWords(2);
            driver.findElement(By.xpath("//form[@id='grading-standard-node-form']/div/div[3]/input")).sendKeys(Tracking[0] + " " + Tracking[1]);
            // Enter Weight
            driver.findElement(By.id("edit-field-gr-std-weight-und-0-value")).clear();
            driver.findElement(By.id("edit-field-gr-std-weight-und-0-value")).sendKeys(String.valueOf(1));
            // Click Save Button
            driver.findElement(By.xpath("//div[6]/input")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[6]/input")));
        }

        // Click Edit
        driver.findElement(By.xpath("//td[3]/a")).click();
        // Enter Grading Attributes
        driver.findElement(By.xpath("//form[@id='grading-standard-node-form']/div/div[2]/input")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.xpath("//form[@id='grading-standard-node-form']/div/div[2]/input")).sendKeys(Tracking[0] + " " + Tracking[1]);
        // Click Save
        driver.findElement(By.xpath("//div[@id='edit-actions']/input")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='edit-actions']/input")));
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
