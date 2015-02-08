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

public class RwRegUserCookiesTest {
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
    public void checkEmapAuthCookiePresent(){

        assertThat(driver.manage().getCookieNamed("emapauth"), notNullValue());

    }

    @Test
    public void checkSingleSignOnCookieValue(){

        assertThat(driver.manage().getCookieNamed("tempid")
                .getValue(),containsString("|0|"));

    }

    @Test
    public void checkRememberMeCookiePresent(){

        assertThat(driver.manage().getCookieNamed(".ASPXAUTH"), notNullValue());
        assertThat(driver.manage().getCookieNamed(".ASPXAUTH").getDomain()
                , is("www.retail-week.com"));

/*   TODO: work out how to check cookie expiry date is correct. Need to get current date/time
/        add 1 month(?), compare to cookie expiry?
*/
    }

    @Test
    public void checkConcurrencyCookieNotPresentForRegUser(){
        assertThat(driver.manage().getCookieNamed("SSOEX"+userSubsID), nullValue());
    }

    @Test
    public void checkCookieAcceptanceCookiePresent(){
        assertThat(driver.manage().getCookieNamed("HasVisited"), notNullValue());
    }


    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }

}
