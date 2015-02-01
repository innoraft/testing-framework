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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by om on 1/24/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(value = Parameterized.class)
public class HomepageBanner extends HCLAbstract {
    private String Title;
    private String Body;
    private String BannerImage;
    private String BannerLinkTitle;
    private String BannerLinkUrl;
    private String MetatagDescription;
    private String MetatagKeyword;

    /**
     * Define a Collection method that will return the collection of parameters to the parallelTestThroughJUnit class
     * by using the @Parameters annotation.
     */
    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(
                new Object[][]{
                        {"title", "body", FilesPath + "abc.jpg", "LinkTitle", "https://www.google.co.in", "metaDesc", "metaKey", "all inputs are correct"}
//                        {"Today", "-1", "70", "FB Total is negative"},
//                        {"Today", "181", "-1", "Twitter Total is negative"},
//                        {"Today", "178", "abc", "Twitter Total is alphabetic"},
//                        {"Today", "abc", "15","FB Total is alphabetic"},
//                        {"Yesterday", "160", "45", "When date of past"},
//                        {"Tomorrow", "160", "45", "When date of future"}
                }
        );
    }

    // Constructor will be used by the test runner to pass the parameters to the Excel_drive class instance.
    public HomepageBanner(String Title, String Body, String BannerImage, String BannerLinkTitle, String BannerLinkUrl, String MetatagDescription, String MetatagKeyword, String TestCase) {
        this.Title = Title;
        this.Body = Body;
        this.BannerImage = BannerImage;
        this.BannerLinkTitle = BannerLinkTitle;
        this.BannerLinkUrl = BannerLinkUrl;
        this.MetatagDescription = MetatagDescription;
        this.MetatagKeyword = MetatagKeyword;
        this.TestCase = TestCase;
        this.Role = "Admin";
    }

    @Test
    public void CreateContent() throws Exception {
        try {
            // Move to Homepage Banner page
            driver.get(baseUrl + "/node/add/homepage-banner");
            // Enter Title
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-title-field')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-title-field')]//input")).sendKeys(Title);
            // Select Language
            func2.SelectRandomSelectListOption("//div[contains(@class, 'form-item-language')]//select");
            // Enter Body
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'text-full')]/following-sibling::div[contains(@class, 'cke_browser_gecko')]//span[contains(@class, 'cke_button__source_label')]")).click();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'cke_editable_themed')]")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'cke_editable_themed')]")).sendKeys(Body);
            // Upload Banner Image
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-banner')]//input[@type='file']")).sendKeys(BannerImage);
            // Click Upload
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-banner')]//input[@type='submit']")).click();
            // Wait for upload
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'field-name-field-banner')]//input[@value='Remove']")));
            // Enter Banner Link Title
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-title')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-title')]//input")).sendKeys(BannerLinkTitle);
            // Enter Banner Link Url
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-url')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-url')]//input")).sendKeys(BannerLinkUrl);
            // Enter Metatag Description
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-description')]//textarea")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-description')]//textarea")).sendKeys(MetatagDescription);
            // Enter Metatag Keyword
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-keywords')]//textarea")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-keywords')]//textarea")).sendKeys(MetatagKeyword);
            // Click Save
            driver.findElement(By.id("edit-submit")).click();
            // Check content created or not
            driver.findElement(By.xpath("//div[@class='messages messages--status']"));
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
            // Click edit link of that content which type is Homepage Banner
            driver.get(baseUrl + "/admin/content");
            // Click edit link of that content which type is Homepage Banner
            List<WebElement> Types = driver.findElements(By.xpath("//table[contains(@class, 'sticky-enabled')]/tbody/tr/td[3]"));
            String ContentType = null;
            int RowNumber = 0;
            for (int i = 0; i < Types.size(); i++) {
                ContentType = Types.get(i).getText();
                if (ContentType.equals("Homepage Banner")) {
                    RowNumber = i + 1;
                    driver.findElement(By.xpath("//table[contains(@class, 'sticky-enabled')]/tbody/tr[" + RowNumber + "]/td[8]/ul/li[1]/a")).click();
                    break;
                }
            }
            // Enter Title
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-title-field')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-title-field')]//input")).sendKeys(Title);
            // Select Language
            func2.SelectRandomSelectListOption("//div[contains(@class, 'form-item-language')]//select");
            // Enter Body
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'text-full')]/following-sibling::div[contains(@class, 'cke_browser_gecko')]//span[contains(@class, 'cke_button__source_label')]")).click();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'cke_editable_themed')]")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'cke_editable_themed')]")).sendKeys(Body);
            // Remove Banner Image
            if (func.isElementPresent(By.xpath("//div[contains(@class, 'field-name-field-banner')]//input[@value='Remove']"))) {
                driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-banner')]//input[@value='Remove']")).click();
                // Wait for remove
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'field-name-field-banner')]//input[@type='file']")));
            }
            // Upload Banner Image
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-banner')]//input[@type='file']")).sendKeys(BannerImage);
            // Click Upload
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-banner')]//input[@type='submit']")).click();
            // Wait for upload
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'field-name-field-banner')]//input[@value='Remove']")));
            // Enter Banner Link Title
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-title')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-title')]//input")).sendKeys(BannerLinkTitle);
            // Enter Banner Link Url
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-url')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-url')]//input")).sendKeys(BannerLinkUrl);
            // Enter Metatag Description
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-description')]//textarea")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-description')]//textarea")).sendKeys(MetatagDescription);
            // Enter Metatag Keyword
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-keywords')]//textarea")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-keywords')]//textarea")).sendKeys(MetatagKeyword);
            // Click Save
            driver.findElement(By.id("edit-submit")).click();
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
