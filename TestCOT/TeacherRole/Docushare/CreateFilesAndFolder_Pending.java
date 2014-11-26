package TestCOT.TeacherRole.Docushare;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFilesAndFolder_Pending {
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
    public void testCreateFilesAndFolder() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(baseUrl + "/document-locker");

        // Click Docushare
        driver.findElement(By.linkText("DOCUSHARE")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[2]/div/span")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[3]/div/span")).click();
        driver.findElement(By.id("edit-files-type-1")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("#edit_student_name_chzn > a.chzn-single > span")).click();
        driver.findElement(By.id("edit-views-bulk-operations-0")).click();
        driver.findElement(By.id("edit-files-submit")).click();
        driver.findElement(By.id("edit-views-bulk-operations-0")).click();
        driver.findElement(By.cssSelector("span.show-file-list-form.file-showing-form")).click();
        driver.findElement(By.cssSelector("span.show-file-grid-form.file-showing-form")).click();
        driver.findElement(By.id("edit-files-type-0")).click();
        driver.findElement(By.cssSelector("span.show-file-add-form")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("teacher maths file");
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).clear();
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).sendKeys("/home/akash/Desktop/a.doc");
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[4]/div/span")).click();
        driver.findElement(By.cssSelector("#__sizzle__ > div.views-field.views-field-title > span.field-content")).click();
        driver.findElement(By.cssSelector("#__sizzle__ > div.views-field.views-field-title > span.field-content")).click();
        driver.findElement(By.cssSelector("#__sizzle__ > div.views-field.views-field-title > span.field-content")).click();
        driver.findElement(By.id("edit-files-type-1")).click();
        driver.findElement(By.xpath("//div[@id='edit-files-type']/div[2]/label")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("#edit_student_name_chzn > a.chzn-single > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single > span")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[2]/div/span")).click();
        driver.findElement(By.cssSelector("span.field-content")).click();
        driver.findElement(By.cssSelector("span.show-folder-add-form")).click();
        driver.findElement(By.id("edit-title--2")).clear();
        driver.findElement(By.id("edit-title--2")).sendKeys("dairy");
        new Select(driver.findElement(By.id("edit-field-doc-loc-parent-folder-und"))).selectByVisibleText("Personal");
        driver.findElement(By.cssSelector("span.field-content")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[2]/div/span")).click();
        driver.findElement(By.cssSelector("span.show-file-add-form")).click();
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).clear();
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).sendKeys("/home/akash/Desktop/a.doc");
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("daily dairy");
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.linkText("Dairy")).click();
        driver.findElement(By.id("edit-title--3")).clear();
        driver.findElement(By.id("edit-title--3")).sendKeys("daily dairy");
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[3]/div/span")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[4]/div/span")).click();
        driver.findElement(By.id("edit-views-bulk-operations-0")).click();
        driver.findElement(By.id("edit-share-files")).click();
        driver.findElement(By.id("edit-assigned-user-type-2")).click();
        driver.findElement(By.xpath("//div[@id='edit-assigned-user-type']/div[2]/label")).click();
        driver.findElement(By.xpath("//div[@id='edit-assigned-user-type']/div/label")).click();
        driver.findElement(By.id("edit-assigned-user-type-1")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div[5]/div/div/div/div/div[2]/img")).click();
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

// Steps not visible at site.