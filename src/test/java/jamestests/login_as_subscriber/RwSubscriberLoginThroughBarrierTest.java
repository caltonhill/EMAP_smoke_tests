package jamestests.Login_As_Subscriber;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


//  This Test was created in Selenium IDE and then exported as Java/Junit

public class RwSubscriberLoginThroughBarrierTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.retail-week.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testRwSubscriberLoginThroughBarrier() throws Exception {
        // Opens story page
        driver.get(baseUrl + "/city/ms-strategy-looks-sound/5030968.article");
        // Confirms barrier displayed
        // NB. Can fail if barrier text changed from expected
        // Warning: waitForTextPresent may require manual changes
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.getPageSource().contains("barrier")) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        // Enters login credentials
        // NB. Relies on login being valid/having subscriber rights
        // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
        driver.findElement(By.id("SIemail")).clear();
        driver.findElement(By.id("SIemail")).sendKeys("jamestest2@freeolamail.com");
        driver.findElement(By.id("SubsLoginEmail")).click();
        driver.findElement(By.id("passWord")).clear();
        driver.findElement(By.id("passWord")).sendKeys("password");
        driver.findElement(By.id("LoginButton")).click();
        // Verifies comment box is present
        try {
            assertTrue(isElementPresent(By.xpath("//form[@id='StoryComment']/fieldset/div/div[2]/label")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verifies presence of text behind barrier
        // Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Looking ahead to Christmas, the Dutch M&S boss is in optimistic mood, declaring M&S has a “very exciting Christmas product offer” and is well set up for the golden quarter\\.[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
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

