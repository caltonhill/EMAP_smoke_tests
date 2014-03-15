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
 * Created by Macdonald on 21/01/14.
 */
public class VerifyAllHomepagesOnSecondServer {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,10,20);
    }

    @Test
    public void canVerifyAjHomepageOnSecondServer (){
        driver.get("http://architectslive2.architectsjournal.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement AjNavLink = driver.findElement
                (By.cssSelector("a[href='http://architectslive2.architectsjournal.co.uk/buildings/']"));

        assertThat(AjNavLink.getText().toLowerCase(),is ("buildings"));
    }
    @Test
    public void canVerifyArHomepageOnSecondServer (){
        driver.get("http://arlive2.architectural-review.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement ArBuildingsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] a[href='http://arlive2.architectural-review.com/buildings/']"));

        assertThat(ArBuildingsNavItem.getText().toLowerCase(),is("buildings"));
    }
    @Test
    public void canVerifyCnHomepageOnSecondServer (){
        driver.get("http://cnlive2.cnplus.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement CnSpinblockTitle = driver.findElement(By.cssSelector(
                "div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));

        assertThat(CnSpinblockTitle.getText().toLowerCase(),is ("top stories"));
    }
    @Test
    public void canVerifyDrHomepageOnSecondServer (){
        driver.get("http://draperslive2.drapersonline.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement DrSpinblockTitle = driver.findElement(By.cssSelector(
                "div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));

        assertThat(DrSpinblockTitle.getText().toLowerCase(),containsString("news"));
    }
    @Test
    public void canVerifyHsjHomepageOnSecondServer (){
        driver.get("http://hsjlive2.hsj.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement HsjNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://hsjlive2.hsj.co.uk/news/']"));

        assertThat(HsjNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyHvnHomepageOnSecondServer (){
        driver.get("http://hvnlive2.hvnplus.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement HvnNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://hvnlive2.hvnplus.co.uk/news/']"));

        assertThat(HvnNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyLgcHomepageOnSecondServer (){
        driver.get("http://lgclive2.lgcplus.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement LgcJobsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.lgcjobs.com/']"));

        assertThat(LgcJobsNavItem.getText().toLowerCase(),is("jobs"));
    }
    @Test
    public void canVerifyLightingHomepageOnSecondServer (){
        driver.get("http://lightinglive2.lighting.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement LightingNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://lightinglive2.lighting.co.uk/news/']"));

        assertThat(LightingNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyMrwHomepageOnSecondServer (){
        driver.get("http://mrwlive2.mrw.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement MrwNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://mrwlive2.mrw.co.uk/news/']"));

        assertThat(MrwNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyNceHomepageOnSecondServer (){
        driver.get("http://ncelive2.nce.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement NceNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://ncelive2.nce.co.uk/news/']"));

        assertThat(NceNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyNtHomepageOnSecondServer (){
        driver.get("http://nursinglive2.nursingtimes.net");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement NtPracticeNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://nursinglive2.nursingtimes.net/nursing-practice/']"));

        assertThat(NtPracticeNavItem.getText().toLowerCase(),containsString("practice"));
    }
    @Test
    public void canVerifyRacHomepageOnSecondServer (){
        driver.get("http://raclive2.racplus.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement RacNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://raclive2.racplus.com/news/']"));

        assertThat(RacNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyRjHomepageOnSecondServer (){
        driver.get("http://rjlive2.retail-jeweller.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement RjProductsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://rjlive2.retail-jeweller.com/products/']"));

        assertThat(RjProductsNavItem.getText().toLowerCase(),is("products"));
    }

    @Test
    public void canVerifyRwHomepageOnSecondServer (){
        driver.get("http://retaillive2.retail-week.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement RwCompaniesNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://retaillive2.retail-week.com/companies/']"));

        assertThat(RwCompaniesNavItem.getText().toLowerCase(),is("companies"));
    }


    @AfterClass
    public static void quitDriver (){
        driver.quit();
    }

}
