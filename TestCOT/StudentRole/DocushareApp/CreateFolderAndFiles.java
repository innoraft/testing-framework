package TestCOT.StudentRole.DocushareApp;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateFolderAndFiles {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;
    private String[] Tracking = null;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 20);
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl + "/");
    }

    @Test
    public void testCreateFolderAndFiles() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");

        driver.get(baseUrl + "/document-locker");
        // Click Docushare
        driver.findElement(By.linkText("DOCUSHARE")).click();

        // Click Upload Document
        driver.findElement(By.cssSelector("span.show-file-add-form")).click();
        // Enter Document Name
        driver.findElement(By.id("edit-title")).clear();
        Tracking = func.RandomWords(3);
        driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + " " + Tracking[1] + " " + Tracking[2]);
        // Upload File
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).sendKeys("C:\\Users\\om\\Downloads\\abc.txt");
        // Click Save
        driver.findElement(By.xpath("//input[@id='edit-submit']")).click();

        // Click Hidden Checkbox using Actions Class
        WebElement Element = driver.findElement(By.xpath("//form[@id='views-form-views-document-locker-files-block']/div/div[2]"));
        WebElement HiddenElement = driver.findElement(By.xpath("//form[@id='views-form-views-document-locker-files-block']/div/div[2]/div[3]/span/div/input"));
        Actions action = new Actions(driver);
        action.moveToElement(Element).perform();
        Thread.sleep(2000);
        action.click(HiddenElement).perform();
        // Click download button
        driver.findElement(By.id("edit-files-submit")).click();

        // Check Document
        driver.findElement(By.cssSelector("span.show-file-list-form.file-showing-form")).click();
        driver.findElement(By.cssSelector("span.show-file-grid-form.file-showing-form")).click();

        // Click New Folder
        driver.findElement(By.cssSelector("span.show-folder-add-form")).click();
        // Enter Folder Name
        driver.findElement(By.id("edit-title--2")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-title--2")).sendKeys(Tracking[0] + " " + Tracking[1]);
        // Select Parent
        new Select(driver.findElement(By.id("edit-field-doc-loc-parent-folder-und"))).selectByVisibleText("Personal");
        // Click Save
        driver.findElement(By.xpath("//*[@id=\"edit-submit--2\"]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("//*[@id=\"edit-submit--2\"]")));
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