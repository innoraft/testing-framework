package TestCOT.StudentRole.StudentAssessment;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import TestCOT.Common.Functions;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DoWhatYouAre_Pending {
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
    public void testDoWhatYouAre() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/learning-styles/75486");

        // Click Do What You Are
        driver.findElement(By.linkText("DO WHAT YOU ARE")).click();
        // Click Continue
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("as_port_dwya_result_193_as_answer_id_19")).click();
        driver.findElement(By.id("as_port_dwya_result_193_as_answer_id_19")).click();
        driver.findElement(By.cssSelector("label.span2.question-2")).click();
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("as_port_dwya_result_195_as_answer_id_19")).click();
        driver.findElement(By.id("as_port_dwya_result_195_as_answer_id_19")).click();
        driver.findElement(By.xpath("//form[@id='pageform']/div[3]/div/div/label[2]")).click();
        driver.findElement(By.id("__sizzle__")).click();
        driver.findElement(By.id("as_port_dwya_result_194_as_answer_id_19")).click();
        driver.findElement(By.xpath("//form[@id='pageform']/div[2]/div/div/label[2]")).click();
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("__sizzle__")).click();
        driver.findElement(By.id("as_port_dwya_result_196_as_answer_id_18")).click();
        driver.findElement(By.cssSelector("label.span2.question-1")).click();
        driver.findElement(By.id("as_port_dwya_result_197_as_answer_id_18")).click();
        driver.findElement(By.id("as_port_dwya_result_197_as_answer_id_18")).click();
        driver.findElement(By.xpath("//form[@id='pageform']/div[2]/div/div/label")).click();
        driver.findElement(By.id("as_port_dwya_result_198_as_answer_id_19")).click();
        driver.findElement(By.id("as_port_dwya_result_198_as_answer_id_19")).click();
        driver.findElement(By.xpath("//form[@id='pageform']/div[3]/div/div/label[2]")).click();
        driver.findElement(By.id("__sizzle__")).click();
        driver.findElement(By.id("as_port_dwya_result_199_as_answer_id_19")).click();
        driver.findElement(By.xpath("//form[@id='pageform']/div[4]/div/div/label[2]")).click();
        driver.findElement(By.id("as_port_dwya_result_199_as_answer_id_19")).click();
        driver.findElement(By.id("as_port_dwya_result_199_as_answer_id_19")).click();
        driver.findElement(By.id("__sizzle__")).click();
        driver.findElement(By.id("as_port_dwya_result_200_as_answer_id_19")).click();
        driver.findElement(By.xpath("//form[@id='pageform']/div[5]/div/div/label[2]")).click();
        driver.findElement(By.id("as_port_dwya_result_201_as_answer_id_18")).click();
        driver.findElement(By.id("as_port_dwya_result_201_as_answer_id_18")).click();
        driver.findElement(By.xpath("//form[@id='pageform']/div[6]/div/div/label")).click();
        driver.findElement(By.id("continue")).click();
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

// Unable to understand the steps