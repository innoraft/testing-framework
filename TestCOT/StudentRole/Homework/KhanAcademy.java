package TestCOT.StudentRole.Homework;

import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KhanAcademy {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        baseUrl = "http://satishtest.devcloud.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testKhanAcademy() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/assigned-lesson");

        // Click Khan Academy
        driver.findElement(By.linkText("KHAN ACADEMY")).click();

        // Click Science
        driver.findElement(By.id("science")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ajax-waiting")));
        // Click Organic Chemistry
        driver.findElement(By.id("organic-chemistry")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ajax-waiting")));
        // Click Organic Structures
        driver.findElement(By.id("organic-structures")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ajax-waiting")));

        // Click Video
        driver.findElement(By.cssSelector("#IOD5Wb-FKyw > td.ka-video > div.ka-play")).click();
        // Close Video
        driver.findElement(By.cssSelector("a.close-button > img")).click();
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
