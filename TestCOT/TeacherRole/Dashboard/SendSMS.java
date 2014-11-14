package TestCOT.TeacherRole.Dashboard;

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

public class SendSMS {
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
    public void testSendSms() throws Exception {
        driver.get(baseUrl + "/students-dashboard/75486");
        driver.findElement(By.linkText("SMS")).click();
        driver.findElement(By.xpath("//div[@id='edit-recipient-type']/div[2]/label")).click();
        driver.findElement(By.id("edit-recipient-type-1")).click();
        driver.findElement(By.id("teacher-dashboard-message-form")).click();
        driver.findElement(By.id("edit-recipient-type-0")).click();
        driver.findElement(By.cssSelector("label.option")).click();
        driver.findElement(By.id("edit-body")).click();
        driver.findElement(By.id("edit-body")).clear();
        driver.findElement(By.id("edit-body")).sendKeys("hello this is a dummy message from collegeontrack.com");
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.id("edit-recipient-type-1")).click();
        driver.findElement(By.id("edit-body")).click();
        driver.findElement(By.id("edit-body")).clear();
        driver.findElement(By.id("edit-body")).sendKeys("hello sir, this is a dummy message content from collegeontrack");
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

