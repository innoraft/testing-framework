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

public class CreateResume {
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
    public void testCreateResume() throws Exception {
        driver.get(baseUrl + "/journals");
        driver.findElement(By.linkText("Resume")).click();
        driver.findElement(By.linkText("Resume")).click();
        driver.findElement(By.linkText("Add Resume")).click();
        driver.findElement(By.id("edit-field-resume-contact-info-und-0-value")).clear();
        driver.findElement(By.id("edit-field-resume-contact-info-und-0-value")).sendKeys("2-333 jaipur road near ajmeri tower jaipur");
        driver.findElement(By.id("edit-field-essay-objective-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-objective-und-0-value")).sendKeys("Get first position in 10th class");
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-school-college-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-school-college-und-0-value")).sendKeys("simpkins school");
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-location-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-location-und-0-value")).sendKeys("Jaipur");
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-year-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-year-und-0-value")).sendKeys("June 2014 - April 2015");
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-year-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-year-und-0-value")).sendKeys("June 2014 - April 201");
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-year-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-year-und-0-value")).sendKeys("June 2014 - April 2015");
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-brief-info-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-education-und-0-field-education-brief-info-und-0-value")).sendKeys("hellooo...");
        driver.findElement(By.id("edit-field-essay-award-honors-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-award-honors-und-0-value")).sendKeys("chess state campai");
        driver.findElement(By.id("gbqfq")).clear();
        driver.findElement(By.id("gbqfq")).sendKeys("champion select");
        driver.findElement(By.id("edit-field-essay-award-honors-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-award-honors-und-0-value")).sendKeys("chess state champion");
        driver.findElement(By.id("edit-field-essay-extracurricular-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-extracurricular-und-0-value")).sendKeys("pravah");
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-organisation-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-organisation-und-0-value")).sendKeys("innoraft");
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-location-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-location-und-0-value")).sendKeys("kolkata");
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-year-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-work-und-0-field-work-year-und-0-value")).sendKeys("June 2013 - April 2014");
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

