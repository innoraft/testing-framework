package TestCOT.StudentRole.Scholarship;

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

public class UpdateScholarshipFeeAndRemoveCollegeFromWishlist {
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
    public void testUpdateSchoarshipFeeAndRemoveCollegeFromWishlist() throws Exception {
        driver.get(baseUrl + "/scholarship-search");
        driver.findElement(By.linkText("Scholarship Search")).click();
        driver.findElement(By.linkText("Scholarship Search")).click();
        driver.findElement(By.linkText("Scholarship Wish List")).click();
        driver.findElement(By.linkText("Scholarship Wish List")).click();
        driver.findElement(By.id("edit-checkbox-applied--2")).click();
        driver.findElement(By.id("891641")).click();
        driver.findElement(By.id("edit-received-amount-891641")).clear();
        driver.findElement(By.id("edit-received-amount-891641")).sendKeys("400");
        driver.findElement(By.id("edit-submit-891641")).click();
        driver.findElement(By.cssSelector("#891641 > div")).click();
        driver.findElement(By.cssSelector("div.student-scholarship-amount-change-form.student-scholarship-received-891641 > div.close-button-wrapper > span.close-button > img")).click();
        driver.findElement(By.cssSelector("a.college-wishlist-flag-link-891601.remove-scholarship-wishlist-link")).click();
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

