/**
 * Student can update how much scholarship he got, in front of respective scholarship through click applied checkbox.
 * Student can also remove scholarship from wishList.
 */

package TestCOT.StudentRole.Scholarship;

/**
 * Created by om on 11/12/2014.
 */
import java.util.List;
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateScholarshipFeeAndRemoveCollegeFromWishlist {
    Functions func;
    private WebDriver driver;
    private WebDriverWait wait;
    private int RandomRow = 0;
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
        driver.get(func.baseUrl + "/scholarship-search");
    }

    @Test
    public void testUpdateSchoarshipFeeAndRemoveCollegeFromWishlist() throws Exception {
        // Click Scholarship Wish List
        driver.findElement(By.linkText("SCHOLARSHIP WISH LIST")).click();
        // Check Row Data Exist or Not
        List<WebElement> TableRows = driver.findElements(By.xpath("//table/tbody/tr"));
        int rowNumber = TableRows.size();
        if(rowNumber > 0) {
            // Access Random Row
            RandomRow = func.RandomIntegerNumber(rowNumber);
            // Check Applied Checkbox Clicked or Not
            if (!driver.findElement(By.xpath("//tr[" + RandomRow + "]/td[4]/form/div/div/div/input")).isSelected()) {
                driver.findElement(By.xpath("//tr[" + RandomRow + "]/td[4]/form/div/div/div/input")).click();
                // Wait for checkbox to be UnClicked
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("throbber")));
            }
            // Click Awarded Link
            driver.findElement(By.xpath("//tr[" + RandomRow + "]/td[5]/div/div")).click();
            // Enter Received Amount
            driver.findElement(By.xpath("//form[@id='cot-scholarship-get-amount-received-form--" + RandomRow + "']/div/div/div[2]/input")).clear();
            driver.findElement(By.xpath("//form[@id='cot-scholarship-get-amount-received-form--" + RandomRow + "']/div/div/div[2]/input")).sendKeys(String.valueOf(200));
            // Click Save Button
            driver.findElement(By.xpath("//form[@id='cot-scholarship-get-amount-received-form--" + RandomRow + "']/div/div/input")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("throbber")));
            // Click Remove Link
            driver.findElement(By.xpath("//tr[" + RandomRow + "]/td[6]/a")).click();
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