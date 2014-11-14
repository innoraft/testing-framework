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

public class StudentLog {
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
    public void testStudentLog() throws Exception {
        driver.get(baseUrl + "/students-dashboard/75486");
        driver.findElement(By.linkText("Student Log")).click();
        driver.findElement(By.linkText("Click here to create a log entry")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("#edit_field_stu_log_message_type_und_chzn > a.chzn-single > span")).click();
        driver.findElement(By.id("edit-title")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("imcomlete homework");
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("imcomplete homework");
        driver.findElement(By.cssSelector("input.default")).click();
        driver.findElement(By.cssSelector("#student-log-entry-node-form > div")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("incomplete homework");
        driver.findElement(By.id("edit-field-log-entry-description-und-0-value")).clear();
        driver.findElement(By.id("edit-field-log-entry-description-und-0-value")).sendKeys("incomplete homework");
        driver.findElement(By.linkText("+")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.id("edit-title")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("Not a proper way to do homework");
        driver.findElement(By.id("edit-field-log-entry-description-und-0-value")).clear();
        driver.findElement(By.id("edit-field-log-entry-description-und-0-value")).sendKeys("Not a proper way to do homework");
        driver.findElement(By.linkText("Not a proper way to do homework...(Mukesh Agrarwal)")).click();
        driver.findElement(By.cssSelector("span.close-button > img")).click();
        driver.findElement(By.linkText("incomplete homework...(Mukesh Agrarwal)")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[2]/div/div/div/span/img")).click();
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

