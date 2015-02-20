package Frameworks.KeywordDriven;

import Testing.CommonFunction;
import Testing.HCL.HCLFunctions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.*;
import org.apache.poi.openxml4j.opc.Package;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

/**
 * Created by om on 2/18/2015.
 */
public class ExecuteTest {
    UIOperation func;
    WebDriver driver;
    WebDriverWait wait;
    int timeoutOfOneElement = 15;
    int timeoutOFAllElement = 10;
    String SheetName = "Sheet1";
    String ExcelFilePath = "C:\\Users\\om\\Downloads\\Book1.xlsx";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, timeoutOfOneElement);
        func = new UIOperation(driver, wait);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeoutOFAllElement, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() throws Exception {
        // Read excel file
        FileInputStream FileInput = new FileInputStream(ExcelFilePath);
        XSSFWorkbook ExcelWBook = new XSSFWorkbook(Package.open(FileInput));
        XSSFSheet ExcelWSheet = ExcelWBook.getSheet(SheetName);

        // Declare variables to utilize
        XSSFRow Row = null;
        XSSFCell Cell = null;
        XSSFRow TestCaseRow = null;
        XSSFCell TestCaseCell= null;
        int TestCaseFirstRow = 0;
        int TestCaseLastRow = 0;
        int RowNum = ExcelWSheet.getLastRowNum() + 1;
        int ColNum = ExcelWSheet.getRow(0).getLastCellNum();

        // Read excel row one by one
        for (int i = 1 ; i < RowNum ; i++) {
            Row = ExcelWSheet.getRow(i);
            // Check value in row exist or not
            if (Row != null) {
                Cell = Row.getCell(0);
                // Check value in first column exist or not
                if (Cell != null) {
                    // Get first row number for further use.
                    TestCaseFirstRow = i;
                    String[][] Data = new String[RowNum][ColNum];
                    // Read test case row
                    for (int j = i ; j < RowNum ; j++) {
                        TestCaseRow = ExcelWSheet.getRow(j);
                        // Read test case rows until null not found
                        if (TestCaseRow != null) {
                            for (int k = 2 ; k < ColNum ; k++) {
                                TestCaseCell = TestCaseRow.getCell(k);
                                // Fill excel data in 2-D array
                                if (TestCaseCell != null) {
                                    Data[j][k] = cellToString(TestCaseCell);
                                } else {
                                    Data[j][k] = "";
                                }
                            }
                            // Get Last row number for further use.
                            TestCaseLastRow = j;
                        } else {
                            // Assign next test case row number
                            i = j;
                            break;
                        }
                    }
                    // Read 2-D array row one by one
                    for (int m = TestCaseFirstRow ; m <= TestCaseLastRow ; m++) {
                        try {
                            // Call perform function to execute test case row
                            func.Perform(Data[m][2], Data[m][3], Data[m][4], Data[m][5]);
                            // Change color of cell of that row where previously error occurred
                            TestCasePass(m);
                        } catch (Exception e) {
                            // Change color of cell of that row in which error occurred
                            TestCaseFail(m);
                            // To not execute further rows of test case
                            break;
                        }
                    }
                }
            }
        }
    }

    public static String cellToString(Cell cell){
        Object Result;

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                Result = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Result = cell.getDateCellValue();
                } else {
                    Result = (int) cell.getNumericCellValue();
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                Result = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_FORMULA:
                Result = cell.getCellFormula();
                break;
            default:
                throw new RuntimeException("No support for this type of cell");
        }

        return Result.toString();
    }

    private void TestCasePass(int m) throws IOException, InvalidFormatException {
        // Read excel file
        FileInputStream FileInput = new FileInputStream(ExcelFilePath);
        XSSFWorkbook ExcelWBook = new XSSFWorkbook(Package.open(FileInput));
        XSSFSheet ExcelWSheet = ExcelWBook.getSheet(SheetName);

        // Set Cell Color
        XSSFCellStyle Style = ExcelWBook.createCellStyle();
        Style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        Style.setFillForegroundColor(new XSSFColor(Color.WHITE));

        XSSFRow Row = null;
        XSSFCell Cell = null;
        Row = ExcelWSheet.getRow(m);
        Cell = Row.getCell(3);
        if (Cell == null)
            Cell = Row.createCell(3);
        Cell.setCellStyle(Style);

        // Write into excel file
        FileOutputStream FileOutput = new FileOutputStream(ExcelFilePath);
        ExcelWBook.write(FileOutput);
        FileOutput.close();
    }

    private void TestCaseFail(int m) throws IOException, InvalidFormatException {
        // Read excel file
        FileInputStream FileInput = new FileInputStream(ExcelFilePath);
        XSSFWorkbook ExcelWBook = new XSSFWorkbook(Package.open(FileInput));
        XSSFSheet ExcelWSheet = ExcelWBook.getSheet(SheetName);

        // Set Cell Color
        XSSFCellStyle Style = ExcelWBook.createCellStyle();
        Style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        Style.setFillForegroundColor(new XSSFColor(Color.RED));

        XSSFRow Row = null;
        XSSFCell Cell = null;
        Row = ExcelWSheet.getRow(m);
        Cell = Row.getCell(3);
        if (Cell == null)
            Cell = Row.createCell(3);
        Cell.setCellStyle(Style);

        // Write into excel file
        FileOutputStream FileOutput = new FileOutputStream(ExcelFilePath);
        ExcelWBook.write(FileOutput);
        FileOutput.close();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
