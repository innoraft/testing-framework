/**
 * Student first click checkbox in front of college, to specify what he has decide till now about wishList college. There are some
 * default milestone of college and Student can also define the milestone(What he need to do, to get admission) for college.
 */

package TestCOT.StudentRole.Dashboard;

/**
 * Created by om on 11/12/2014.
 */
import java.util.List;
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCollegeStatusInCollegeMenu_Pending {
    private WebDriver driver;
    private String baseUrl;
    private int RandomRow = 0;
    private WebDriverWait wait;
    private String ApplicationItem = null;
    private String[] Tracking = null;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        baseUrl = "http://satishtest.devcloud.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testAddCollegeStatusInCollegeMenu() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("Student");
        driver.get(baseUrl + "/students-dashboard");

        // Click Colleges
        driver.findElement(By.xpath("//div[5]/a")).click();

        // Check Row Data Exist or Not
        List<WebElement> TableRows = driver.findElements(By.xpath("//table[2]/tbody/tr"));
        int rowNumber = TableRows.size();
        if(rowNumber > 0) {
            // Access Random Row
            RandomRow = func.RandomIntegerNumber(rowNumber);
            // Check Applied Checkbox Clicked or Not
            if (!driver.findElement(By.xpath("//tr[" + RandomRow  + "]/td[6]/form/div/div/div/input")).isSelected()) {
                driver.findElement(By.xpath("//tr[" + RandomRow  + "]/td[6]/form/div/div/div/input")).click();
                // Wait for checkbox to be Clicked
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("throbber")));
            }
            // Click Accepted Div
            driver.findElement(By.xpath("//tr[" + RandomRow  + "]/td[7]/form/div/div/div/div")).click();
            // Click Approved
            driver.findElement(By.xpath("//tr[" + RandomRow  + "]/td[7]/form/div/div[2]/div/div/input")).click();

            // Click Book Icon
            driver.findElement(By.xpath("//tr[" + RandomRow  + "]/td/div[2]")).click();
            // Click Checklist
            driver.findElement(By.xpath("//div[@class='cot-overlay-content']/div")).click();
            // Enter Application Item
            driver.findElement(By.xpath("//div[@class='form-item form-type-textfield form-item-title']/label/input")).clear();
            Tracking = func.RandomWords(2);
            ApplicationItem = Tracking[0] + " " + Tracking[1];
            driver.findElement(By.xpath("//div[@class='form-item form-type-textfield form-item-title']/label/input")).sendKeys(Tracking[0] + " " + Tracking[1]);
            // Click Save
            driver.findElement(By.xpath("//div[@class='vertical-tabs-panes vertical-tabs-processed']/div/input")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='vertical-tabs-panes vertical-tabs-processed']/div/input")));
            // Find Created Application Item
            WebElement userName = driver.findElement(By.xpath("//input[@*='dummy']"));
            System.out.println(userName.getText());
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

