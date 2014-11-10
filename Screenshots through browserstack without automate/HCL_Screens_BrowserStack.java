/*
 1. Record through Selenium IDE, that how we will take take screenshot from browserstack and save screenshot on system by click the download link.
 2. Copy the code provided from selenium IDE and paste into Intellij IDEA java class.
 Do some programming in java:-
 3.1. Wait for all the screenshot took.
 3.2. Wait for download process to complete so that work can be done on screenshot like rename the screenshot, Moving the screenshot.
 3.3. Identify the .jpg and .png files and rename them.
 3.4. Create a new folder with name, specify for the url of which screenshot has been taken, Cut all the screenshot and paste into the newly created folder.
 3.5. Check If four images have equal width than change the width of two images of one browser, for properly display the images in gallery.
 */

/*
For another five snapshot, change in these codes.
1. Change base url.
2. Change Live or Test in filename.
3. Change make directory code.
 */

package Testing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.TreeSet;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.InterfaceImplementation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;

public class HCL_Screens_BrowserStack {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        // Disable the "unsupported flag" prompt, it affect the window size.
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\om\\Downloads\\Programs\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 400);
        baseUrl = "http://www.browserstack.com/";
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

        // Reach at snapshot page.
        driver.get(baseUrl + "/users/sign_in");
        driver.findElement(By.id("user_email_login")).clear();
        driver.findElement(By.id("user_email_login")).sendKeys("basant.cse@gmail.com");
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.id("user_submit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Account")));
        driver.findElement(By.linkText("SCREENSHOTS")).click();
    }

    @Test
    public void testFirst() throws IOException {
        //About_Us_urls();
        Aerospace_urls();

        driver.findElement(By.linkText("Account")).click();
        driver.findElement(By.linkText("Sign out")).click();
    }

    private void About_Us_urls() throws IOException {
        String filename = null;
        String url = null;

        String file_url[][] = new String[][]{
//                {"About Us","http://testhcld7.innoraft.com/about-us"},
//                {"About Us_About HCL Technologies","http://testhcld7.innoraft.com/about-us/about-hcl-technologies"},
//                {"About Us_About HCL Enterprise","http://testhcld7.innoraft.com/about-us/about-hcl-enterprise"},
//                {"About Us_Vision & Mission","http://testhcld7.innoraft.com/about-us/value-statements"},
//                {"About Us_Leadership","http://testhcld7.innoraft.com/about-us/leadership/board-of-directors"},
//                {"About Us_Leadership_Executive Profiles","http://testhcld7.innoraft.com/about-us/leadership/executive-profiles"},
//                {"About Us_Leadership_Board of Directors","http://testhcld7.innoraft.com/about-us/leadership/board-of-directors"},
//                {"About Us_Governance","http://testhcld7.innoraft.com/about-us/corporate-governance"},
//                {"About Us_Governance_Governance Policies","http://testhcld7.innoraft.com/about-us/corporate-governance/governance-policies"},
//                {"About Us_Alliances","http://testhcld7.innoraft.com/about-us/alliances"},
//                {"About Us_Alliances_Microsoft Alliance","http://testhcld7.innoraft.com/about-us/microsoft-alliance"},
//                {"About Us_Alliances_Microsoft Alliance_GamEdge","http://testhcld7.innoraft.com/about-us/gamedge"},
//                {"About Us_Alliances_Microsoft Alliance_EmpoweRetail CRM for Retailers","http://testhcld7.innoraft.com/about-us/empoweretail-crm-retailers"},
//                {"About Us_Alliances_Microsoft Alliance_FinEdge","http://testhcld7.innoraft.com/about-us/finedge"},
//                {"About Us_Recognitions","http://testhcld7.innoraft.com/about-us/awards-recognitions"},
//                {"About Us_Socially Responsible Business","http://testhcld7.innoraft.com/socially-responsible-business"}
        };

        String list[] = new String[2];
        for(int i=0; i<5; i++) {
            for(int j=0; j<2; j++) {
                list[j]  = file_url[i][j];
            }
            filename = list[0];
            url = list[1];
            output(filename, url);
        }
    }

    private void Aerospace_urls() throws IOException {
        String filename = null;
        String url = null;

        String file_url[][] = new String[][]{
//                {"Aerospace & Defense","http://testhcld7.innoraft.com/aerospace-and-defense"},
                {"Aerospace & Defense_Overview","http://testhcld7.innoraft.com/aerospace-and-defense"},
//                {"Aerospace & Defense_Market Segments","http://testhcld7.innoraft.com/aerospace-and-defense/market-segments"},
//                {"Aerospace & Defense_Market Segments_Defense, Space & Security","http://testhcld7.innoraft.com/aerospace-defense/defense-space-security"},
                {"Aerospace & Defense_Service Portfolio","http://testhcld7.innoraft.com/aerospace-and-defense/service-portfolio"},
//                {"Aerospace & Defense_Service Portfolio_Avionics","http://testhcld7.innoraft.com/aerospace-and-defense/avionics"},
//                {"Aerospace & Defense_Service Portfolio_Avionics_Overview","http://testhcld7.innoraft.com/aerospace-and-defense/avionics"},
//                {"Aerospace & Defense_Service Portfolio_Avionics_Hardware Product Engineering","http://testhcld7.innoraft.com/aerospace-defense/avionics/hardware-product-engineering"},
//                {"Aerospace & Defense_Service Portfolio_Avionics_Software Product Engineering","http://testhcld7.innoraft.com/aerospace-defense/avionics/software-product-engineering"},
                {"Aerospace & Defense_Service Portfolio_Avionics_IT Applications","http://testhcld7.innoraft.com/aerospace-and-defense/it-applications"},
//                {"Aerospace & Defense_Service Portfolio_Avionics_Manufacturing Services","http://testhcld7.innoraft.com/aerospace-and-defense/manufacturing-services"},
//                {"Aerospace & Defense_Service Portfolio_Avionics_Test Engineering Services","http://testhcld7.innoraft.com/aerospace-defense/avionics/test-engineering-services"},
//                {"Aerospace & Defense_Service Portfolio_Engineering Design","http://testhcld7.innoraft.com/aerospace-and-defense/engineering-design"},
                {"AerospaceandDefense_ServicePortfolio_EngineeringDesign_Mechanical","http://testhcld7.innoraft.com/aerospace-and-defense/engineering-design/mechanical-engineering-lifecycle-services-aerospace-companies"},
//                {"Aerospace & Defense_Service Portfolio_Technical Publication Services","http://testhcld7.innoraft.com/aerospace-and-defense/technical-publication-services"},
//                {"Aerospace & Defense_Solutions & Frameworks","http://testhcld7.innoraft.com/aerospace-and-defense/solutions-frameworks"},
                {"Aerospace & Defense_Solutions & Frameworks_iMRO","http://testhcld7.innoraft.com/aerospace-and-defense/imro"}
//                {"Aerospace & Defense_Solutions & Frameworks_Boundary Scan Resource Unit (BSRU)","http://testhcld7.innoraft.com/aerospace-defense/boundary-scan-resource-unit-bsru"},
//                {"Aerospace & Defense_Solutions & Frameworks_Enhanced Vision System","http://testhcld7.innoraft.com/aerospace-and-defense/enhanced-vision-system"},
//                {"Aerospace & Defense_Solutions & Frameworks_gTESTER-100 - Tester for Analog and Digital PWAs","http://testhcld7.innoraft.com/aerospace-and-defense/gtester-100-tester-analog-and-digital-pwas"},
//                {"Aerospace & Defense_Solutions & Frameworks_Reusable Test Executive Software","http://testhcld7.innoraft.com/aerospace-and-defense/reusable-test-executive-software"},
//                {"Aerospace & Defense_Global Engineering Hub","http://testhcld7.innoraft.com/aerospace-and-defense/global-engineering-hub"},
//                {"Aerospace & Defense_Partnerships & Alliances","http://testhcld7.innoraft.com/aerospace-and-defense/partnerships-alliances"},
//                {"Aerospace & Defense_Customer Testimonials","http://testhcld7.innoraft.com/aerospace-and-defense/customer-testimonials"},
//                {"AerospaceandDefense_ResourceLibrary_Brochures","http://testhcld7.innoraft.com/resources/brochure?asmSelect0=Select%2Ba%2BValue&asmSelect1=Select%2Ba%2BValue&tid_1%255B%255D=7"},
//                {"AerospaceandDefense_ResourceLibrary","http://testhcld7.innoraft.com/resources/all?asmSelect0=Select%2Ba%2BValue&asmSelect1=Select%2Ba%2BValue&tid_1%255B%255D=7"},
//                {"AerospaceandDefense_ResourceLibrary_CaseStudies","http://testhcld7.innoraft.com/resources/success_story?asmSelect0=Select%2Ba%2BValue&asmSelect1=Select%2Ba%2BValue&tid_1%255B%255D=7"},
//                {"AerospaceandDefense_ResourceLibrary_NewsandMedia","http://testhcld7.innoraft.com/media/all?tid_2=All&asmSelect0=Select%20a%20Value&asmSelect1=Select%20a%20Value&tid_1%5B0%5D=7"},
//                {"AerospaceandDefense_ResourceLibrary_WhitePapers","http://testhcld7.innoraft.com/resources/whitepaper?asmSelect0=Select%2Ba%2BValue&asmSelect1=Select%2Ba%2BValue&tid_1%255B%255D=7"}
        };

        String list[] = new String[2];
        for(int i=0; i<5; i++) {
            for(int j=0; j<2; j++) {
                list[j]  = file_url[i][j];
            }
            filename = list[0];
            url = list[1];
            output(filename.replace(" ", "").replace("&", "and"), url);
        }
    }

    private void output(String filename, String url) throws IOException {
        // Take snapshot.
        driver.findElement(By.id("screenshots")).clear();
        driver.findElement(By.id("screenshots")).sendKeys(url);
        driver.findElement(By.id("btnSnapshot")).click();

        // Driver will wait until text 'ZIPPING' not present at element by id 'zipper'.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("zipper"), "ZIPPING"));

        // Click download link to save file.
        driver.findElement(By.xpath("//li/div/a[2]")).click();
        driver.findElement(By.xpath("//li[2]/div/a[2]")).click();
        driver.findElement(By.xpath("//li[3]/div/a[2]")).click();
        driver.findElement(By.xpath("//li[4]/div/a[2]")).click();
        driver.findElement(By.xpath("//li[5]/div/a[2]")).click();

        // Check download process finish.
        File[] files = check_download_finish();

        // Rename image files.
        String[] changeFileName = rename_image_files(filename, files);

        // Cut all files and paste into new folder.
        cut_and_paste_files(filename);

        // Change width of images.
        change_width(changeFileName, filename);

        driver.findElement(By.cssSelector("a.sp-more-arrow.up")).click();
    }

    private File[] check_download_finish() throws IOException {
        File[] files = null;
        // Loop will continue till the download process of files complete.
        for(;;) {
            // List only those files that have extension “.png” and “.jpg”.
	    // TODO: FileNameFilter class.
            FilenameFilter fileNameFilter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if(name.lastIndexOf('.')>0) {
                        // get last index for '.' char
                        int lastIndex = name.lastIndexOf('.');
                        // get extension
                        String str = name.substring(lastIndex);
                        // match path name extension
                        if(str.equals(".jpg")) {
                            return true;
                        }
                        if(str.equals(".png")) {
                            return true;
                        }
                    }
                    return false;
                }
            };
            // File object representing the directory on the disk.
            File folder = new File("C:\\Users\\om\\Downloads");
            // Returns the array of files of particular extensions.
            File[] listOfFiles = folder.listFiles(fileNameFilter);

            // If any file have "crdownload" text in name, it means download process not complete.
            if(listOfFiles.length == 5) {
                int flag = 1;
                for (int i = 0 ; i < listOfFiles.length ; i++) {
                    if(!listOfFiles[i].getName().contains("crdownload"))
                        flag = 1;
                    else
                        flag = 0;
                }
                if(flag == 1) {
                    files = listOfFiles;
                    break;
                }
            }
            System.out.println("Waiting");
        }
        return files;
    }

    private String[] rename_image_files(String filename, File[] files) throws IOException {
        String same_width = null;
        String changeFileName[] = new String[2];
        TreeSet<Integer> unique = new TreeSet<Integer>();

        for (int i=0 ; i < files.length ; i++){
            // TODO: Study indexOf() method.
            String window_Browser_Version = files[i].getName().substring(0, files[i].getName().indexOf(".")).replace("_", "");
            // If four images have equal width than group the two-two images by specify the browser name and version in image name.
            String s1 = files[i].getName().substring(files[i].getName().indexOf("_") + 1);
            String s2 = s1.substring(0, s1.indexOf("."));
            String browser_Version = s2.replace("_", "");

            // To get the width of image.
            BufferedImage readImage = ImageIO.read(files[i]);
            int width = readImage.getWidth();

            // This code utilized when taking another snapshots.
            if(same_width == null) {
                if(!unique.add(width)){
                    same_width = Integer.toString(width);
                    changeFileName[0] = browser_Version;
                    changeFileName[1] = same_width;
                }
            }

            files[i].renameTo(new File("C:\\Users\\om\\Downloads\\" + width + filename + "_" + browser_Version + "_" + "Test" + window_Browser_Version + ".png"));
        }
        return changeFileName;
    }

    private void cut_and_paste_files(String filename) throws IOException {
        // List only those renamed files that have extension “.png” and “.jpg”.
        FilenameFilter fileNameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.lastIndexOf('.')>0) {
                    // get last index for '.' char
                    int lastIndex = name.lastIndexOf('.');
                    // get extension
                    String str = name.substring(lastIndex);
                    // match path name extension
                    if(str.equals(".jpg")) {
                        return true;
                    }
                    if(str.equals(".png")) {
                        return true;
                    }
                }
                return false;
            }
        };
        // File object representing the directory on the disk.
        File folder = new File("C:\\Users\\om\\Downloads");
        // Returns the array of files of particular extensions.
        File[] listOfFiles = folder.listFiles(fileNameFilter);

        // To create the directory.
        File dir = new File("C:\\Users\\om\\Downloads\\" + filename);
        dir.mkdir();
        for (int i=0 ; i < listOfFiles.length ; i++){
            // To construct the path of file.
            Path original = Paths.get("C:\\Users\\om\\Downloads\\" + listOfFiles[i].getName());
            Path destination = Paths.get("C:\\Users\\om\\Downloads\\" + filename + "\\" + listOfFiles[i].getName());
            // To move the file from one directory to another and replace the same name existing file.
            Files.move(original, destination, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private void change_width(String[] browserToChangeWidth, String fileName) throws IOException {
        // File object representing the directory on the disk.
        File folder = new File("C:\\Users\\om\\Downloads\\" + fileName);
        // Returns the array of files of particular extensions.
        File[] listOfFiles = folder.listFiles();

        /**
         * Width of two images of one browser will change through array "browserToChangeWidth". IT contains two value,
         * one is browserName to locate the browser and another is width that new value for width.
         */
        if(listOfFiles.length == 10) {
            for (int i=0 ; i < listOfFiles.length ; i++){
                if(listOfFiles[i].getName().contains(browserToChangeWidth[0])) {
                    System.out.println(browserToChangeWidth[1]);
                    listOfFiles[i].renameTo(new File("C:\\Users\\om\\Downloads\\" + fileName + "\\" + listOfFiles[i].getName().replace(browserToChangeWidth[1], String.valueOf(Integer.parseInt(browserToChangeWidth[1]) + 1))));
                }
            }
        }
    }

    @After
    public void tearDown() throws Exception {
//        driver.quit();
        Thread.sleep(5000);
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
