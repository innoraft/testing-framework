package TestCOT.TeacherRole.Dashboard.Reports;

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

public class SeeGradeAndTestScore_Pending {
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
    public void testSeeGradeTestScore() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/teacher-reports");

        driver.findElement(By.linkText("Grades & Test Score")).click();
        driver.findElement(By.cssSelector("b")).click();
        driver.findElement(By.name("op")).click();
//        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
//        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[3]/div/div/div/div[2]")).click();
//        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("input.form-text")).clear();
        driver.findElement(By.cssSelector("input.form-text")).sendKeys("basant");
        driver.findElement(By.name("op")).click();
        driver.findElement(By.cssSelector("input.form-text")).clear();
        driver.findElement(By.cssSelector("input.form-text")).sendKeys("basant pa");
        driver.findElement(By.name("op")).click();
        driver.findElement(By.cssSelector("input.form-text")).clear();
        driver.findElement(By.cssSelector("input.form-text")).sendKeys("pa");
        driver.findElement(By.name("op")).click();
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

// Select item from single chosen select list.