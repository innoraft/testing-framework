package TestCOT.StudentRole.DigitalPortfolio;

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

public class AddJournalAndComment {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;
    private String[] Tracking = null;
    private String TrackingValues = "";
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 100);
        baseUrl = "http://satishtest.devcloud.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testAddJournalAndComment() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/journals");

        // Click Journal
        driver.findElement(By.linkText("JOURNAL")).click();
        // Click New Journal Entry
        driver.findElement(By.linkText("New Journal Entry")).click();

        // Add Journal Entry
        // Enter Title
        driver.findElement(By.id("edit-title")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + " " + Tracking[1]);
        // Click Source
        driver.findElement(By.id("cke_83_label")).click();
        // Enter Description
        driver.findElement(By.cssSelector("textarea.cke_source.cke_enable_context_menu")).clear();
        Tracking = func.RandomWords(8);
        for(int i= 0 ; i < Tracking.length ; i++) {
            TrackingValues = TrackingValues + " " + Tracking[i];
        }
        driver.findElement(By.cssSelector("textarea.cke_source.cke_enable_context_menu")).sendKeys("<p>" + TrackingValues + " </p>");
        // Click Upload Video
        driver.findElement(By.id("botr-upload-button")).click();
        driver.findElement(By.className("botr-upload-file")).sendKeys("C:\\Users\\om\\Downloads\\Andaman & Nicobar Islands(2 sec video)-BzosVry7nc4.mp4");
        // Click Upload
        driver.findElement(By.xpath("//input[@value='Upload']")).click();
        // Wait for upload
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.botr-close > img")));
        // Save journal entry
        driver.findElement(By.xpath("//div[2]/input")).click();

        // Click Add New Comment
        driver.findElement(By.id("comment-add")).click();
        // Enter Comment
        driver.findElement(By.id("edit-comment-body-und-0-value")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-comment-body-und-0-value")).sendKeys(Tracking[0] + " " + Tracking[1]);
        // Click Save
        driver.findElement(By.xpath("//form/div/div[2]/input")).click();

        // Click Comment
        driver.findElement(By.xpath("//div[5]/a")).click();
        Thread.sleep(300);
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