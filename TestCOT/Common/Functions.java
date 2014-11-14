package TestCOT.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;

/**
 * Created by om on 11/12/2014.
 */
public class Functions {
    private WebDriver driver;

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
            UserName = "basant.sharma@gmail.com";
            Password = "password";
        } else if (Role.equals("Teacher")) {
            UserName = "mukesh.agarwal@gmail.com";
            Password = "password";
        } else if (Role.equals("SchoolAdmin")) {
            UserName = "akashjain132@gmail.com";
            Password = "password";
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
        driver.findElement(By.id("edit-submit--7")).click();
    }

    public int RandomIntegerNumber(int Max) throws IOException {
        Random random = new Random();
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
