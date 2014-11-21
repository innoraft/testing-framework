package TestCOT.StudentRole.DigitalPortfolio;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddShowcase {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;
    private String[] Tracking = null;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 100);
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testAddShowcase() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/journals");

        // Click Showcases
        driver.findElement(By.linkText("SHOWCASES")).click();
        // Click New Showcases
        driver.findElement(By.linkText("New Showcase")).click();

        // Fill Showcase Detail
        // Enter Title
        driver.findElement(By.id("edit-title")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + " " + Tracking[1]);

        // Enter Description
        driver.findElement(By.id("edit-field-showcase-description-und-0-value")).clear();
        Tracking = func.RandomWords(4);
        driver.findElement(By.id("edit-field-showcase-description-und-0-value")).sendKeys(Tracking[0] + " " + Tracking[1] + " " + Tracking[2] + " " + Tracking[3]);

        // Click Skills Required
        driver.findElement(By.id("edit-field-showcase-skills-acquired-und-8")).click();
        driver.findElement(By.id("edit-field-showcase-skills-acquired-und-17")).click();
        driver.findElement(By.id("edit-field-showcase-skills-acquired-und-14")).click();
        driver.findElement(By.id("edit-field-showcase-skills-acquired-und-15")).click();

        // Upload Audio/Video
        driver.findElement(By.id("botr-upload-button")).click();
        driver.findElement(By.className("botr-upload-file")).sendKeys("C:\\Users\\om\\Downloads\\Andaman & Nicobar Islands(2 sec video)-BzosVry7nc4.mp4");
        driver.findElement(By.xpath("(//input[@value='Upload'])[3]")).click();
        // Wait for upload
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.botr-close > img")));

        //Upload Image
        driver.findElement(By.id("showcase-upload-img")).click();
        driver.findElement(By.id("edit-field-showcase-images-und-0-upload")).sendKeys("C:\\Users\\om\\Downloads\\Business Process Outsourcing (BPO) Services_Market Segments_Healthcare BPO Services.jpg");
        driver.findElement(By.id("edit-field-showcase-images-und-0-upload-button")).click();
        // Wait for upload
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("edit-field-showcase-images-und-0-upload-button")));

        // Upload document
        driver.findElement(By.id("showcase-upload-doc")).click();
        driver.findElement(By.id("edit-field-showcase-documents-und-0-upload")).sendKeys("C:\\Users\\om\\Downloads\\Integration_with_Other_Tools.pdf");
        driver.findElement(By.id("edit-field-showcase-documents-und-0-upload-button")).click();
        // Wait for upload
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("edit-field-showcase-documents-und-0-upload-button")));
        // Enter Title
        driver.findElement(By.id("edit-field-showcase-documents-und-0-description")).sendKeys("business");

        // Save Showcase Detail
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