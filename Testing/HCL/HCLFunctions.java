package Testing.HCL;

import org.apache.poi.openxml4j.opc.Package;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

import static junit.framework.Assert.assertTrue;

/**
 * Created by om on 11/12/2014.
 */
public class HCLFunctions {
    private WebDriver driver;
    private WebDriverWait wait;
    public int timeoutOfOneElement = 15;
    public int timeoutOFAllElement = 10;
    public String baseUrl = "http://demoaws.innoraft.com";
    private String SheetName = "ContentType";
    private String ExcelFilePath = "C:\\Users\\om\\Downloads\\Screenshots\\HCLTestCases.xlsx";

    public HCLFunctions(WebDriver driver) {
        this.driver = driver;
    }

    public void CheckLogin() throws IOException {
        if(!isElementPresent(By.linkText("Login"))) {
            driver.findElement(By.linkText("Log out")).click();
        }
    }

    public boolean isElementPresent(By by) {
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

        if (Role.equals("Anonymous")) {
            UserName = "";
            Password = "";
        } else if (Role.equals("Admin")) {
            UserName = "admin";
            Password = "admin";
        } else if (Role.equals("")) {
            UserName = "";
            Password = "";
        }
        Login(UserName, Password);
    }

    public void Login(String UserName, String Password) throws IOException {
        wait = new WebDriverWait(driver, timeoutOfOneElement);
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'form-item-name')]//input")).clear();
        driver.findElement(By.xpath("//div[contains(@class, 'form-item-name')]//input")).sendKeys(UserName);
        driver.findElement(By.xpath("//div[contains(@class, 'form-item-pass')]//input")).clear();
        driver.findElement(By.xpath("//div[contains(@class, 'form-item-pass')]//input")).sendKeys(Password);
        driver.findElement(By.xpath("//form[@id='user-login-form']//input[@type='submit']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//form[@id='user-login-form']//input[@type='submit']")));
    }

    public void SetResultPass(String TestCase) throws Exception {
        // Get different information
        String[] ExcelValues = new String[4];
        // Content Type
        String FileName = Thread.currentThread().getStackTrace()[2].getFileName();
        String ContentType = FileName.substring(0, FileName.indexOf("."));
        ExcelValues[0] = ContentType;
        // Operation
        String Operation = Thread.currentThread().getStackTrace()[2].getMethodName();
        ExcelValues[1] = Operation;
        // TestCase
        ExcelValues[2] = TestCase;
        // Result
        ExcelValues[3] = "Pass";

        // Store information in excel.
        FileInputStream ExcelFile = new FileInputStream(ExcelFilePath);
        XSSFWorkbook ExcelWBook = new XSSFWorkbook(Package.open(ExcelFile));
        XSSFSheet ExcelWSheet = ExcelWBook.getSheet(SheetName);

        int RowNumber = ExcelWSheet.getLastRowNum() + 1;
        XSSFRow Row = ExcelWSheet.createRow(RowNumber);
        for (int i = 0; i < 4; i++) {
            XSSFCell Cell = Row.createCell(i);
            Cell.setCellValue(ExcelValues[i]);
        }

        FileOutputStream fileOut = new FileOutputStream(ExcelFilePath);
        ExcelWBook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

    public void SetResultFail(String TestCase, Exception e) throws Exception {
        // Get stackTrace information
        StringWriter SW = new StringWriter();
        PrintWriter PW = new PrintWriter(SW);
        e.printStackTrace(PW);
        String StackTrace = SW.toString();

        // Get different information
        String[] ExcelValues = new String[7];
        // Content Type
        String FileName = Thread.currentThread().getStackTrace()[2].getFileName();
        String ContentType = FileName.substring(0, FileName.indexOf("."));
        ExcelValues[0] = ContentType;
        // Operation
        String Operation = Thread.currentThread().getStackTrace()[2].getMethodName();
        ExcelValues[1] = Operation;
        // Test Case
        ExcelValues[2] = TestCase;
        // Result
        ExcelValues[3] = "Fail";
        // Current Url
        String CurrentUrl = driver.getCurrentUrl();
        ExcelValues[4] = CurrentUrl;
        // Error
        String[] Error = StackTrace.split("Command");
        ExcelValues[5] = Error[0];

        // Error Location
        String[] Lines = StackTrace.split("\n");
        String ErrorLocation = null;
        for (int i = 0; i < Lines.length; i++) {
            if (Lines[i].contains(ContentType)) {
                ErrorLocation = Lines[i];
                break;
            }
        }
        ExcelValues[6] = ErrorLocation;

        // Store information in excel.
        FileInputStream ExcelFile = new FileInputStream(ExcelFilePath);
        XSSFWorkbook ExcelWBook = new XSSFWorkbook(Package.open(ExcelFile));
        XSSFSheet ExcelWSheet = ExcelWBook.getSheet(SheetName);

        int RowNumber = ExcelWSheet.getLastRowNum() + 1;
        XSSFRow Row = ExcelWSheet.createRow(RowNumber);
        for (int i = 0; i < 7; i++) {
            XSSFCell Cell = Row.createCell(i);
            Cell.setCellValue(ExcelValues[i]);
        }

        FileOutputStream fileOut = new FileOutputStream(ExcelFilePath);
        ExcelWBook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }
}
