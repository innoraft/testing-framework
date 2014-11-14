package TestCOT.StudentRole.CollegeApp;

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

public class CreateEssay {
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
    public void testCreateEssay() throws Exception {
        driver.get(baseUrl + "/college-search");
        driver.findElement(By.linkText("Essays")).click();
        driver.findElement(By.linkText("Essays")).click();
        driver.findElement(By.linkText("Create your first essay")).click();
        new Select(driver.findElement(By.id("edit-field-essay-type-und"))).selectByVisibleText("Scholarship");
        driver.findElement(By.id("edit-field-essay-university-und-0-value")).clear();
        driver.findElement(By.id("edit-field-essay-university-und-0-value")).sendKeys("mnit");
        driver.findElement(By.id("edit-body-und-0-value")).clear();
        driver.findElement(By.id("edit-body-und-0-value")).sendKeys("good university");
        driver.findElement(By.linkText("+")).click();
        driver.findElement(By.cssSelector("html.CSS1Compat")).click();
        driver.findElement(By.id("edit-save-temp")).click();
        driver.findElement(By.linkText("Essays")).click();
        driver.findElement(By.linkText("Essays")).click();
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

