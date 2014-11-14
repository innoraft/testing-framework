package TestCOT.SchoolAdminRole.College;

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

public class SearchCollege {
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
    public void testSearchCollege() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("SchoolAdmin");
        driver.get(baseUrl + "/college-search");

        driver.findElement(By.id("edit-keys")).clear();
        driver.findElement(By.id("edit-keys")).sendKeys("academy");
        driver.findElement(By.id("edit-submit")).click();
        Boolean Search = driver.findElement(By.cssSelector("div.search-total-results")).getText().contains("results retrieved");
        assertTrue(Search);
        driver.findElement(By.linkText("Clear All Selections")).click();
    }

    @Test
    public void testTypeOfSchool() throws Exception {
        driver.findElement(By.cssSelector("strong")).click();
        driver.findElement(By.id("edit-public-private-private")).click();
        new Select(driver.findElement(By.id("edit-religious-affiliation"))).selectByVisibleText("Baptist");
        driver.findElement(By.id("edit-type-of-school-apply-filter")).click();
        Boolean Search = driver.findElement(By.cssSelector("div.search-total-results")).getText().contains("results retrieved");
        assertTrue(Search);
        driver.findElement(By.linkText("Clear All Selections")).click();
    }

    @Test
    public void testUntitled4() throws Exception {
        driver.get(baseUrl + "/college-search");
        driver.findElement(By.xpath("//div[@id='advanced-search-toggle-display']/div/ul/li[3]/a/strong")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=edit-special-needs | label=Exam on tape or computer]]
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=edit-special-needs | label=Extended time for tests]]
        driver.findElement(By.id("edit-special-needs-apply-filter")).click();
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

