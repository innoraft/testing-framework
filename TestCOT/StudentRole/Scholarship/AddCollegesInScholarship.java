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

public class AddCollegesInScholarship {
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
    public void testAddCollegesInScholarship() throws Exception {
        driver.get(baseUrl + "/scholarship-search");
        driver.findElement(By.linkText("Scholarship Search")).click();
        driver.findElement(By.linkText("Scholarship Search")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.id("edit-satm")).clear();
        driver.findElement(By.id("edit-satm")).sendKeys("86");
        driver.findElement(By.id("edit-satw")).clear();
        driver.findElement(By.id("edit-satw")).sendKeys("86");
        driver.findElement(By.id("edit-satv")).clear();
        driver.findElement(By.id("edit-satv")).sendKeys("78");
        driver.findElement(By.id("edit-act")).clear();
        driver.findElement(By.id("edit-act")).sendKeys("70");
        driver.findElement(By.cssSelector("#edit_interest_chzn > ul.chzn-choices > li.search-field > input.default")).click();
        driver.findElement(By.cssSelector("#edit_religion_chzn > ul.chzn-choices > li.search-field > input.default")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.id("edit-search-button")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to Wish List')])[11]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to Wish List')])[17]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to Wish List')])[4]")).click();
        driver.findElement(By.cssSelector("div.scholarship-search-button")).click();
        driver.findElement(By.cssSelector("#edit_interest_chzn_c_4 > a.search-choice-close")).click();
        driver.findElement(By.cssSelector("#edit_race_chzn > ul.chzn-choices > li.search-field > input.default")).click();
        driver.findElement(By.cssSelector("#edit_disability_chzn > ul.chzn-choices > li.search-field > input.default")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.id("edit-search-button")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to Wish List')])[13]")).click();
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

