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

public class AddCoursesInIplan {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/student-planner";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAddCoursesInIplan() throws Exception {
        driver.get(baseUrl + "/student-planner");
        driver.findElement(By.id("nav-group-home")).click();
        driver.findElement(By.linkText("iPlan")).click();
        driver.findElement(By.linkText("iPlan")).click();
        driver.findElement(By.linkText("Add to Planner")).click();
        driver.findElement(By.id("grade-12")).click();
        driver.findElement(By.xpath("(//input[@name='semester'])[2]")).click();
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.id("subject-social_science")).click();
        driver.findElement(By.id("grade-9")).click();
        driver.findElement(By.id("grade-11")).click();
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("iPlan")).click();
        driver.findElement(By.linkText("iPlan")).click();
        driver.findElement(By.cssSelector("span.course-acceptance-link")).click();
        driver.findElement(By.cssSelector("div.close-button > img")).click();
        driver.findElement(By.linkText("Accept")).click();
        driver.findElement(By.cssSelector("span.course-acceptance-link")).click();
        driver.findElement(By.cssSelector("div.close-button > img")).click();
        driver.findElement(By.linkText("Add External Courses")).click();
        new Select(driver.findElement(By.id("edit-subjects-list"))).selectByVisibleText("Mathematics");
        driver.findElement(By.id("edit-course-name")).clear();
        driver.findElement(By.id("edit-course-name")).sendKeys("complex number");
        new Select(driver.findElement(By.id("edit-grade"))).selectByVisibleText("9");
        driver.findElement(By.id("edit-course-credits")).clear();
        driver.findElement(By.id("edit-course-credits")).sendKeys("12");
        new Select(driver.findElement(By.id("edit-duration"))).selectByVisibleText("Second Semester");
        driver.findElement(By.linkText("print")).click();
        driver.findElement(By.cssSelector("b")).click();
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

