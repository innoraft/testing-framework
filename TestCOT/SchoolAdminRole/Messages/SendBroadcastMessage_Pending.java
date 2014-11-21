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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendBroadcastMessage_Pending {
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
    public void testSendBroadcastMessage() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("SchoolAdmin");
        driver.get(baseUrl + "/messages/broadcast");



        driver.findElement(By.linkText("BROADCAST")).click();
//        Select clickThis = new Select(driver.findElement(By.cssSelector("b")));
//        clickThis.selectByVisibleText("6th grade");
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, /*seconds=*/10);
//            Select select = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("b"))));
//            select.deselectAll();
//            select.selectByVisibleText("6th grade");
//
//        } catch (NoSuchElementException ex) {
//            System.out.println("PAGE SOURCE: \n" + driver.getPageSource());
//            ex.printStackTrace();
//        }
        driver.findElement(By.id("edit-subject")).click();
        driver.findElement(By.id("edit-subject")).clear();
        driver.findElement(By.id("edit-subject")).sendKeys("hello student,");
        driver.findElement(By.id("edit-body-value")).clear();
        driver.findElement(By.id("edit-body-value")).sendKeys("Bring science book.");
        driver.findElement(By.id("edit-submit--2")).click();
        driver.findElement(By.linkText("hello student,")).click();
        driver.findElement(By.cssSelector("span.close-button > img")).click();
    }

    private void clickAt(By by) throws InterruptedException {
        Thread.sleep(1500);
        Actions builder = new Actions(driver);
        WebElement tagElement = driver.findElement(by);
        builder.moveToElement(tagElement).click().perform();
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

// How to write automate code for select the item from select list.