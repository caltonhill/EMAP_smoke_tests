package james_tests.email_newsletter_signup;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class RW_NewsletterSignUp {

    private static WebDriver driver;
    private String baseUrl = "http://www.retail-week.com";
    private String loginEmail = "jamestest2@freeolamail.com";
    private String loginPassword = "password";

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        }

    @Test
    public void signInSignUpNewsletterDisplayConfirmation() {

        driver.get(baseUrl + "/my-account/my-newsletters");

            //assert am on sign in page
                 assertTrue("",driver.getCurrentUrl().contains("SignIn.aspx"));

            //log in using email and password set above
        WebElement email = driver.findElement(By.id("SIemail"));
            email.sendKeys(loginEmail);
        WebElement password = driver.findElement(By.id("passWord"));
            password.sendKeys(loginPassword);
        WebElement signInButton = driver.findElement(By.id("LoginButton"));
            signInButton.click();

            //wait for newsletters page
        new WebDriverWait(driver,10,20).until(
                ExpectedConditions.titleContains("newsletters"));
            //additional check am on newsletters page:
            //assert that newsletters submit button present
        assertEquals(true,driver.findElement(By.id("NewsletterBtn")).isDisplayed());

            //select Daily News newsletter
        WebElement dailyNewsCheckbox = driver.findElement(By.id("newsletter_19"));
            //TO DO: need to add some kind of condition here on what to do if checkbox
            //already selected
            dailyNewsCheckbox.click();
                //assert that checkbox is ticked
                assertEquals(true, dailyNewsCheckbox.isSelected());

            //select HTML radio button (though not necessary for sign-up)
        WebElement htmlRadio = driver.findElement(By.id("newsletterHTML"));
            htmlRadio.click();

           //submit selection
        WebElement submitButton = driver.findElement(By.id("NewsletterBtn"));
            submitButton.click();
                //assert confirmation message is displayed
                assertThat(driver.findElement(By.cssSelector("div[class='feedback_box_sleeve'] p:first-of-type"))
                    .getText(), containsString("Your newsletter selection has been submitted"));

           //close confirmation message
        WebElement closeButton = driver.findElement(By.cssSelector("div[class='feedback_close'] > a"));
            closeButton.click();
                //assert confirmation message has closed
                assertEquals(true, driver.findElements(By.cssSelector("div[class='feedback_box_sleeve']"))
                .isEmpty());

        //Teardown - unsubscribe again
            dailyNewsCheckbox.click();

                assertEquals(false, dailyNewsCheckbox.isSelected());

            submitButton.click();

                assertThat(driver.findElement(By.cssSelector("div[class='feedback_box_sleeve'] p:first-of-type"))
                .getText(), containsString("Your newsletter selection has been submitted"));

            closeButton.click();
                //.findElement won't work here
                //using .findElements because it doesn't throw exception error
                assertEquals(true, driver.findElements(By.cssSelector("div[class='feedback_box_sleeve']"))
                .isEmpty());

                assertEquals(false, dailyNewsCheckbox.isSelected());
    }

    @AfterClass
     public static void quitDriver(){

        driver.quit();
    }
}
