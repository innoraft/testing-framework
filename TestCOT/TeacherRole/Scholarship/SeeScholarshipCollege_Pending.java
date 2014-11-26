package TestCOT.TeacherRole.Scholarship;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeeScholarshipCollege_Pending {
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
    public void testSeeScholarshipCollege() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/scholarship-search/75501");

        driver.findElement(By.xpath("//div[@id='nav-group-home']")).click();
        driver.findElement(By.linkText("Scholarships")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.id("edit-citizen-2")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.id("edit-act")).clear();
        driver.findElement(By.id("edit-act")).sendKeys("29");
        driver.findElement(By.cssSelector("#edit_race_chzn > ul.chzn-choices > li.search-field > input.default")).click();
        driver.findElement(By.cssSelector("#edit_religion_chzn > ul.chzn-choices > li.search-field > input.default")).click();
        driver.findElement(By.id("page-wrapper")).click();
        driver.findElement(By.id("edit-search-button")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to Wish List')])[2]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to Wish List')])[6]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to Wish List')])[10]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to Wish List')])[3]")).click();
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