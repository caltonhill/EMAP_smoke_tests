package james_tests.registered_users;



import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class RwRegUserMetaDataTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String baseURL="http://www.retail-week.com/";
    private WebElement signInLink;
    private WebElement emailField;
    private WebElement pwordField;
    private WebElement loginButton;

    private String loginEmail = "jamestest4@freeolamail.com";
    private String loginPassword = "password";
    private String userSubsID = "5014646";
    private WebElement rwBottomNavItem;

    @BeforeClass
    public static void driverSetUp(){

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,10,20);

    }

    @Before
    public void loginAsRegUserToSetUpTests(){

        driver.get(baseURL);

        assertThat(driver.getCurrentUrl(),is(baseURL));

        String mainWindowHandle = driver.getWindowHandle();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));
        rwBottomNavItem = driver.findElement(By.cssSelector(
                "li > a[href='http://www.retail-week.com/terms-and-conditions/']"));
        assertThat(rwBottomNavItem.getText().toLowerCase(),containsString("conditions"));

        signInLink = driver.findElement(By.partialLinkText(
                "Sign"));
        signInLink.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("wvPopupIframe")));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='SIemail']")));

        emailField = driver.findElement(By.cssSelector("input[id='SIemail']"));
        emailField.clear();
        emailField.sendKeys(loginEmail);

        pwordField = driver.findElement(By.id("passWord"));
        pwordField.clear();
        pwordField.sendKeys(loginPassword);

        assertTrue(driver.findElement(By.id("SIRememUserName")).isSelected());

        loginButton = driver.findElement(By.id("LoginButton"));
        loginButton.click();

        assertTrue(driver.getWindowHandle().contentEquals(mainWindowHandle));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "a[class$='loggedIn']")));

        assertTrue(driver.findElement(By.cssSelector(
                "a[class$='loggedIn']")).isDisplayed());


    }

    @After
    public void tearDown() {

        driver.manage().deleteAllCookies();

        driver.navigate().refresh();
    }

    @Test
    public void checkForWebSubsUserIDMetaTag(){

        WebElement subsID = driver.findElement(By.cssSelector("meta[name='SubsID']"));
        assertThat(subsID.getAttribute("content").toString()
                ,is(userSubsID));
    }

    @Test
    public void checkForUserStatusMetaTag(){

        WebElement statusMetaTag = driver.findElement(By.cssSelector("meta[name='Status']"));
        assertThat(statusMetaTag.getAttribute("content"),is("R"));
    }

    @Test
    public void checkForSeg4MetaTag(){

        WebElement seg4MetaTag = driver.findElement(By.cssSelector("meta[name='WT.seg_4']"));
        assertThat(seg4MetaTag.getAttribute("content"), is("REG"));

    }


    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }

}
