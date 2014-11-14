package TestCOT.StudentRole.DigitalPortfolio;

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

public class AddShowcase {
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
    public void testAddShowcase() throws Exception {
        driver.get(baseUrl + "/journals");
        driver.findElement(By.linkText("Showcases")).click();
        driver.findElement(By.linkText("Showcases")).click();
        driver.findElement(By.linkText("New Showcase")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("visit manali");
        driver.findElement(By.id("edit-field-showcase-description-und-0-value")).clear();
        driver.findElement(By.id("edit-field-showcase-description-und-0-value")).sendKeys("fun and only fun ;)");
        driver.findElement(By.id("edit-field-showcase-skills-acquired-und-8")).click();
        driver.findElement(By.id("edit-field-showcase-skills-acquired-und-17")).click();
        driver.findElement(By.id("edit-field-showcase-skills-acquired-und-14")).click();
        driver.findElement(By.id("edit-field-showcase-skills-acquired-und-15")).click();
        driver.findElement(By.id("botr-upload-button")).click();
        driver.findElement(By.name("file")).clear();
        driver.findElement(By.name("file")).sendKeys("/home/akash/Videos/Andaman & Nicobar Islands(2 sec video)-BzosVry7nc4.mp4");
        driver.findElement(By.cssSelector("p > input[name=\"title\"]")).clear();
        driver.findElement(By.cssSelector("p > input[name=\"title\"]")).sendKeys("manali trip");
        driver.findElement(By.cssSelector("input.botr-upload-submit.form-submit")).click();
        driver.findElement(By.id("showcase-upload-doc")).click();
        driver.findElement(By.id("edit-field-showcase-documents-und-0-upload")).clear();
        driver.findElement(By.id("edit-field-showcase-documents-und-0-upload")).sendKeys("/home/akash/Desktop/a.doc");
        driver.findElement(By.id("edit-field-showcase-documents-und-0-description")).clear();
        driver.findElement(By.id("edit-field-showcase-documents-und-0-description")).sendKeys("journy");
        driver.findElement(By.id("edit-field-showcase-documents-und-0-description")).clear();
        driver.findElement(By.id("edit-field-showcase-documents-und-0-description")).sendKeys("journey description");
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

