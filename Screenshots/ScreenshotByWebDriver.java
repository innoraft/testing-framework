package Testing;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by om on 1/7/2015.
 */
public class ScreenshotByWebDriver {
    ScreenshotFunctions func;

    @Test
    public void testFirst() throws IOException {
        String Path = "Desktop";
        String BaseUrl = "http://testhcld7.innoraft.com";
        String file_url[][] = new String[][]{
                {"About Us_About HCL Technologies","" + BaseUrl + "/about-us/about-hcl-technologies"},
                {"About Us_About HCL Enterprise","" + BaseUrl + "/about-us/about-hcl-enterprise"},
                {"About Us_Vision & Mission","" + BaseUrl + "/about-us/value-statements"},
                {"About Us_Leadership","" + BaseUrl + "/about-us/leadership/board-of-directors"}
        };

        func = new ScreenshotFunctions();
        func.TestOnChrome();
        func.OnBrowsersByWebDriver(file_url, Path + "\\Chrome\\");
        func.TestOnFirefox();
        func.OnBrowsersByWebDriver(file_url, Path + "\\Firefox\\");
        func.TestOnInternetExplorer();
        func.OnBrowsersByWebDriver(file_url, Path + "\\IE\\");
    }
}
