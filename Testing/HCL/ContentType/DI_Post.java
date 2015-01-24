package Testing.HCL.ContentType;

import Testing.CommonFunction;
import Testing.HCL.HCLFunctions;
import Testing.HCL.HCLAbstract;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.MethodSorter;
import org.junit.runner.RunWith;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by om on 1/22/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(value = Parameterized.class)
public class DI_Post extends HCLAbstract {
    private String Date;
    private String FB_Total;
    private String Twitter_Total;
    private String TestCase;

    /**
     * Define a Collection method that will return the collection of parameters to the parallelTestThroughJUnit class
     * by using the @Parameters annotation.
     */
    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(
                new Object[][]{
                        {"Today", "160", "45", "FB Total and Twitter Total are correct"},
                        {"Today", "-1", "70", "FB Total is negative"},
                        {"Today", "181", "-1", "Twitter Total is negative"},
                        {"Today", "178", "abc", "Twitter Total is alphabetic"},
                        {"Today", "abc", "15","FB Total is alphabetic"},
                        {"Yesterday", "160", "45", "When date of past"},
                        {"Tomorrow", "160", "45", "When date of future"}
                }
        );
    }

    // Constructor will be used by the test runner to pass the parameters to the Excel_drive class instance.
    public DI_Post(String Date, String FB_Total, String Twitter_Total, String TestCase)
    {
        this.Date = Date;
        this.FB_Total = FB_Total;
        this.Twitter_Total = Twitter_Total;
        this.TestCase = TestCase;
        this.Role = "Admin";
    }

    @Test
    public void CreateContent() throws Exception {
        try {
            // Move to create content page
            driver.get(func.baseUrl + "/node/add/di-posts");
            // Enter Date
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-di-date')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-di-date')]//input")).sendKeys(func2.GenerateDate(Date));
            // Select DI Profile
            func2.SelectRandomChosenOption("//div[@id='edit_field_di_profile_und_chosen']//ul[@class='chosen-results']/li", "//div[@id='edit_field_di_profile_und_chosen']/a", "//li[@data-option-array-index='");
            // Enter FB Total
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-fb-total')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-fb-total')]//input")).sendKeys(FB_Total);
            // Enter Twitter Total
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-twitter-total')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-twitter-total')]//input")).sendKeys(Twitter_Total);
            // Click Save
            driver.findElement(By.xpath("//div[contains(@class, 'form-actions')]/input")).click();
            // Check content created or not
            driver.findElement(By.xpath("//div[contains(@class, 'field--name-field-di-total-posts')]"));
            // Set Result Pass
            func.SetResultPass(TestCase);
        } catch (Exception e) {
            // Set Result Fail
            func.SetResultFail(TestCase, e);
        }
    }

    @Test
    public void UpdateContent() throws Exception {
        try {
            // Click edit link of that content which type is DI Posts
            driver.get(func.baseUrl + "/admin/content");
            // Click edit link of that content which type is DI Posts
            List<WebElement> Types = driver.findElements(By.xpath("//table[contains(@class, 'sticky-enabled')]/tbody/tr/td[3]"));
            String ContentType = null;
            int RowNumber = 0;
            for (int i = 0; i < Types.size(); i++) {
                ContentType = Types.get(i).getText();
                if (ContentType.equals("DI Posts")) {
                    RowNumber = i + 1;
                    driver.findElement(By.xpath("//table[contains(@class, 'sticky-enabled')]/tbody/tr[" + RowNumber + "]/td[8]/ul/li[1]/a")).click();
                    break;
                }
            }
            // Enter FB Total
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-fb-total')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-fb-total')]//input")).sendKeys(FB_Total);
            // Enter Twitter Total
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-twitter-total')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-twitter-total')]//input")).sendKeys(Twitter_Total);
            // Click Save
            driver.findElement(By.xpath("//div[contains(@class, 'form-actions')]//input[@id='edit-submit']")).click();
            // Check content created or not
            driver.findElement(By.xpath("//div[@class='messages status']"));
            // Set Result Pass
            func.SetResultPass(TestCase);
        } catch (Exception e) {
            // Set Result Fail
            func.SetResultFail(TestCase, e);
        }
    }
}
