package TestCOT.StudentRole.Dashboard;

/**
 * Created by om on 11/12/2014.
 */
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import TestCOT.Common.Functions;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateEnrolledClasses_Pending {
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
    public void testCreeateEnrolledClasses() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/students-dashboard");

        driver.findElement(By.linkText("DASHBOARD")).click();
        driver.findElement(By.linkText("Current Enrolled Classes")).click();
        driver.findElement(By.cssSelector("div.plus-symbol")).click();
        driver.findElement(By.cssSelector("b")).click();
//        List<WebElement> options = driver.findElements(By.cssSelector("b"));
//        for (WebElement option : options) {
//            if(option.getText() == "Mathematics") {
//                option.click();
//                break;
//            }
//        }
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.id("edit-teacher-assignment-891301")).click();
        driver.findElement(By.id("edit-submit-teacher-assignment--3")).click();
        driver.findElement(By.linkText("Sumeet Pareek")).click();
        driver.findElement(By.cssSelector("div.cot-overlay.75516-891276 > div.cot-overlay-content > div.close-button-wrapper > span.confirm-button")).click();
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

// How to select item from span type drop down list(Use xpath to reach at drop down list item).