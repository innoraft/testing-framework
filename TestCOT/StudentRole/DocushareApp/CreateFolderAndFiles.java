package TestCOT.StudentRole.DocushareApp;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateFolderAndFiles {
    Functions func;
    private WebDriver driver;
    private WebDriverWait wait;
    private String[] Tracking = null;
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
        driver.get(func.baseUrl + "/document-locker");
    }

    @Test
    public void testCreateFolderAndFiles() throws Exception {
        // Click Docushare
        driver.findElement(By.linkText("DOCUSHARE")).click();
        // Click Upload Document
        driver.findElement(By.cssSelector("span.show-file-add-form")).click();

        // Add To Document Locker
        // Enter Document Name
        driver.findElement(By.id("edit-title")).clear();
        Tracking = func.RandomWords(3);
        driver.findElement(By.id("edit-title")).sendKeys(Tracking[0] + " " + Tracking[1] + " " + Tracking[2]);
        // Upload File
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).sendKeys("C:\\Users\\om\\Downloads\\abc.txt");
        // Click Save
        driver.findElement(By.xpath("//form/div/div[2]/input")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//form/div/div[2]/input")));

        // Click Hidden Checkbox using Actions Class
        WebElement Element = driver.findElement(By.xpath("//form[@id='views-form-views-document-locker-files-block']/div/div[2]"));
        WebElement HiddenElement = driver.findElement(By.xpath("//form[@id='views-form-views-document-locker-files-block']/div/div[2]/div[3]/span/div/input"));
        Actions action = new Actions(driver);
        // Move To Element
        action.moveToElement(Element).perform();
        // Wait For Checkbox To Be Shown
        Thread.sleep(200);
        // Click Checkbox
        action.click(HiddenElement).perform();
        // Click download button
        driver.findElement(By.id("edit-files-submit")).click();

        // See Document in Different Form
        driver.findElement(By.cssSelector("span.show-file-list-form.file-showing-form")).click();
        driver.findElement(By.cssSelector("span.show-file-grid-form.file-showing-form")).click();

        // Click New Folder
        driver.findElement(By.cssSelector("span.show-folder-add-form")).click();
        // Create Folder
        // Enter Folder Name
        driver.findElement(By.id("edit-title--2")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-title--2")).sendKeys(Tracking[0] + " " + Tracking[1]);
        // Select Parent
        new Select(driver.findElement(By.id("edit-field-doc-loc-parent-folder-und"))).selectByVisibleText("Personal");
        // Click Save
        driver.findElement(By.xpath("//div[3]/input")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("//div[3]/input")));
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