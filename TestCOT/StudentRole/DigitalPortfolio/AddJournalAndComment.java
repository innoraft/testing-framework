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

public class AddJournalAndComment {
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
    public void testAddJournalAndComment() throws Exception {
        driver.findElement(By.linkText("Journal")).click();
        driver.findElement(By.linkText("Journal")).click();
        driver.findElement(By.linkText("New Journal Entry")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("visit pune");
        driver.findElement(By.cssSelector("html.CSS1Compat")).click();
        driver.findElement(By.id("botr-upload-button")).click();
        driver.findElement(By.name("file")).clear();
        driver.findElement(By.name("file")).sendKeys("/home/akash/Videos/Andaman & Nicobar Islands(2 sec video)-BzosVry7nc4.mp4");
        driver.findElement(By.cssSelector("p > input[name=\"title\"]")).clear();
        driver.findElement(By.cssSelector("p > input[name=\"title\"]")).sendKeys("pune visit");
        driver.findElement(By.cssSelector("input.botr-upload-submit.form-submit")).click();
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.id("comment-add")).click();
        driver.findElement(By.id("edit-comment-body-und-0-value")).clear();
        driver.findElement(By.id("edit-comment-body-und-0-value")).sendKeys("nice trip ;)");
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.id("comment-count-891401")).click();
        driver.findElement(By.id("comment-add")).click();
        driver.findElement(By.id("edit-comment-body-und-0-value")).clear();
        driver.findElement(By.id("edit-comment-body-und-0-value")).sendKeys("nice...");
        driver.findElement(By.id("edit-submit")).click();
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

