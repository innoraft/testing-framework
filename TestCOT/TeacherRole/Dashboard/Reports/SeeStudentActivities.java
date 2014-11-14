package TestCOT.TeacherRole.Dashboard.Reports;

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

public class SeeStudentActivities {
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
    public void testSeeStudentActivities() throws Exception {
        driver.get(baseUrl + "/teacher-reports");
        driver.findElement(By.linkText("Student Activities")).click();
        driver.findElement(By.id("edit-combine-1")).clear();
        driver.findElement(By.id("edit-combine-1")).sendKeys("paul");
        driver.findElement(By.id("edit-submit-administration-students")).click();
        driver.findElement(By.id("edit-combine-1")).clear();
        driver.findElement(By.id("edit-combine-1")).sendKeys("shar");
        driver.findElement(By.id("edit-submit-administration-students")).click();
        driver.findElement(By.id("edit-combine-1")).clear();
        driver.findElement(By.id("edit-combine-1")).sendKeys("shar pau");
        driver.findElement(By.id("edit-submit-administration-students")).click();
        driver.findElement(By.id("edit-combine-1")).clear();
        driver.findElement(By.id("edit-combine-1")).sendKeys("shar pal");
        driver.findElement(By.id("edit-submit-administration-students")).click();
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

