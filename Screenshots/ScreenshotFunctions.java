package Testing;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 * Created by om on 1/7/2015.
 */
public class ScreenshotFunctions {
    private String Password = "password";
    private String Username = "dummy7@gmail.com";
    private String BasePath = "C:\\Users\\om\\Downloads\\";
    private WebDriver driver;
    private WebDriverWait wait;
    private int timeoutOfOneElement = 80;
    private int timeoutOFAllElement = 15;
    private String ChromeDriverPath = "C:\\Users\\om\\Downloads\\Programs\\Selenium\\chromedriver.exe";
    private String IEDriverPath = "C:\\Users\\om\\Downloads\\Programs\\Selenium\\IEDriverServer.exe";

    // To run test on Chrome browser
    public void TestOnChrome() throws IOException {
        // Disable the "unsupported flag" prompt, it affect the window size.
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(timeoutOFAllElement, TimeUnit.SECONDS);
    }

    // To run test on Firefox browser
    public void TestOnFirefox() throws IOException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeoutOFAllElement, TimeUnit.SECONDS);
    }

    // To run test on Internet Explorer browser
    public void TestOnInternetExplorer() throws IOException {
        System.setProperty("webdriver.ie.driver", IEDriverPath);
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeoutOFAllElement, TimeUnit.SECONDS);
    }

    // To take screenshots through webdriver
    public void OnBrowsersByWebDriver(String[][] file_url, String path) throws IOException {
        String filename = null;
        String url = null;

        String list[] = new String[2];
        for(int i=0; i<file_url.length; i++) {
            for(int j=0; j<2; j++) {
                list[j]  = file_url[i][j];
            }
            filename = list[0];
            url = list[1];

            driver.get(url);
            File screen = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screen, new File(BasePath + path + filename + ".png"));
        }
    }

    // To login the BrowserStack site.
    public void LoginBrowserStack(String[][] Browsers) throws IOException {
        TestOnChrome();
        // Wait for particular element to load.
        wait = new WebDriverWait(driver, timeoutOfOneElement);

        // Reach at snapshot page.
        driver.get("http://www.browserstack.com/users/sign_in");
        driver.findElement(By.id("user_email_login")).clear();
        driver.findElement(By.id("user_email_login")).sendKeys(Username);
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys(Password);
        driver.findElement(By.id("user_submit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Account")));
        driver.findElement(By.linkText("SCREENSHOTS")).click();

        // Select browsers
        SetBrowsersOnBrowserStack(Browsers);
    }

    // To take screenshots through BrowserStack
    public void OnBrowsersByBrowserStack(String[][] file_url, String SiteLevel, String Path) throws IOException {
        String filename = null;
        String url = null;

        String list[] = new String[2];
        for(int i=0; i<file_url.length; i++) {
            for(int j=0; j<2; j++) {
                list[j]  = file_url[i][j];
            }
            filename = list[0].replace(" ", "").replace("&", "and");
            url = list[1];

            // Take snapshot.
            driver.findElement(By.id("screenshots")).clear();
            driver.findElement(By.id("screenshots")).sendKeys(url);
            driver.findElement(By.id("btnSnapshot")).click();

            /*
            TODO: Wait for "Zipping" and if "Zipping" appear with "1 time out" text than call a function for again enter
            TODO: click snapshot button through driver.
            */
            // Driver will wait until text 'ZIPPING' not present at element by id 'zipper'.
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("zipper"), "ZIPPING"));

            // Click download link to save file.
            List<WebElement> DownloadLink = driver.findElements(By.xpath("//a[contains(@class, 'icon-sp-dl')]"));
            for (int k = 0; k < DownloadLink.size(); k++) {
                DownloadLink.get(k).click();
            }

            // Check download process finish.
            File[] files = check_download_finish();

            // Rename image files.
            String[] changeFileName = rename_image_files(filename, files, SiteLevel);

            // Cut all files and paste into new folder.
            cut_and_paste_files(filename, Path);

            // Change width of images.
            //change_width(changeFileName, filename, Path);

            // Click arrow symbol ^ to click screenshot button .
            driver.findElement(By.cssSelector("a.sp-more-arrow.up")).click();
        }
    }

    // To logout from the BrowserStack site.
    public void LogoutBrowserStack() throws IOException {
        driver.findElement(By.linkText("Account")).click();
        driver.findElement(By.linkText("Sign out")).click();
    }

    // Select the browsers on that screenshots should be taken.
    private void SetBrowsersOnBrowserStack(String[][] Browsers) throws IOException {
        // Deselect these browsers, which are in selected state by default.
        List<WebElement> DeselectBrowser = driver.findElements(By.xpath("//a[@class='pull-left version sel']"));
        for (int k = 0; k < DeselectBrowser.size(); k++) {
            DeselectBrowser.get(k).click();
        }

        String os = null;
        String browser = null;
        String os_version = null;
        String browser_version = null;

        // Browsers on that screenshot should be taken.
        String list[] = new String[4];
        for(int i=0; i<Browsers.length; i++) {
            for(int j=0; j<4; j++) {
                list[j]  = Browsers[i][j];
            }
            os = list[0];
            os_version = list[1];
            browser = list[2];
            browser_version = list[3];
            driver.findElement(By.xpath("//a[@os='" + os + "'][@os_version='" + os_version + "'][@browser='" + browser + "'][@browser_version='" + browser_version + "']")).click();
        }
    }

    // Wait for download completion of screenshots.
    private File[] check_download_finish() throws IOException {
        File[] listOfFiles;
        // Loop will continue till the download process of files complete.
        for (; ; ) {
            // List only those files that have extension “.png” and “.jpg”.
            FilenameFilter fileNameFilter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if (name.lastIndexOf('.') > 0) {
                        // get last index for '.' char
                        int lastIndex = name.lastIndexOf('.');
                        // get extension
                        String str = name.substring(lastIndex);
                        // match path name extension
                        if (str.equals(".jpg")) {
                            return true;
                        }
                        if (str.equals(".png")) {
                            return true;
                        }
                    }
                    return false;
                }
            };
            // File object representing the directory on the disk.
            File folder = new File(BasePath);
            // Returns the array of files of particular extensions.
            listOfFiles = folder.listFiles(fileNameFilter);

            /*
            TODO: Wait for some defined time for 5 snapshot and if 5 snapshot not downloaded in that time than
            TODO: call a function for again click the download link of image which are not created.
            */
            // If any file have "crdownload" text in name, it means download process not complete.
            if (listOfFiles.length == 5) {
                int flag = 1;
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].getName().contains("crdownload"))
                        flag = 0;
                }
                if (flag == 1) {
                    break;
                }
            }
            System.out.println("Waiting");
        }
        return listOfFiles;
    }

    // Change name of screenshots according to screenshot comparison criteria.
    private String[] rename_image_files(String filename, File[] files, String SiteLevel) throws IOException {
        String changeFileName[] = new String[2];
        //TreeSet<Integer> unique = new TreeSet<Integer>();

        for (int i=0 ; i < files.length ; i++){
            String window_Browser_Version = files[i].getName().substring(0, files[i].getName().indexOf(".")).replace("_", "");

            // To get the width of image.
            //BufferedImage readImage = ImageIO.read(files[i]);
            //int width = readImage.getWidth();

            // This code utilized when taking another snapshots.
            //if(!unique.add(width)){
            //    changeFileName[0] = window_Browser_Version;
            //    changeFileName[1] = Integer.toString(width);
            //}

            files[i].renameTo(new File(BasePath + filename + "_" + window_Browser_Version + SiteLevel + ".png"));
        }
        return changeFileName;
    }

    // Cut the screenshots files and paste into newly created directory or into existing directory and replace the existing screenshots.
    private void cut_and_paste_files(String filename, String Path) throws IOException {
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
        File folder = new File(BasePath);
        // Returns the array of files of particular extensions.
        File[] listOfFiles = folder.listFiles(fileNameFilter);

        // To create the directory.
        File dir = new File(BasePath + Path + filename);
        if (!dir.exists()) {
            dir.mkdir();
        }

        for (int i=0 ; i < listOfFiles.length ; i++){
            // To construct the path of file.
            Path original = Paths.get(BasePath + listOfFiles[i].getName());
            Path destination = Paths.get(BasePath + Path + "\\" + filename + "\\" + listOfFiles[i].getName());
            // To move file from one directory to another and if same name file exist in directory than it will replace.
            Files.move(original, destination, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    /**
     * In gallery, images are display in group of two-two according to width in image name. If four or more images have equal width 
     * in their name than they will not display properly. So, it required to change the width in image name.
     */
    private void change_width(String[] browserToChangeWidth, String fileName, String Path) throws IOException {
        // File object representing the directory on the disk.
        File folder = new File(BasePath + Path + "\\" + fileName);
        // Returns the array of files.
        File[] listOfFiles = folder.listFiles();

        /**
         * Width of two images of one browser will change through array "browserToChangeWidth". IT contains two value,
         * one is browserName to locate the browser and another is width that a new value for width.
         */
        if(listOfFiles.length == 10) {
            for (int i=0 ; i < listOfFiles.length ; i++){
                if(listOfFiles[i].getName().contains(browserToChangeWidth[0])) {
                    listOfFiles[i].renameTo(new File(BasePath + Path + "\\" + fileName + "\\" + listOfFiles[i].getName().replace(browserToChangeWidth[1], String.valueOf(Integer.parseInt(browserToChangeWidth[1]) + 1))));
                }
            }
        }
    }

    public void Folder_Setup() throws IOException {
        String Sitelevel1 = "Test";
        String Sitelevel2 = "ML";
        String Site = "HCL";
        String Path = "Screenshots\\" + Site + "\\";

        File ScreenshotComparisionDirectory = new File(BasePath + Path + Site + "_" + Sitelevel1 + "_" + Sitelevel2);
        ScreenshotComparisionDirectory.mkdir();

        File Sitelevel1Folder = new File(BasePath + Path + Sitelevel1);
        File Sitelevel2Folder = new File(BasePath + Path + Sitelevel2);
        File[] Sitelevel1FolderListOfFiles = Sitelevel1Folder.listFiles();
        File[] Sitelevel2FolderListOfFiles = Sitelevel2Folder.listFiles();

        if (Sitelevel1FolderListOfFiles.length >= Sitelevel2FolderListOfFiles.length) {
            for (int i=0 ; i < Sitelevel1FolderListOfFiles.length ; i++){
                File ScreenshotDirectory = new File(BasePath + Path + Site + "_" + Sitelevel1 + "_" + Sitelevel2 + "\\" + Sitelevel1FolderListOfFiles[i].getName());
                ScreenshotDirectory.mkdir();

                File[] SiteLevel1FolderFiles = Sitelevel1FolderListOfFiles[i].listFiles();
                File[] SiteLevel2FolderFiles = Sitelevel2FolderListOfFiles[i].listFiles();

                if (SiteLevel1FolderFiles.length == SiteLevel2FolderFiles.length) {
                    System.out.println(SiteLevel1FolderFiles.length);
                    System.out.println(SiteLevel1FolderFiles.length);
                    for (int j=0 ; j < SiteLevel1FolderFiles.length ; j++){
                        // To construct the path of file.
                        Path original = Paths.get(BasePath + Path + Sitelevel1 + "\\" + Sitelevel1FolderListOfFiles[j].getName() + "\\" + SiteLevel1FolderFiles[j].getName());
                        Path destination = Paths.get(BasePath + Path + Site + "_" + Sitelevel1 + "_" + Sitelevel2 + "\\" + Sitelevel1FolderListOfFiles[j].getName() + "\\" + SiteLevel1FolderFiles[j].getName());
                        // To move file from one directory to another and if same name file exist in directory than it will replace.
                        Files.move(original, destination, StandardCopyOption.REPLACE_EXISTING);
                    }
                    for (int k=0 ; k < SiteLevel1FolderFiles.length ; k++){
                        // To construct the path of file.
                        Path original = Paths.get(BasePath + Path + Sitelevel2 + "\\" + Sitelevel2FolderListOfFiles[k].getName() + "\\" + SiteLevel2FolderFiles[k].getName());
                        Path destination = Paths.get(BasePath + Path + Site + "_" + Sitelevel1 + "_" + Sitelevel2 + "\\" + Sitelevel1FolderListOfFiles[k].getName() + "\\" + SiteLevel1FolderFiles[k].getName());
                        // To move file from one directory to another and if same name file exist in directory than it will replace.
                        Files.move(original, destination, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
        } else {

        }
    }
}
