package TestCOT.StudentRole.CollegeApp;

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

public class CreateEssay {
    private WebDriver driver;
    private String baseUrl;
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
    public void testCreateEssay() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/college-search");

        driver.findElement(By.linkText("ESSAYS")).click();
        driver.findElement(By.linkText("ESSAYS")).click();

        if(isElementPresent(By.linkText("Create Your First Essay"))) {
            driver.findElement(By.linkText("Create Your First Essay")).click();
        } else if (isElementPresent(By.linkText("Add Essay Topic"))) {
            driver.findElement(By.linkText("Add Essay Topic")).click();
        }

        new Select(driver.findElement(By.id("edit-field-essay-type-und"))).selectByVisibleText("Scholarship");
        driver.findElement(By.id("edit-field-essay-university-und-0-value")).clear();
        Tracking = func.RandomWords(1);
        driver.findElement(By.id("edit-field-essay-university-und-0-value")).sendKeys(Tracking[0]);
        driver.findElement(By.id("edit-body-und-0-value")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-body-und-0-value")).sendKeys(Tracking[0] + " " + Tracking[1]);
        driver.findElement(By.linkText("+")).click();
        driver.findElement(By.id("cke_8_label")).click();
        driver.findElement(By.cssSelector("textarea.cke_source.cke_enable_context_menu")).clear();
        Tracking = func.RandomWords(8);
        for(int i= 0 ; i < Tracking.length ; i++) {
            TrackingValues = TrackingValues + " " + Tracking[i];
        }
        driver.findElement(By.cssSelector("textarea.cke_source.cke_enable_context_menu")).sendKeys("<p>" + TrackingValues + " </p>");
        driver.findElement(By.id("edit-save-temp")).click();
        driver.findElement(By.linkText("ESSAYS")).click();
        driver.findElement(By.linkText("ESSAYS")).click();
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

