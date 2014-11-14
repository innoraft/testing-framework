package TestCOT.StudentRole.Dashboard;

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

public class AddCollegeStatusInCollegeMenu {
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
    public void testAddCollegeStatusInCollegeMenu() throws Exception {
        driver.get(baseUrl + "/students-dashboard");
        driver.findElement(By.xpath("(//a[contains(text(),'Colleges')])[2]")).click();
        driver.findElement(By.cssSelector("div.10756")).click();
        driver.findElement(By.cssSelector("div.cot-overlay-content > div.10756")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("dummy checklist");
        driver.findElement(By.id("edit-checkbox-applied")).click();
        driver.findElement(By.xpath("//div[@id='edit-select-status']/div")).click();
        driver.findElement(By.id("edit-status-options-5")).click();
        driver.findElement(By.xpath("//div[@id='edit-status-options']/div[5]/label")).click();
        driver.findElement(By.id("edit-checkbox-applied--2")).click();
        driver.findElement(By.xpath("//div[@id='edit-select-status--2']/div")).click();
        driver.findElement(By.id("edit-status-options-4--2")).click();
        driver.findElement(By.xpath("//div[@id='edit-status-options--2']/div[4]/label")).click();
        driver.findElement(By.cssSelector("div.10726")).click();
        driver.findElement(By.id("edit-checkbox-checklist--14")).click();
        driver.findElement(By.id("edit-checkbox-checklist--13")).click();
        driver.findElement(By.id("edit-checkbox-checklist--12")).click();
        driver.findElement(By.id("edit-checkbox-checklist--16")).click();
        driver.findElement(By.id("edit-checkbox-checklist--15")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div[2]/div[2]/div[4]/div/div[2]/div[2]/span/img")).click();
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

