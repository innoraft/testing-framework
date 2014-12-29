package TestCOT.CommonFunctions;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static junit.framework.Assert.assertTrue;

/**
 * Created by om on 11/12/2014.
 */
public class Functions {
    private WebDriver driver;
    public int timeoutOfOneElement = 15;
    public int timeoutOFAllElement = 10;
    public String baseUrl = "https://homeschool.prod.acquia-sites.com/";

    public Functions(WebDriver driver) {
        this.driver = driver;
    }

    public void CheckLogin() throws IOException {
        if(!isElementPresent(By.linkText("LOG IN"))) {
            driver.findElement(By.cssSelector("span.username-page-link")).click();
            driver.findElement(By.linkText("Sign Out")).click();
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

    public void LoginRole(String Role) throws IOException {
        String UserName = null;
        String Password = null;

        if (Role.equals("Parent")) {
            UserName = "";
            Password = "";
        } else if (Role.equals("Student")) {
            UserName = "g_1";
            Password = "student@COT";
        } else if (Role.equals("Teacher")) {
            UserName = "t_1";
            Password = "teacher@COT";
        } else if (Role.equals("SchoolAdmin")) {
            UserName = "g_schooladmin";
            Password = "schooladmin@COT";
        } else if (Role.equals("ContentManager")) {
            UserName = "amantest";
            Password = "password";
        }
        Login(UserName, Password);
    }

    public void Login(String UserName, String Password) throws IOException {
        driver.findElement(By.linkText("LOG IN")).click();
        driver.findElement(By.id("edit-name")).clear();
        driver.findElement(By.id("edit-name")).sendKeys(UserName);
        driver.findElement(By.id("edit-pass")).clear();
        driver.findElement(By.id("edit-pass")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@class='form-submit']")).click();
    }

    public Boolean isTextPresent(String Result) throws IOException {
        if(Result.contains("results retrieved")) {
            return true;
        } else {
            return false;
        }
    }

    public void ClickRandomCheckboxes(By Locator) throws IOException {
        List<WebElement> Checkboxes = driver.findElements(Locator);
        int NumberOfCheckboxes = Checkboxes.size();
        int NumberOfCheckboxesToBeClicked = NumberOfCheckboxes/2;
        // Get random integer numbers as NumberOfCheckboxesToBeClicked from NumberOfCheckboxes.
        int[] RandomNumber = ManyRandomIntegerNumber(NumberOfCheckboxes, NumberOfCheckboxesToBeClicked);
        for (int i = 0; i < NumberOfCheckboxesToBeClicked; i++) {
            int ExactCheckbox = RandomNumber[i] - 1;
            Checkboxes.get(ExactCheckbox).click();
        }
    }

    public void SelectRandomElement(String MainLocation, String RestLocation) throws IOException {
        List<WebElement> Elements = driver.findElements(By.xpath(MainLocation));
        int NumberOfElements = Elements.size();
        if(NumberOfElements > 0) {
            // Access Random Element
            int RandomElement = RandomIntegerNumber(NumberOfElements);
            // Click Random Element
            driver.findElement(By.xpath(MainLocation + "[" + RandomElement + "]" + RestLocation)).click();
        }
    }

    public void SelectRandomSelectListOption(String Locator) throws IOException {
        // Check Select List Options exist or not
        List<WebElement> SelectListOptions = driver.findElements(By.xpath(Locator + "/option"));
        int OptionsNumber = SelectListOptions.size();
        int TotalOptionsNumber = OptionsNumber - 1;
        if(TotalOptionsNumber > 0) {
            // Access Random Option
            int RandomOption = RandomIntegerNumber(TotalOptionsNumber);
            // Select Random Option
            new Select(driver.findElement(By.xpath(Locator))).selectByIndex(RandomOption);
        }
    }

    public int RandomIntegerNumberBetweenRange(int Max, int Min) throws IOException {
        Random random = new Random();
        int number = random.nextInt(Max - Min) + 6;
        return number;
    }

    public int[] ManyRandomIntegerNumber(int Max, int NumberOfInteger) throws IOException {
        Random random = new Random();
        // HashSet class used to get unique values.
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < NumberOfInteger) {
            set.add(random.nextInt(Max) + 1);
        }
        // Assign Integer object value to primitive type int variable.
        int[] number = new int[set.size()];
        int i = 0;
        for (Integer val : set) {
            number[i++] = val;
        }
        return number;
    }

    public int RandomIntegerNumber(int Max) throws IOException {
        Random random = new Random();
        // If Max have 5 than random number return from 0 to 4, So add 1.
        int number = random.nextInt(Max) + 1;
        return number;
    }

    public Double RandomDecimalNumber(int Max) throws IOException {
        Double DecimalNumber = .5;
        Random random = new Random();
        Double number = Double.valueOf(random.nextInt(Max) + 1) * DecimalNumber;
        return number;
    }

    public String[] RandomWords(int NumberOfWords) throws IOException {
        String[] randomStrings = new String[NumberOfWords];
        Random random = new Random();
        for(int i = 0; i < NumberOfWords; i++) {
            // Length of array get through nextInt() method.
            char[] word = new char[random.nextInt(8)];
            for(int j = 0; j < word.length; j++) {
                // Character for word get through Typecast.
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }
}
