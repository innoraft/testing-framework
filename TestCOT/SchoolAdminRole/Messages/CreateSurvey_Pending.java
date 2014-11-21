package TestCOT.SchoolAdminRole.Messages;

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
import org.openqa.selenium.support.ui.Select;

public class CreateSurvey_Pending {
    private WebDriver driver;
    private String baseUrl;
    private String[] Tracking = null;
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
    public void testCreateSurvey() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("SchoolAdmin");
        driver.get(baseUrl + "/messages/broadcast");

        driver.findElement(By.linkText("SURVEY")).click();
        driver.findElement(By.linkText("CREATE SURVEY")).click();
        driver.findElement(By.id("edit-survey-title")).clear();
        Tracking = func.RandomWords(2);
        driver.findElement(By.id("edit-survey-title")).sendKeys(Tracking[0], " ", Tracking[1]);
        driver.findElement(By.id("edit-new")).click();

        driver.findElement(By.cssSelector("label")).click();
        driver.findElement(By.id("edit-title")).clear();
        driver.findElement(By.id("edit-title")).sendKeys("In School there should be a parent meeting day");
        driver.findElement(By.xpath("//form[@id='form-builder-field-configure']/div/ul/li[2]/span")).click();
        driver.findElement(By.xpath("//table[@id='edit-options-options-field-widget']/tbody/tr[3]/td[3]/a[2]")).click();
        driver.findElement(By.xpath("(//input[@value='one'])[4]")).clear();
        driver.findElement(By.xpath("(//input[@value='one'])[4]")).sendKeys("Yes");
        driver.findElement(By.xpath("(//input[@value='two'])[4]")).clear();
        driver.findElement(By.xpath("(//input[@value='two'])[4]")).sendKeys("No");

        driver.findElement(By.linkText("Save Survey")).click();
        driver.findElement(By.linkText("Assign Survey")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
        driver.findElement(By.cssSelector("a.chzn-single.chzn-single-with-drop > span")).click();
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

// How to automate the code for drag and drop.
