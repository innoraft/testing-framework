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

public class SearchSomeCollegeWithFilter {
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
    public void testSearchSomeCollegeWithFilter() throws Exception {
        driver.get(baseUrl + "/college-search");
        driver.findElement(By.linkText("Search")).click();
        driver.findElement(By.linkText("Search")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to Wish List')])[3]")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Fact Sheet')])[3]")).click();
        driver.findElement(By.cssSelector("strong")).click();
        driver.findElement(By.id("edit-public-private-public")).click();
        driver.findElement(By.cssSelector("label.option")).click();
        new Select(driver.findElement(By.id("edit-religious-affiliation"))).selectByVisibleText("Adventist");
        driver.findElement(By.id("edit-type-of-school-apply-filter")).click();
        driver.findElement(By.cssSelector("strong")).click();
        driver.findElement(By.id("edit-public-private-private")).click();
        new Select(driver.findElement(By.id("edit-religious-affiliation"))).selectByVisibleText("Presbyterian");
        driver.findElement(By.id("edit-type-of-school-apply-filter")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to Wish List')])[3]")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Fact Sheet')])[3]")).click();
        driver.findElement(By.linkText("Clear All Selections")).click();
        driver.findElement(By.linkText("Area of Study")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("population_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        driver.findElement(By.id("tuition_range_jq_slider_value")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=edit-area-of-study--4 | label=Algebra and Number Theory]]
        driver.findElement(By.id("edit-area-of-study-apply-filter")).click();
        driver.findElement(By.linkText("Clear All Selections")).click();
        driver.findElement(By.xpath("//div[@id='advanced-search-toggle-display']/div/ul/li[3]/a/strong")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=edit-special-needs | label=Diagnostic testing service]]
        driver.findElement(By.id("edit-special-needs-apply-filter")).click();
        driver.findElement(By.xpath("//div[@id='advanced-search-toggle-display']/div/ul/li[4]/a/strong")).click();
        driver.findElement(By.id("edit-activities-interests-13312")).click();
        driver.findElement(By.xpath("//div[@id='edit-activities-interests']/div/label")).click();
        driver.findElement(By.id("edit-activities-interests-apply-filter")).click();
        driver.findElement(By.linkText("Clear All Selections")).click();
        driver.findElement(By.xpath("//div[@id='advanced-search-toggle-display']/div/ul/li[4]/a/strong")).click();
        driver.findElement(By.id("edit-activities-interests-13312")).click();
        driver.findElement(By.xpath("//div[@id='edit-activities-interests']/div/label")).click();
        driver.findElement(By.id("edit-activities-interests-apply-filter")).click();
        driver.findElement(By.linkText("Clear All Selections")).click();
        driver.findElement(By.xpath("//div[@id='advanced-search-toggle-display']/div/ul/li[5]/a/strong")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=edit-varsity-sports | label=badminton]]
        driver.findElement(By.id("edit-varsity-sports-apply-filter")).click();
        driver.findElement(By.linkText("Clear All Selections")).click();
        driver.findElement(By.xpath("//div[@id='advanced-search-toggle-display']/div/ul/li[6]/a/strong")).click();
        driver.findElement(By.id("edit-geographic-region-29")).click();
        driver.findElement(By.xpath("//div[@id='edit-geographic-region']/div[3]/label")).click();
        driver.findElement(By.id("edit-location-apply-filter")).click();
        driver.findElement(By.linkText("Clear All Selections")).click();
        driver.findElement(By.id("edit-keys")).clear();
        driver.findElement(By.id("edit-keys")).sendKeys("austin");
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

