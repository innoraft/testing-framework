package TestCOT.StudentRole.Scholarship;

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

public class UpdateScholarshipFeeAndRemoveCollegeFromWishlist_Pending {
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
    public void testUpdateSchoarshipFeeAndRemoveCollegeFromWishlist() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/scholarship-search");

        // Click Scholarship Search
        driver.findElement(By.linkText("Scholarship Search")).click();
        driver.findElement(By.linkText("SCHOLARSHIP WISH LIST")).click();
        // Check Checkbox
        driver.findElement(By.id("edit-checkbox-applied")).click();
        // Click $400
        driver.findElement(By.xpath("//td[5]/div/div/div")).click();
        driver.findElement(By.xpath("//div[2]/input")).clear();
        driver.findElement(By.xpath("//div[2]/input")).sendKeys("400");
        driver.findElement(By.name("name=op")).click();
        driver.findElement(By.linkText("link=Remove from Wish List")).click();
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

// Remove college from wish list.