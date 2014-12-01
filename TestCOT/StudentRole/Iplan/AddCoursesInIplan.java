package TestCOT.StudentRole.Iplan;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCoursesInIplan {
    Functions func;
    private WebDriver driver;
    private WebDriverWait wait;
    private int Max = 10;
    private int IntegerValue = 0;
    private String[] Tracking = null;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        func = new Functions(driver);
        wait = new WebDriverWait(driver, func.timeoutOfOneElement);
        driver.manage().timeouts().implicitlyWait(func.timeoutOFAllElement, TimeUnit.SECONDS);

        driver.get(func.baseUrl + "/");
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(func.baseUrl + "/student-planner");
    }

    @Test
    public void testAddCoursesInIplan() throws Exception {
        // Click Add To Planner
        driver.findElement(By.linkText("Add to Planner")).click();

        // Add Course To Planner
        // Click Grade
        driver.findElement(By.id("grade-11")).click();
        // Click Duration
        driver.findElement(By.xpath("(//input[@name='semester'])[2]")).click();
        // Click Save
        driver.findElement(By.xpath("//div[@id='edit-actions']/input")).click();

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

        // External Courses
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
        driver.findElement(By.xpath("//div[2]/div/form/div/input[3]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[2]/div/form/div/input[3]")));

        // Click PDF Link
        driver.findElement(By.cssSelector("a.print-pdf.print")).click();
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

