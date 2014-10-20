// Drive test through chrome and IE webDriver

package Selenium;

/**
 * Created by om on 12/6/13.
 */

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver_Chrome_IE {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        baseUrl = "http://book.theautomatedtester.co.uk/";
    }

    @Test
    public void testFirst() throws Exception {
	// Specify the path of chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\om\\Downloads\\Programs\\Starting Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        testOutputValue();
    }

    @Test
    public void testSecond() throws Exception {
	// Specify the path of IEDriverServer.
        System.setProperty("webdriver.ie.driver", "C:\\Users\\om\\Downloads\\Programs\\Starting Selenium\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        testOutputValue();
    }

    private void testOutputValue() throws InterruptedException {
        driver.get(baseUrl + "/chapter1");
        driver.findElement(By.id("loadajax")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.cssSelector("#ajaxdiv > p"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        try {
            assertEquals("The following text has been loaded from another page on this site. It has been loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter", driver.findElement(By.cssSelector("#ajaxdiv > p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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

/*
WebDriver, it's just an interface. Implementations of it include: InternetExplorerDriver, FirefoxDriver, ChromeDriver, HtmlUnitDriver, OperaDriver and RemoteWebDriver.
 */