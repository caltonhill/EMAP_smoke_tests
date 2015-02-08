package james_tests.logged_in_user_tests._.subscribers;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

//  This Test was created in Selenium IDE and then exported as Java/Junit


public class AJSubscriberLoginThroughBarrierTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.architectsjournal.co.uk/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSigninARTICLEAJSUBSCRIBER() throws Exception {
        // Opens story page
        driver.get(baseUrl + "8678124.article");
        driver.navigate().refresh();
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
        driver.findElement(By.id("SIemail")).clear();
        driver.findElement(By.id("SIemail")).sendKeys("mdhewitt@aol.com");
        driver.findElement(By.id("passWord")).clear();
        driver.findElement(By.id("passWord")).sendKeys("samuel");
        driver.findElement(By.id("LoginButton")).click();
        // Verifies access to text behind barrier
        // Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Aedas claims to improved the air quality to the car park levels by introducing planting around the building’s perimeter\\.[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verifies comment box is present
        try {
            assertTrue(isElementPresent(By.cssSelector("div.formbox_sleeve > h2")));
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

