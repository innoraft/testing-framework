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
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SaveStudentLogSetup {
    private WebDriver driver;
    private String baseUrl;
    private int Max = 50;
    private int IntegerValue = 0;
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
    public void testSaveStudentLogSetup() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("SchoolAdmin");
        driver.get(baseUrl + "/graduation_requirement_tracking");

        driver.findElement(By.linkText("Student Log Setup")).click();
        if(isElementPresent(By.linkText("Click here to add a Message type entry"))) {
            driver.findElement(By.linkText("Click here to add a Message type entry")).click();
            driver.findElement(By.id("edit-incidents-type")).clear();
            Tracking = func.RandomWords(1);
            driver.findElement(By.id("edit-incidents-type")).sendKeys(Tracking[0]);
            driver.findElement(By.id("edit-incident-points")).clear();
            IntegerValue = func.RandomIntegerNumber(Max);
            driver.findElement(By.id("edit-incident-points")).sendKeys(String.valueOf(IntegerValue));
            driver.findElement(By.id("edit-attendance-submit")).click();
        } else if (isElementPresent(By.cssSelector("div.plus-symbol"))) {
            driver.findElement(By.cssSelector("div.plus-symbol")).click();
            driver.findElement(By.id("edit-incidents-type")).clear();
            Tracking = func.RandomWords(1);
            driver.findElement(By.id("edit-incidents-type")).sendKeys(Tracking[0]);
            driver.findElement(By.id("edit-incident-points")).clear();
            IntegerValue = func.RandomIntegerNumber(Max);
            driver.findElement(By.id("edit-incident-points")).sendKeys(String.valueOf(IntegerValue));
            driver.findElement(By.id("edit-attendance-submit")).click();
        }
        driver.findElement(By.id("edit-parents-email-1")).click();
        driver.findElement(By.id("edit-parent-submit")).click();
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

