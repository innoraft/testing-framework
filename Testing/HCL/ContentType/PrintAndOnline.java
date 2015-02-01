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

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by om on 1/24/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(value = Parameterized.class)
public class PrintAndOnline extends HCLAbstract {
    private String Title;
    private String PublishedDate;
    private String Description;
    private String Source;
    private String PDF;
    private String LinkTitle;
    private String LinkUrl;
    private String Thumbnail;
    private String AlternateText;
    private String PictureTitle;
    private String TranscriptTitle;
    private String TranscriptUrl;
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
                        {"title", "Today", "Desc", "source", FilesPath + "bc.pdf", "linkTitle", "https://www.google.co.in", FilesPath + "abc.jpg", "Alt", "PicTitle", "TransTitle", "https://www.google.co.in", "MetaDesc", "MetaKey", "All inputs are correct"}
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
    public PrintAndOnline(String Title, String PublishedDate, String Description, String Source, String PDF, String LinkTitle, String LinkUrl, String Thumbnail, String AlternateText, String PictureTitle, String TranscriptTitle, String TranscriptUrl, String MetatagDescription, String MetatagKeyword, String TestCase) {
        this.Title = Title;
        this.PublishedDate = PublishedDate;
        this.Description = Description;
        this.Source = Source;
        this.PDF = PDF;
        this.LinkTitle = LinkTitle;
        this.LinkUrl = LinkUrl;
        this.Thumbnail = Thumbnail;
        this.AlternateText = AlternateText;
        this.PictureTitle = PictureTitle;
        this.TranscriptTitle = TranscriptTitle;
        this.TranscriptUrl = TranscriptUrl;
        this.MetatagDescription = MetatagDescription;
        this.MetatagKeyword = MetatagKeyword;
        this.TestCase = TestCase;
        this.Role = "Admin";
    }

    @Test
    public void CreateContent() throws Exception {
        try {
            // Move to press release page
            driver.get(baseUrl + "/node/add/news");
            // Enter Title
            driver.findElement(By.xpath("//div[contains(@class, 'form-item-title')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'form-item-title')]//input")).sendKeys(Title);
            // Enter Published Date
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-published-date')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-published-date')]//input")).sendKeys("02/19/2015");
            // Enter Description
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'text-full')]/following-sibling::div[contains(@class, 'cke_browser_gecko')]//span[contains(@class, 'cke_button__source_label')]")).click();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'cke_editable_themed')]")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'cke_editable_themed')]")).sendKeys(Description);
            // Enter Source
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-source')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-source')]//input")).sendKeys(Source);
            // Upload PDf
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-pdf-upload')]//input[@type='file']")).sendKeys(PDF);
            // Click Upload
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-pdf-upload')]//input[@type='submit']")).click();
            // Wait for upload
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'field-name-field-pdf-upload')]//input[contains(@id, 'remove')]")));
            // Enter Link Title
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-title')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-title')]//input")).sendKeys(LinkTitle);
            // Enter Link Url
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-url')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-url')]//input")).sendKeys(LinkUrl);
            // Upload Thumbnail
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[@type='file']")).sendKeys(Thumbnail);
            // Click Upload
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[@type='submit']")).click();
            // Wait for upload
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[contains(@id, 'remove')]")));
            // Enter alternate text
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[contains(@id, 'alt')]")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[contains(@id, 'alt')]")).sendKeys(AlternateText);
            // Enter picture title
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[contains(@id, 'title')]")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[contains(@id, 'title')]")).sendKeys(PictureTitle);
            // Enter Transcript Title
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-transcript')]//div[contains(@class, 'link-field-title')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-transcript')]//div[contains(@class, 'link-field-title')]//input")).sendKeys(TranscriptTitle);
            // Enter Transcript Url
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-transcript')]//div[contains(@class, 'link-field-url')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-transcript')]//div[contains(@class, 'link-field-url')]//input")).sendKeys(TranscriptUrl);
            // Select Service Lines
            new Select(driver.findElement(By.id("edit-taxonomy-vocabulary-2-und-hierarchical-select-selects-0"))).selectByVisibleText("HCL AXON");
            // Click Add
            driver.findElement(By.id("edit-taxonomy-vocabulary-2-und-hierarchical-select-dropbox-add")).click();
            // Wait for add
            Thread.sleep(5000);
            // Select Industries
            new Select(driver.findElement(By.id("edit-taxonomy-vocabulary-3-und-hierarchical-select-selects-0"))).selectByVisibleText("Professional Services");
            // Click Add
            driver.findElement(By.id("edit-taxonomy-vocabulary-3-und-hierarchical-select-dropbox-add")).click();
            // Wait for add
            Thread.sleep(5000);
            // Select Categories
            new Select(driver.findElement(By.id("edit-taxonomy-vocabulary-10-und-hierarchical-select-selects-0"))).selectByVisibleText("Human Resource (HR) News");
            // Click Add
            driver.findElement(By.id("edit-taxonomy-vocabulary-10-und-hierarchical-select-dropbox-add")).click();
            // Wait for add
            Thread.sleep(5000);
            // Enter Metatag Description
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-description')]//textarea")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-description')]//textarea")).sendKeys(MetatagDescription);
            // Enter Metatag Keyword
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-keywords')]//textarea")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-keywords')]//textarea")).sendKeys(MetatagKeyword);
            // Select Site Selection
            func2.SelectRandomChosenOption("//div[contains(@class, 'field-name-field-site-section')]//ul[@class='chosen-results']/li", "//div[contains(@class, 'field-name-field-site-section')]//ul", "[@data-option-array-index='");
            // Select Geo Presence Location
            func2.SelectRandomSelectListOption("//div[contains(@class, 'field-name-field-geo-presence-location')]//select");
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
            // Click edit link of that content which type is Print And Online
            driver.get(baseUrl + "/admin/content");
            // Click edit link of that content which type is Print And Online
            List<WebElement> Types = driver.findElements(By.xpath("//table[contains(@class, 'sticky-enabled')]/tbody/tr/td[3]"));
            String ContentType = null;
            int RowNumber = 0;
            for (int i = 0; i < Types.size(); i++) {
                ContentType = Types.get(i).getText();
                if (ContentType.equals("Print and Online")) {
                    RowNumber = i + 1;
                    driver.findElement(By.xpath("//table[contains(@class, 'sticky-enabled')]/tbody/tr[" + RowNumber + "]/td[8]/ul/li[1]/a")).click();
                    break;
                }
            }
            // Enter Title
            driver.findElement(By.xpath("//div[contains(@class, 'form-item-title')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'form-item-title')]//input")).sendKeys(Title);
            // Enter Published Date
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-published-date')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-published-date')]//input")).sendKeys("02/19/2015");
            // Enter Description
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'text-full')]/following-sibling::div[contains(@class, 'cke_browser_gecko')]//span[contains(@class, 'cke_button__source_label')]")).click();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'cke_editable_themed')]")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-body')]//textarea[contains(@class, 'cke_editable_themed')]")).sendKeys(Description);
            // Enter Source
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-source')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-source')]//input")).sendKeys(Source);
            // Remove PDF
            if (func.isElementPresent(By.xpath("//div[contains(@class, 'field-name-field-pdf-upload')]//input[@value='Remove']"))) {
                driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-pdf-upload')]//input[@value='Remove']")).click();
                // Wait for remove
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'field-name-field-pdf-upload')]//input[@type='file']")));
            }
            // Upload PDf
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-pdf-upload')]//input[@type='file']")).sendKeys(PDF);
            // Click Upload
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-pdf-upload')]//input[@type='submit']")).click();
            // Wait for upload
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'field-name-field-pdf-upload')]//input[@value='Remove']")));
            // Enter Link Title
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-title')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-title')]//input")).sendKeys(LinkTitle);
            // Enter Link Url
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-url')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-link')]//div[contains(@class, 'link-field-url')]//input")).sendKeys(LinkUrl);
            // Remove Thumbnail
            if (func.isElementPresent(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[@value='Remove']"))) {
                driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[@value='Remove']")).click();
                // Wait for remove
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[@type='file']")));
            }
            // Upload Thumbnail
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[@type='file']")).sendKeys(Thumbnail);
            // Click Upload
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[@type='submit']")).click();
            // Wait for upload
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[@value='Remove']")));
            // Enter alternate text
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[contains(@id, 'alt')]")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[contains(@id, 'alt')]")).sendKeys(AlternateText);
            // Enter picture title
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[contains(@id, 'title')]")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-upload-logo')]//input[contains(@id, 'title')]")).sendKeys(PictureTitle);
            // Enter Transcript Title
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-transcript')]//div[contains(@class, 'link-field-title')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-transcript')]//div[contains(@class, 'link-field-title')]//input")).sendKeys(TranscriptTitle);
            // Enter Transcript Url
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-transcript')]//div[contains(@class, 'link-field-url')]//input")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-field-transcript')]//div[contains(@class, 'link-field-url')]//input")).sendKeys(TranscriptUrl);
            // Select Service Lines
            new Select(driver.findElement(By.id("edit-taxonomy-vocabulary-2-und-hierarchical-select-selects-0"))).selectByVisibleText("HCL AXON");
            // Click Add
            driver.findElement(By.id("edit-taxonomy-vocabulary-2-und-hierarchical-select-dropbox-add")).click();
            // Wait for add
            Thread.sleep(5000);
            // Select Industries
            new Select(driver.findElement(By.id("edit-taxonomy-vocabulary-3-und-hierarchical-select-selects-0"))).selectByVisibleText("Professional Services");
            // Click Add
            driver.findElement(By.id("edit-taxonomy-vocabulary-3-und-hierarchical-select-dropbox-add")).click();
            // Wait for add
            Thread.sleep(5000);
            // Select Categories
            new Select(driver.findElement(By.id("edit-taxonomy-vocabulary-10-und-hierarchical-select-selects-0"))).selectByVisibleText("Human Resource (HR) News");
            // Click Add
            driver.findElement(By.id("edit-taxonomy-vocabulary-10-und-hierarchical-select-dropbox-add")).click();
            // Wait for add
            Thread.sleep(5000);
            // Enter Metatag Description
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-description')]//textarea")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-description')]//textarea")).sendKeys(MetatagDescription);
            // Enter Metatag Keyword
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-keywords')]//textarea")).clear();
            driver.findElement(By.xpath("//div[contains(@class, 'field-name-node-metatag-keywords')]//textarea")).sendKeys(MetatagKeyword);
            // Select Site Selection
            func2.SelectRandomChosenOption("//div[contains(@class, 'field-name-field-site-section')]//ul[@class='chosen-results']/li", "//div[contains(@class, 'field-name-field-site-section')]//ul", "[@data-option-array-index='");
            // Select Geo Presence Location
            func2.SelectRandomSelectListOption("//div[contains(@class, 'field-name-field-geo-presence-location')]//select");
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
