package TestCOT.SchoolAdminRole.College;

/**
 * Created by om on 11/12/2014.
 */
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import TestCOT.CommonFunctions.Functions;
import javafx.scene.control.Slider;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCollege {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://satishtest.devcloud.acquia-sites.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testCollege() throws Exception {
        Functions func = new Functions(driver);
        func.CheckLogin();
        func.LoginRole("SchoolAdmin");
        driver.get(baseUrl + "/college-search");

        // Functions For Find Colleges
        SearchButton(func);
        TypesOfSchool(func);
        AreaOfStudy(func);
        SpecialNeeds(func);
        ActivitiesOfInterest(func);
        Sports(func);
        Location(func);
    }

    private void SearchButton(Functions func) throws IOException {
        // Enter Text To Be Search
        driver.findElement(By.id("edit-keys")).clear();
        driver.findElement(By.id("edit-keys")).sendKeys("Abilene");
        // Click Search
        driver.findElement(By.xpath("//form/div/div/input")).click();
        // Check Result Received or Not
        try {
            assertTrue(func.isTextPresent(driver.findElement(By.xpath("//div[5]/div/div/div[2]/div")).getText()));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Click All Selections
        driver.findElement(By.linkText("Clear All Selections")).click();
    }

    private void TypesOfSchool(Functions func) throws IOException {
        // Click Type of School
        driver.findElement(By.cssSelector("strong")).click();
        // Click Private
        driver.findElement(By.id("edit-public-private-private")).click();
        // Move School Size Slider
        WebElement Slider1 = driver.findElement(By.id("population_jq_slider"));
        Actions moveSlider1 = new Actions(driver);
        Action action1 = moveSlider1.dragAndDropBy(Slider1, 0, 10).build();
        action1.perform();
        // Select Religious Affiliation
        new Select(driver.findElement(By.id("edit-religious-affiliation"))).selectByVisibleText("Church of Christ");
        // Move Tuition Range Slider
        WebElement Slider2 = driver.findElement(By.id("tuition_range_jq_slider"));
        Actions moveSlider2 = new Actions(driver);
        Action action2 = moveSlider2.dragAndDropBy(Slider2, 0, 10).build();
        action2.perform();
        // Click Apply
        driver.findElement(By.xpath("//div[8]/input")).click();
        // Check Result Received or Not
        try {
            assertTrue(func.isTextPresent(driver.findElement(By.xpath("//div[5]/div/div/div[2]/div")).getText()));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Click All Selections
        driver.findElement(By.linkText("Clear All Selections")).click();
    }

    private void AreaOfStudy(Functions func) throws IOException, InterruptedException {
        // Click Area of School
        driver.findElement(By.xpath("//li[2]/a/strong")).click();
        // Select One Area Study
        new Select(driver.findElement(By.id("edit-area-of-study-parent"))).selectByVisibleText("Area, Ethnic, Cultural, and Gender Studies");
        // Wait For Another Select List To Load
        Thread.sleep(5000);
        // Select Subareas of Study
        new Select(driver.findElement(By.id("edit-area-of-study--2"))).selectByVisibleText("Area, Ethnic, Cultural, and Gender Studies, Other");
        // Click Apply
        driver.findElement(By.xpath("//div[5]/input")).click();
        // Check Result Received or Not
        try {
            assertTrue(func.isTextPresent(driver.findElement(By.xpath("//div[5]/div/div/div[2]/div")).getText()));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Click All Selections
        driver.findElement(By.linkText("Clear All Selections")).click();
    }

    private void SpecialNeeds(Functions func) throws IOException {
        // Click Special Needs
        driver.findElement(By.xpath("//li[3]/a/strong")).click();
        // Select Special Needs
        Select SpecialNeeds = new Select(driver.findElement(By.id("edit-special-needs")));
        // Select Learning Center
        SpecialNeeds.selectByVisibleText("Learning Center");
        // Select Early Syllabus
        SpecialNeeds.selectByVisibleText("Early syllabus");
        // Click Apply
        driver.findElement(By.xpath("//fieldset[3]/div/div[5]/input")).click();
        // Check Result Received or Not
        try {
            assertTrue(func.isTextPresent(driver.findElement(By.xpath("//div[5]/div/div/div[2]/div")).getText()));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Click All Selections
        driver.findElement(By.linkText("Clear All Selections")).click();
    }

    private void ActivitiesOfInterest(Functions func) throws IOException {
        // Click Activities of Interest
        driver.findElement(By.xpath("//li[4]/a/strong")).click();
        // Click Student Newspaper Checkbox
        driver.findElement(By.xpath("//div[11]/input")).click();
        // Click TV Station Checkbox
        driver.findElement(By.xpath("//div[13]/input")).click();
        // Click Apply
        driver.findElement(By.xpath("//fieldset[4]/div/div[5]/input")).click();
        // Check Result Received or Not
        try {
            assertTrue(func.isTextPresent(driver.findElement(By.xpath("//div[5]/div/div/div[2]/div")).getText()));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Click All Selections
        driver.findElement(By.linkText("Clear All Selections")).click();
    }

    private void Sports(Functions func) throws IOException {
        // Click Sports
        driver.findElement(By.xpath("//li[5]/a/strong")).click();
        // Select Sports
        Select Sports = new Select(driver.findElement(By.id("edit-varsity-sports")));
        // Select Baseball
        Sports.selectByVisibleText("baseball");
        // Select Basketball
        Sports.selectByVisibleText("basketball");
        // Click Apply
        driver.findElement(By.xpath("//fieldset[5]/div/div[5]/input")).click();
        // Check Result Received or Not
        try {
            assertTrue(func.isTextPresent(driver.findElement(By.xpath("//div[5]/div/div/div[2]/div")).getText()));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Click All Selections
        driver.findElement(By.linkText("Clear All Selections")).click();
    }

    private void Location(Functions func) throws IOException {
        // Click Location
        driver.findElement(By.xpath("//li[6]/a/strong")).click();
        // Click West Checkbox
        driver.findElement(By.xpath("//fieldset[6]/div/div[4]/div/div[3]/input")).click();
        // Click South Checkbox
        driver.findElement(By.xpath("//fieldset[6]/div/div[4]/div/div[6]/input")).click();
        // Click Apply
        driver.findElement(By.xpath("//fieldset[6]/div/div[5]/input")).click();
        // Check Result Received or Not
        try {
            assertTrue(func.isTextPresent(driver.findElement(By.xpath("//div[5]/div/div/div[2]/div")).getText()));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Click All Selections
        driver.findElement(By.linkText("Clear All Selections")).click();
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

