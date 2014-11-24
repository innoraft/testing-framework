package TestCOT.TeacherRole.Dashboard.Reports;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeeGradeAndTestScore {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 7);
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testSeeGradeTestScore() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/teacher-reports");

        // Click Grades & Test Score
        driver.findElement(By.linkText("Grades & Test Score")).click();
        // Select Class of
        driver.findElement(By.className("chzn-single")).click();
        driver.findElement(By.xpath("//*[@id=\"selWUI_chzn_o_1\"]")).click();
        // Enter Name
        driver.findElement(By.cssSelector("input.form-text")).clear();
        driver.findElement(By.cssSelector("input.form-text")).sendKeys("basant");
        // Click Search
        driver.findElement(By.cssSelector("input[name=\"op\"]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ajax-progress-throbber")));

        // Enter Name
        driver.findElement(By.cssSelector("input.form-text")).clear();
        driver.findElement(By.cssSelector("input.form-text")).sendKeys("pa");
        // Click Search
        driver.findElement(By.cssSelector("input[name=\"op\"]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ajax-progress-throbber")));
        Thread.sleep(200);
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

// Select item from single chosen select list.