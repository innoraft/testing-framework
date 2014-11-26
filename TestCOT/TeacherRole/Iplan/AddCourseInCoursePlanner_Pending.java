package TestCOT.TeacherRole.Iplan;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddCourseInCoursePlanner_Pending {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testAddCourseInCoursePlanner() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/student-planner");

        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single > span")).click();
        driver.findElement(By.linkText("Add to Planner")).click();
        driver.findElement(By.id("subject-mathematics")).click();
        driver.findElement(By.id("grade-9")).click();
        driver.findElement(By.id("node-891271")).click();
        driver.findElement(By.id("grade-9")).click();
        driver.findElement(By.id("grade-11")).click();
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.id("subject-mathematics")).click();
        driver.findElement(By.id("grade-9")).click();
        driver.findElement(By.id("node-891271")).click();
        driver.findElement(By.id("grade-9")).click();
        driver.findElement(By.id("grade-10")).click();
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.linkText("Course Planner")).click();
        driver.findElement(By.linkText("Course Planner")).click();
        driver.findElement(By.linkText("A-G tracking")).click();
        driver.findElement(By.linkText("Accept")).click();
        driver.findElement(By.cssSelector("span.course-acceptance-link")).click();
        driver.findElement(By.cssSelector("div.close-button > img")).click();
        driver.findElement(By.cssSelector("span.course-requirements-overlay-link")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.linkText("Add to Planner")).click();
        driver.findElement(By.id("subject-mathematics")).click();
        driver.findElement(By.id("grade-9")).click();
        driver.findElement(By.id("node-891271")).click();
        driver.findElement(By.id("grade-9")).click();
        driver.findElement(By.id("grade-11")).click();
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

// Write code for single chosen select list.