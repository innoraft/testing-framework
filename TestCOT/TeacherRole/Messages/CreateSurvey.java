package TestCOT.TeacherRole.Messages;

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

public class CreateSurvey {
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
    public void testCreateSurvey() throws Exception {
        driver.get(baseUrl + "/messages");
        driver.findElement(By.linkText("Survey")).click();
        driver.findElement(By.linkText("Survey")).click();
        driver.findElement(By.linkText("Create Survey")).click();
        driver.findElement(By.id("edit-survey-title")).clear();
        driver.findElement(By.id("edit-survey-title")).sendKeys("at what time he does his homework");
        driver.findElement(By.id("edit-new")).click();
        driver.findElement(By.linkText("Configure")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("Time");
        driver.findElement(By.xpath("//form[@id='form-builder-field-configure']/div/ul/li[2]")).click();
        driver.findElement(By.xpath("(//input[@value='one'])[4]")).click();
        driver.findElement(By.xpath("(//input[@value='one'])[4]")).clear();
        driver.findElement(By.xpath("(//input[@value='one'])[4]")).sendKeys("5 PM");
        driver.findElement(By.xpath("(//input[@value='two'])[4]")).click();
        driver.findElement(By.xpath("(//input[@value='two'])[4]")).clear();
        driver.findElement(By.xpath("(//input[@value='two'])[4]")).sendKeys("6 PM");
        driver.findElement(By.xpath("(//input[@value='three'])[4]")).clear();
        driver.findElement(By.xpath("(//input[@value='three'])[4]")).sendKeys("7 PM");
        driver.findElement(By.cssSelector("li > span")).click();
        driver.findElement(By.linkText("Close")).click();
        driver.findElement(By.xpath("//div[@id='form-builder']/div[3]/div/span/a[2]")).click();
        driver.findElement(By.xpath("//form[@id='form-builder-field-configure']/div/ul/li[2]/span")).click();
        driver.findElement(By.xpath("(//input[@value='one'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@value='one'])[2]")).sendKeys("2");
        driver.findElement(By.xpath("(//input[@value='one'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@value='one'])[2]")).sendKeys("2 PM");
        driver.findElement(By.xpath("(//input[@value='two'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@value='two'])[2]")).sendKeys("3 PM");
        driver.findElement(By.xpath("(//input[@value='three'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@value='three'])[2]")).sendKeys("4 PM");
        driver.findElement(By.cssSelector("li > span")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("select one time");
        driver.findElement(By.linkText("Save Survey")).click();
        driver.findElement(By.linkText("Assign Survey")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("#edit_group_id_chzn > a.chzn-single > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("#edit_group_id_chzn > a.chzn-single > span")).click();
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
