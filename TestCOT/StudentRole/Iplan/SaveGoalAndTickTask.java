package TestCOT.StudentRole.Iplan;

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

public class SaveGoalAndTickTask {
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
    public void testSaveGoalAndTickTask() throws Exception {
        driver.get(baseUrl + "/long-term-planner");
        driver.findElement(By.linkText("iTasks")).click();
        driver.findElement(By.linkText("iTasks")).click();
        driver.findElement(By.cssSelector("div.careers-major-link")).click();
        driver.findElement(By.cssSelector("div.close-button > img")).click();
        driver.findElement(By.cssSelector("div.ltp-milestone-goal-link")).click();
        driver.findElement(By.cssSelector("html.CSS1Compat")).click();
        driver.findElement(By.cssSelector("#cke_31 > span.cke_icon")).click();
        driver.findElement(By.cssSelector("#cke_33 > span.cke_icon")).click();
        driver.findElement(By.cssSelector("#cke_32 > span.cke_icon")).click();
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.cssSelector("div.ltp-milestone-goal-link")).click();
        driver.findElement(By.cssSelector("html.CSS1Compat")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div[4]/div/div/div/div[2]/img")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div[5]/div/div/div/div/ul[2]/li")).click();
        driver.findElement(By.cssSelector("div.title")).click();
        driver.findElement(By.id("edit-task-status-891356-1")).click();
        driver.findElement(By.cssSelector("span.close-button > img")).click();
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

