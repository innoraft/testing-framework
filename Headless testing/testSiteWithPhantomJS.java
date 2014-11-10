/**
 *Test will performed on a phantomJS browser through phantomJS driver. Test will be  *headless means without GUI.
 */

package Headless;

/**
 * Created by om on 10/11/2014.
 */

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.assertEquals;

public class Sample1 {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
	// Define the capabilities for test.
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Program Files\\phantomjs\\phantomjs.exe");
        driver = new PhantomJSDriver(caps);
        baseUrl = "http://www.mortgagecalculator.org/";
	// How much time driver will wait for element to be loaded.
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testFirst() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("param[homevalue]")).clear();
        driver.findElement(By.name("param[homevalue]")).sendKeys("40000");
        driver.findElement(By.name("param[principal]")).clear();
        driver.findElement(By.name("param[principal]")).sendKeys("30000");
        driver.findElement(By.name("param[interest_rate]")).clear();
        driver.findElement(By.name("param[interest_rate]")).sendKeys("9");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        try {
            assertEquals("$283.05", driver.findElement(By.cssSelector("td > h3")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}