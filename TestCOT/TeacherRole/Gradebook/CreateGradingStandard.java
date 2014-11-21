package TestCOT.TeacherRole.Gradebook;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import TestCOT.Common.Functions;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateGradingStandard {
    private WebDriver driver;
    private String baseUrl;
    private String[] Tracking = null;
    private int percentage = 0;
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
    public void testCreateGradingStandard() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/my-assignments");

        driver.findElement(By.linkText("GRADING STANDARDS")).click();
        if(isElementPresent(By.linkText("Click Here"))) {
            driver.findElement(By.linkText("Click Here")).click();
            new Select(driver.findElement(By.id("edit-field-gr-std-course-ref-und"))).selectByVisibleText("algebra");
            driver.findElement(By.id("edit-title")).clear();
            Tracking = func.RandomWords(2);
            driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + " " + Tracking[1]);
            driver.findElement(By.id("edit-field-gr-std-weight-und-0-value")).clear();
            percentage = func.RandomPercentage();
            driver.findElement(By.id("edit-field-gr-std-weight-und-0-value")).sendKeys(String.valueOf(percentage));
            driver.findElement(By.cssSelector("css=#edit-actions > #edit-submit")).click();
        } else if (isElementPresent(By.linkText("+"))) {
            driver.findElement(By.linkText("+")).click();
            new Select(driver.findElement(By.id("edit-field-gr-std-course-ref-und"))).selectByVisibleText("algebra");
            driver.findElement(By.id("edit-title")).clear();
            Tracking = func.RandomWords(2);
            driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + " " + Tracking[1]);
            driver.findElement(By.id("edit-field-gr-std-weight-und-0-value")).clear();
            percentage = func.RandomPercentage();
            driver.findElement(By.id("edit-field-gr-std-weight-und-0-value")).sendKeys(String.valueOf(percentage));
            driver.findElement(By.cssSelector("css=#edit-actions > #edit-submit")).click();
        }

        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.xpath("(//input[@id='edit-title'])[2]")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.xpath("(//input[@id='edit-title'])[2]")).sendKeys(Tracking[0] + " " + Tracking[1]);
        driver.findElement(By.cssSelector("#edit-actions > #edit-submit")).click();
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
