package TestCOT.StudentRole.DocushareApp;

/**
 * Created by om on 11/12/2014.
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFolderAndFiles {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCreateFolderAndFiles() throws Exception {
        driver.get(baseUrl + "/document-locker");
        driver.findElement(By.linkText("DocuShare")).click();
        driver.findElement(By.linkText("DocuShare")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[2]/div/span")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[4]/div/span")).click();
        driver.findElement(By.cssSelector("span.field-content")).click();
        driver.findElement(By.cssSelector("span.show-file-add-form")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("my personal diary");
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).clear();
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).sendKeys("/home/akash/Desktop/a.doc");
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.id("edit-views-bulk-operations-0")).click();
        driver.findElement(By.id("edit-files-submit")).click();
        driver.findElement(By.id("edit-views-bulk-operations-0")).click();
        driver.findElement(By.cssSelector("span.show-file-list-form.file-showing-form")).click();
        driver.findElement(By.cssSelector("span.show-file-grid-form.file-showing-form")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[2]/div/span")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[3]/div/span")).click();
        driver.findElement(By.cssSelector("span.show-file-add-form")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("my maths algebra assignment");
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).clear();
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).sendKeys("/home/akash/Desktop/a.doc");
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.id("edit-views-bulk-operations-0")).click();
        driver.findElement(By.id("edit-views-bulk-operations-0")).click();
        driver.findElement(By.cssSelector("span.show-file-list-form.file-showing-form")).click();
        driver.findElement(By.cssSelector("span.show-file-grid-form.file-showing-form")).click();
        driver.findElement(By.cssSelector("span.show-folder-add-form")).click();
        driver.findElement(By.id("edit-title--2")).clear();
        driver.findElement(By.id("edit-title--2")).sendKeys("maths docs");
        driver.findElement(By.cssSelector("span.show-folder-add-form")).click();
        driver.findElement(By.id("edit-title--2")).clear();
        driver.findElement(By.id("edit-title--2")).sendKeys("personal maths docs");
        new Select(driver.findElement(By.id("edit-field-doc-loc-parent-folder-und"))).selectByVisibleText("Personal");
        driver.findElement(By.cssSelector("span.field-content")).click();
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[5]/div/div/div/div[5]/div/div/div/div[2]/div/div/div/ul/li[2]/div/span")).click();
        driver.findElement(By.cssSelector("span.show-file-add-form")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("personal maths docu");
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).clear();
        driver.findElement(By.id("edit-field-doc-loc-uploaded-file-und-0-upload")).sendKeys("/home/akash/Desktop/a.doc");
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

