package jamestests.Login_As_Subscriber;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

//  This Test was created in Selenium IDE and then exported as Java/Junit

public class HsjSubscriberLoginThroughBarrierTest {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testHsjSubscriberLoginThroughBarrier() throws Exception {
        // Opens story page
        driver.get("http://www.hsj.co.uk/news/finance/circles-risk-on-historic-hinchingbrooke-deal-capped-at-7m/5037818.article");
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
        driver.findElement(By.id("SIemail")).sendKeys("jamestest4@freeolamail.com");
        driver.findElement(By.id("SubsLoginEmail")).click();
        driver.findElement(By.id("passWord")).clear();
        driver.findElement(By.id("passWord")).sendKeys("password");
        driver.findElement(By.id("LoginButton")).click();
        // Confirms Related Articles heading present
        // Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Confirms access to text behind barrier
        // Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Health minister Simon Burns told the House of Commons the agreement was a “good deal for patients and staff at Hinchingbrooke”\\.[\\s\\S]*$"));
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
