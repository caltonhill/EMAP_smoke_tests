package jamestests.Logged_In_User_Tests;



import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class RegUserLoginRetailWeek {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String baseURL="http://www.retail-week.com/";
    private WebElement signInLink;
    private WebElement emailField;
    private WebElement pwordField;
    private WebElement loginButton;

    private String loginEmail = "jamestest4@freeolamail.com";
    private String loginPassword = "password";
    private WebElement rwBottomNavItem;

    @BeforeClass
    public static void driverSetUp(){

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,10,20);

    }

    @Before
    public void setUpTests(){

        driver.get(baseURL);
    }

    @After
    public void tearDown() {

        driver.manage().deleteAllCookies();

        driver.navigate().refresh();
    }

    @Test
     public void checkCanLoginWithRegUserDetails(){
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

        emailField = driver.findElement(By.cssSelector("input[id='SIemail']"));
            emailField.clear();
            emailField.sendKeys("jamestest4@freeolamail.com");

        pwordField = driver.findElement(By.id("passWord"));
            pwordField.clear();
            pwordField.sendKeys("password");

        assertTrue(driver.findElement(By.id("SIRememUserName")).isSelected());

        loginButton = driver.findElement(By.id("LoginButton"));
            loginButton.click();

        assertTrue(driver.getWindowHandle().contentEquals(mainWindowHandle));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "a[class$='loggedIn']")));

        assertTrue(driver.findElement(By.cssSelector(
                "a[class$='loggedIn']")).isDisplayed());

    }

    @Ignore
    public void checkTempIDCookieValue(){
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

        emailField = driver.findElement(By.cssSelector("input[id='SIemail']"));
        emailField.clear();
        emailField.sendKeys("jamestest4@freeolamail.com");

        pwordField = driver.findElement(By.id("passWord"));
        pwordField.clear();
        pwordField.sendKeys("password");

        assertTrue(driver.findElement(By.id("SIRememUserName")).isSelected());

        loginButton = driver.findElement(By.id("LoginButton"));
        loginButton.click();

        assertTrue(driver.getWindowHandle().contentEquals(mainWindowHandle));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "a[class$='loggedIn']")));

        assertTrue(driver.findElement(By.cssSelector(
                "a[class$='loggedIn']")).isDisplayed());

        //check for value 0 in tempID

    }
    }

    @Test
    public void checkEmapAuthCookiePresent(){
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

        emailField = driver.findElement(By.cssSelector("input[id='SIemail']"));
        emailField.clear();
        emailField.sendKeys("jamestest4@freeolamail.com");

        pwordField = driver.findElement(By.id("passWord"));
        pwordField.clear();
        pwordField.sendKeys("password");

        assertTrue(driver.findElement(By.id("SIRememUserName")).isSelected());

        loginButton = driver.findElement(By.id("LoginButton"));
        loginButton.click();

        assertTrue(driver.getWindowHandle().contentEquals(mainWindowHandle));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "a[class$='loggedIn']")));

        assertTrue(driver.findElement(By.cssSelector(
                "a[class$='loggedIn']")).isDisplayed());

        assertThat(driver.manage().getCookieNamed("emapauth"), notNullValue());

    }


    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }

}
