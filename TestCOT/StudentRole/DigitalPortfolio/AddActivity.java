package TestCOT.StudentRole.DigitalPortfolio;

/**
 * Created by om on 11/12/2014.
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddActivity {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAddActivity() throws Exception {
        driver.get(baseUrl + "/journals");
        driver.findElement(By.linkText("Activities")).click();
        driver.findElement(By.linkText("Activities")).click();
        driver.findElement(By.linkText("Create Activity")).click();
        driver.findElement(By.id("edit-field-activity-activities-und-0-value")).clear();
        driver.findElement(By.id("edit-field-activity-activities-und-0-value")).sendKeys("pune activity");
        driver.findElement(By.id("edit-field-activity-grade-und-0-value")).clear();
        driver.findElement(By.id("edit-field-activity-grade-und-0-value")).sendKeys("10");
        driver.findElement(By.id("edit-field-activity-hours-p-week-und-0-value")).clear();
        driver.findElement(By.id("edit-field-activity-hours-p-week-und-0-value")).sendKeys("1");
        driver.findElement(By.id("edit-field-activity-positions-und-0-value")).clear();
        driver.findElement(By.id("edit-field-activity-positions-und-0-value")).sendKeys("nothing");
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-citizenship")).click();
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-self-motivation")).click();
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-initiative")).click();
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-leadership")).click();
        driver.findElement(By.id("edit-field-activity-skills-acquired-und-technical-mastery")).click();
        driver.findElement(By.id("edit-field-activity-weeks-p-year-und-0-value")).clear();
        driver.findElement(By.id("edit-field-activity-weeks-p-year-und-0-value")).sendKeys("8");
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
