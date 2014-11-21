package TestCOT.StudentRole.Iplan;

/**
 * Created by om on 11/12/2014.
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import TestCOT.Common.Functions;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddCoursesInIplan {
    private WebDriver driver;
    private String baseUrl;
    private int Max = 10;
    private int IntegerValue = 0;
    private String[] Tracking = null;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testAddCoursesInIplan() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/student-planner?track=891361");

        // Click Add To Planner
        // Add Course To Planner
        driver.findElement(By.linkText("Add to Planner")).click();
        // Click Grade
        driver.findElement(By.id("grade-11")).click();
        // Click Duration
        driver.findElement(By.xpath("(//input[@name='semester'])[2]")).click();
        // Click Save
        driver.findElement(By.id("edit-submit")).click();
        // Add Another Course To Planner
        // Click Subject
        driver.findElement(By.id("subject-social_science")).click();
        // Click Grade
        driver.findElement(By.id("grade-10")).click();
        driver.findElement(By.id("grade-12")).click();
        // Click Save
        driver.findElement(By.xpath("//div[@id='edit-actions']/input")).click();

        // Click Home
        driver.findElement(By.xpath("//div[@id='nav-group-home']")).click();
        // Click IPlan
        driver.findElement(By.linkText("iPlan")).click();

        // Click Plan Approvals
        driver.findElement(By.cssSelector("span.course-acceptance-link")).click();
        // Close Plan Approvals
        driver.findElement(By.cssSelector("div.close-button > img")).click();
        // Click Accept
        driver.findElement(By.linkText("ACCEPT")).click();
        // Click Plan Approvals
        driver.findElement(By.cssSelector("span.course-acceptance-link")).click();
        // Close Plan Approvals
        driver.findElement(By.cssSelector("div.close-button > img")).click();

        // Click Add External Courses
        driver.findElement(By.linkText("Add External Courses")).click();
        // Select Subject
        new Select(driver.findElement(By.id("edit-subjects-list"))).selectByVisibleText("Mathematics");
        // Enter Course Name
        driver.findElement(By.id("edit-course-name")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-course-name")).sendKeys(Tracking[0] + " " + Tracking[1]);
        // Select Grade
        new Select(driver.findElement(By.id("edit-grade"))).selectByVisibleText("9");
        // Enter Course Credits
        driver.findElement(By.id("edit-course-credits")).clear();
        IntegerValue = func.RandomIntegerNumber(Max);
        driver.findElement(By.id("edit-course-credits")).sendKeys(String.valueOf(IntegerValue));
        // Select Duration
        new Select(driver.findElement(By.id("edit-duration"))).selectByVisibleText("Second Semester");
        // Click Submit Button
        driver.findElement(By.xpath("//*[@id=\"edit-submit-1416487385\"]")).click();
        // Click PDF Link
        driver.findElement(By.linkText("print")).click();
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

// How to write code for submit button