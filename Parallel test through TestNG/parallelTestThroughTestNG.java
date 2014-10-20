// Run multiple test in parallel through testing framework TestNG.

package BrowserStack;

/**
 * Created by om on 10/2/14.
 */

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestNG_Parallel_Run {

    private WebDriver driver;

    @BeforeClass
    @org.testng.annotations.Parameters(value={"browser","version","platform"})
    public void setUp(String browser, String version, String platform) throws Exception {
	// Describing the capabilities for test. 
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platform",platform);
        capability.setCapability("browserName", browser);
        capability.setCapability("browserVersion", version);
        capability.setCapability("project", "TestNG");
        capability.setCapability("build", "version1");
	// See the debugging of test on browserStack.
        capability.setCapability("browserstack.debug", "true");
	// Test will run on browserStack by specifying the username and automate key.
        driver = new RemoteWebDriver(new URL("http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub"), capability);
	// How much time driver will wait for element to be loaded.
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSimple() throws Exception {
        driver.get("http://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Browser Stack");
        element.submit();
        driver = new Augmenter().augment(driver);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("Screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}