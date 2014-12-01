package TestCOT.StudentRole;

import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EditUserProfilePage {
    Functions func;
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        func = new Functions(driver);
        driver.manage().timeouts().implicitlyWait(func.timeoutOFAllElement, TimeUnit.SECONDS);

        driver.get(func.baseUrl + "/");
        func.CheckLogin();
        func.LoginRole("Student");
    }

    @Test
    public void testEditUserProfilePage() throws Exception {
        // Click Account Holder Name
        driver.findElement(By.cssSelector("img[alt=\"my image\"]")).click();
        // Click My Account
        driver.findElement(By.linkText("My Account")).click();

        // Click Edit Link
        driver.findElement(By.linkText("Edit")).click();
        // Enter Address Line 2
        driver.findElement(By.id("edit-field-user-address2-und-0-value")).clear();
        driver.findElement(By.id("edit-field-user-address2-und-0-value")).sendKeys("3/228 jaipur road");
        // Click Save
        driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
        // Click Edit link
        driver.findElement(By.linkText("Edit")).click();
        // Click Disabled
        driver.findElement(By.id("edit-field-user-my-digital-presence-und-1")).click();
        // Click Enabled
        driver.findElement(By.id("edit-field-user-my-digital-presence-und-0")).click();
        // Click Save
        driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
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
