package Testing.HCL;

import Testing.CommonFunction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by om on 1/24/2015.
 */
public abstract class HCLAbstract {
    public WebDriver driver;
    public HCLFunctions func;
    public CommonFunction func2;
    public String Role;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        func = new HCLFunctions(driver);
        func2 = new CommonFunction(driver);
        driver.manage().timeouts().implicitlyWait(func.timeoutOFAllElement, TimeUnit.SECONDS);

        driver.get(func.baseUrl);
        func.CheckLogin();
        func.LoginRole(Role);
    }

    @Test
    public abstract void CreateContent() throws Exception;

    @Test
    public abstract void UpdateContent() throws Exception;

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
