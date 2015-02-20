package Frameworks.KeywordDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Created by om on 2/18/2015.
 */
public class UIOperation {
    WebDriver driver;
    WebDriverWait wait;
    String FilesPath = "C:\\Users\\om\\Downloads\\TestingFiles\\Files\\";

    public UIOperation(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void Perform(String FieldType, String Locator, String LocatorType, String Value) throws Exception {
        if (FieldType.equalsIgnoreCase("TEXTFIELD")) {
            // Enter Text
            driver.findElement(GetSelector(Locator, LocatorType)).clear();
            driver.findElement(GetSelector(Locator, LocatorType)).sendKeys(Value);
        }
        else if (FieldType.equalsIgnoreCase("BUTTON")) {
            // Click Button
            driver.findElement(GetSelector(Locator, LocatorType)).click();
        }
        else if (FieldType.equalsIgnoreCase("LINK")) {
            // Click Link
            driver.findElement(GetSelector(Locator, LocatorType)).click();
        }
        else if (FieldType.equalsIgnoreCase("UPLOAD FILE")) {
            // Upload File
            driver.findElement(GetSelector(Locator, LocatorType)).sendKeys(FilesPath + Value);
        }
        else if (FieldType.equalsIgnoreCase("URL")) {
            // Go To Url
            driver.get(Value);
        }
        else if (FieldType.equalsIgnoreCase("URL")) {
            // Go To Url
            driver.get(Value);
        }
        else if (FieldType.equalsIgnoreCase("CKEditor")) {
            // Go To Url
            driver.get(Value);
        }
        else if (FieldType.equalsIgnoreCase("SINGLE SELECT LIST")) {
            // Extend Locator
            String ExtendedLocator = Locator + "/option";
            // Select Item
            List<WebElement> SelectListOptions = driver.findElements(GetSelector(ExtendedLocator, LocatorType));
            int OptionsNumber = SelectListOptions.size();
            int TotalOptionsNumber = OptionsNumber - 1;
            if(TotalOptionsNumber > 0) {
                // Access Random Option
                int RandomOption = RandomIntegerNumber(TotalOptionsNumber);
                // Select Random Option
                new Select(driver.findElement(GetSelector(Locator, LocatorType))).selectByIndex(RandomOption);
            }
        }
        else if (FieldType.equalsIgnoreCase("")) {

        }
        else {
            throw new Exception("Incorrect Field Type");
        }
    }

    private By GetSelector(String Locator,String LocatorType) throws Exception{
        //Find by xpath
        if(LocatorType.equalsIgnoreCase("XPATH")) {
            return By.xpath(Locator);
        }
        //find by class
        else if(LocatorType.equalsIgnoreCase("CLASSNAME")) {
            return By.className(Locator);
        }
        //find by id
        else if(LocatorType.equalsIgnoreCase("ID")) {
            return By.id(Locator);
        }
        //find by name
        else if(LocatorType.equalsIgnoreCase("NAME")) {
            return By.name(Locator);
        }
        //Find by css
        else if(LocatorType.equalsIgnoreCase("CSS")) {
            return By.cssSelector(Locator);
        }
        //find by link
        else if(LocatorType.equalsIgnoreCase("LINK")) {
            return By.linkText(Locator);
        }
        else {
            throw new Exception("Incorrect Field Type");
        }
    }

    public int RandomIntegerNumber(int Max) throws IOException {
        Random random = new Random();
        // If Max have 5 than random number return from 0 to 4, So add 1.
        int number = random.nextInt(Max) + 1;
        return number;
    }
}