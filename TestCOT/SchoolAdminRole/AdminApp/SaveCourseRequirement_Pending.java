package TestCOT.SchoolAdminRole.AdminApp;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import TestCOT.CommonFunctions.*;

public class SaveCourseRequirement_Pending {
    private WebDriver driver;
    private String baseUrl;
    private int Max = 50;
    private int IntegerValue = 0;
    private String[] Tracking = null;
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
    public void testSaveCourseRequirement() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("SchoolAdmin");
        driver.get(baseUrl + "/long-term-planner-config");

        driver.findElement(By.linkText("Course Requirements")).click();
        if(isElementPresent(By.linkText("Graduation Requirement Tracking"))) {
            driver.findElement(By.linkText("Graduation Requirement Tracking")).click();
            driver.findElement(By.id("edit-traking-name")).clear();
            Tracking = func.RandomWords(1);
            driver.findElement(By.id("edit-traking-name")).sendKeys(Tracking[0]);
            driver.findElement(By.id("edit-foreign-languages")).clear();
            IntegerValue = func.RandomIntegerNumber(Max);
            driver.findElement(By.id("edit-foreign-languages")).sendKeys(String.valueOf(IntegerValue));
            driver.findElement(By.id("edit-mathematics")).clear();
            IntegerValue = func.RandomIntegerNumber(Max);
            driver.findElement(By.id("edit-mathematics")).sendKeys(String.valueOf(IntegerValue));
            driver.findElement(By.id("edit-social-science")).clear();
            IntegerValue = func.RandomIntegerNumber(Max);
            driver.findElement(By.id("edit-social-science")).sendKeys(String.valueOf(IntegerValue));
            driver.findElement(By.id("edit-others")).clear();
            IntegerValue = func.RandomIntegerNumber(Max);
            driver.findElement(By.id("edit-others")).sendKeys(String.valueOf(IntegerValue));
            driver.findElement(By.id("edit-submit")).click();
        } else if (isElementPresent(By.linkText("+"))) {
            driver.findElement(By.linkText("+")).click();
            driver.findElement(By.id("edit-traking-name")).clear();
            Tracking = func.RandomWords(1);
            driver.findElement(By.id("edit-traking-name")).sendKeys(Tracking[0]);
            driver.findElement(By.id("edit-foreign-languages")).clear();
            IntegerValue = func.RandomIntegerNumber(Max);
            driver.findElement(By.id("edit-foreign-languages")).sendKeys(String.valueOf(IntegerValue));
            driver.findElement(By.id("edit-mathematics")).clear();
            IntegerValue = func.RandomIntegerNumber(Max);
            driver.findElement(By.id("edit-mathematics")).sendKeys(String.valueOf(IntegerValue));
            driver.findElement(By.id("edit-social-science")).clear();
            IntegerValue = func.RandomIntegerNumber(Max);
            driver.findElement(By.id("edit-social-science")).sendKeys(String.valueOf(IntegerValue));
            driver.findElement(By.id("edit-others")).clear();
            IntegerValue = func.RandomIntegerNumber(Max);
            driver.findElement(By.id("edit-others")).sendKeys(String.valueOf(IntegerValue));
            driver.findElement(By.id("edit-submit")).click();
        }
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

