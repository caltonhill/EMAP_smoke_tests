package jamestests.check_sites_up;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * This provides a very basic check that the site is being returned. It does not necessarily guarantee
 * that the main content area of the homepage is displaying correctly, since many checks are looking for
 * a link in navigation (which would still be there on a 404 page.  However, a branded 404 is unlikely
 * to be returned on the homepage
 */
public class VerifyAllHomepagesOnMainDomain {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,10,20);
    }

    @Test
    public void canVerifyAjHomepageOnMainDomain (){
        driver.get("http://www.architectsjournal.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement AjNavLink = driver.findElement
                (By.cssSelector("a[href='http://www.architectsjournal.co.uk/buildings/']"));

        assertThat(AjNavLink.getText().toLowerCase(),is ("buildings"));
    }

    @Test
    public void canVerifyArHomepageOnMainDomain (){
        driver.get("http://www.architectural-review.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement ArBuildingsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] a[href='http://www.architectural-review.com/buildings/']"));

        assertThat(ArBuildingsNavItem.getText().toLowerCase(),is("buildings"));
    }

    @Test
    public void canVerifyCnHomepageOnMainDomain (){
        driver.get("http://www.cnplus.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement CnSpinblockTitle = driver.findElement(By.cssSelector(
                "div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));

        assertThat(CnSpinblockTitle.getText().toLowerCase(),is ("top stories"));
    }

    @Test
    public void canVerifyDrHomepageOnMainDomain (){
        driver.get("http://www.drapersonline.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement DrSpinblockTitle = driver.findElement(By.cssSelector(
                "div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));

        assertThat(DrSpinblockTitle.getText().toLowerCase(),containsString("news"));
    }

    @Test
    public void canVerifyHsjHomepageOnMainDomain (){
        driver.get("http://www.hsj.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement HsjNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.hsj.co.uk/news/']"));

        assertThat(HsjNewsNavItem.getText().toLowerCase(),is("news"));
    }

    @Test
    public void canVerifyHvnHomepageOnMainDomain (){
        driver.get("http://www.hvnplus.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement HvnNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.hvnplus.co.uk/news/']"));

        assertThat(HvnNewsNavItem.getText().toLowerCase(),is("news"));
    }

    @Test
    public void canVerifyLgcHomepageOnMainDomain (){
        driver.get("http://www.lgcplus.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement LgcJobsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.lgcjobs.com/']"));

        assertThat(LgcJobsNavItem.getText().toLowerCase(),is("jobs"));
    }

    @Test
    public void canVerifyLightingHomepageOnMainDomain (){
        driver.get("http://www.lighting.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement LightingNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.lighting.co.uk/news/']"));

        assertThat(LightingNewsNavItem.getText().toLowerCase(),is("news"));
    }

    @Test
    public void canVerifyMrwHomepageOnMainDomain (){
        driver.get("http://www.mrw.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement MrwNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.mrw.co.uk/news/']"));

        assertThat(MrwNewsNavItem.getText().toLowerCase(),is("news"));
    }

    @Test
    public void canVerifyNceHomepageOnMainDomain (){
        driver.get("http://www.nce.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement NceNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.nce.co.uk/news/']"));

        assertThat(NceNewsNavItem.getText().toLowerCase(),is("news"));
    }

    @Test
    public void canVerifyNtHomepageOnMainDomain (){
        driver.get("http://www.nursingtimes.net");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement NtPracticeNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.nursingtimes.net/nursing-practice/']"));

        assertThat(NtPracticeNavItem.getText().toLowerCase(),containsString("practice"));
    }

    @Test
    public void canVerifyRacHomepageOnMainDomain (){
        driver.get("http://www.racplus.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement RacNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.racplus.com/news/']"));

        assertThat(RacNewsNavItem.getText().toLowerCase(),is("news"));
    }
    
    @Test
    public void canVerifyRjHomepageOnMainDomain (){
        driver.get("http://www.retail-jeweller.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement RjProductsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.retail-jeweller.com/products/']"));

        assertThat(RjProductsNavItem.getText().toLowerCase(),is("products"));
    }

    @Test
    public void canVerifyRwHomepageOnMainDomain (){
        driver.get("http://www.retail-week.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement RwCompaniesNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.retail-week.com/companies/']"));

        assertThat(RwCompaniesNavItem.getText().toLowerCase(),is("companies"));
    }


    @AfterClass
    public static void quitDriver (){
        driver.quit();
    }

}
