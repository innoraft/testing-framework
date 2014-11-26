package TestCOT.TeacherRole.Dashboard;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeeCheckListOfColleges_Pending {
    private WebDriver driver;
    private String baseUrl;
    private String SearchValue = null;
    private WebDriverWait wait;
    private String[] Tracking = null;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testSeeChecklistOfColleges() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/students-dashboard/75486");

        // Click Colleges
        driver.findElement(By.xpath("(//a[contains(text(),'Colleges')])[2]")).click();
        // Check Applied
        driver.findElement(By.id("edit-checkbox-applied--2")).click();
        // Click Book Icon
        driver.findElement(By.xpath("//tr[2]/td/div[2]")).click();
        // Click Checklist
        driver.findElement(By.xpath("//div[2]/div[6]/div/div[2]/div")).click();
        // Add Item To Checklist
        // Enter Application Item
        driver.findElement(By.id("edit-title")).clear();
        Tracking = func.RandomWords(1);
        SearchValue = Tracking[0];
        driver.findElement(By.id("edit-title")).sendKeys(Tracking[0]);
        // Click Save Button
        driver.findElement(By.xpath("//div[@id='edit-actions--3']/input")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='edit-actions--3']/input")));
        // Search Application Item
        System.out.println(driver.findElement(By.linkText(SearchValue)).getLocation());
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

// Selenium IDE steps not available at site.