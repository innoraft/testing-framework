package Testing;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by om on 1/7/2015.
 */
public class ScreenshotByBrowserStack {
    ScreenshotFunctions func;

    @Test
    public void testFirst() throws IOException {
        // Assign unique name to screenshot.
        String SiteLevel = "Ml";
        String Path = "Screenshots\\HCL\\" + SiteLevel + "\\";
        String BaseUrl = "http://hcl-ml.sites.innoraft.com/";
        String Browsers[][] = new String[][]{
                {"Windows", "7", "ie", "9.0"},
                {"Windows", "7", "firefox", "30.0"},
                {"Windows", "7", "chrome", "36.0"},
                {"Windows", "7", "opera", "12.16"},
                {"Windows", "7", "safari", "5.1"},
        };
        String file_url[][] = new String[][]{{"About Us","" + BaseUrl + "/about-us"},
                {"About Us_About HCL Technologies","" + BaseUrl + "/about-us/about-hcl-technologies"},
                {"About Us_About HCL Enterprise","" + BaseUrl + "/about-us/about-hcl-enterprise"},
                {"About Us_Vision & Mission","" + BaseUrl + "/about-us/value-statements"},
                {"About Us_Leadership","" + BaseUrl + "/about-us/leadership/board-of-directors"},
                {"About Us_Leadership_Executive Profiles","" + BaseUrl + "/about-us/leadership/executive-profiles"},
                {"About Us_Leadership_Board of Directors","" + BaseUrl + "/about-us/leadership/board-of-directors"},
                {"About Us_Governance","" + BaseUrl + "/about-us/corporate-governance"},
                {"About Us_Governance_Governance Policies","" + BaseUrl + "/about-us/corporate-governance/governance-policies"},
                {"About Us_Alliances","" + BaseUrl + "/about-us/alliances"},
                {"About Us_Alliances_Microsoft Alliance","" + BaseUrl + "/about-us/microsoft-alliance"},
                {"About Us_Alliances_Microsoft Alliance_GamEdge","" + BaseUrl + "/about-us/gamedge"},
                {"About Us_Alliances_Microsoft Alliance_EmpoweRetail CRM for Retailers","" + BaseUrl + "/about-us/empoweretail-crm-retailers"},
                {"About Us_Alliances_Microsoft Alliance_FinEdge","" + BaseUrl + "/about-us/finedge"},
                {"About Us_Recognitions","" + BaseUrl + "/about-us/awards-recognitions"},
                {"About Us_Socially Responsible Business","" + BaseUrl + "/socially-responsible-business"}
        };

        func = new ScreenshotFunctions();
        func.LoginBrowserStack(Browsers);
        func.OnBrowsersByBrowserStack(file_url, SiteLevel, Path);
        func.LogoutBrowserStack();
    }
}
