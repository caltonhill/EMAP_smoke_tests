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
public class VerifyAllHomepagesOnFirstServer {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,10,20);
    }

    @Test
    public void canVerifyAjHomepageOnFirstServer (){
        driver.get("http://architectslive1.architectsjournal.co.uk");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                    "div[id='colmain']")));
        
        WebElement AjNavLink = driver.findElement
                (By.cssSelector("a[href='http://architectslive1.architectsjournal.co.uk/buildings/']"));
        
        assertThat(AjNavLink.getText().toLowerCase(),is ("buildings"));
    }
    @Test
    public void canVerifyArHomepageOnFirstServer (){
        driver.get("http://arlive1.architectural-review.com");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement ArBuildingsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] a[href='http://arlive1.architectural-review.com/buildings/']"));

        assertThat(ArBuildingsNavItem.getText().toLowerCase(),is("buildings"));
    }
    @Test
    public void canVerifyCnHomepageOnFirstServer (){
        driver.get("http://cnlive1.cnplus.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));
        
        WebElement CnSpinblockTitle = driver.findElement(By.cssSelector(
                "div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));
        
        assertThat(CnSpinblockTitle.getText().toLowerCase(),is ("top stories"));
    }
    @Test
    public void canVerifyDrHomepageOnFirstServer (){
        driver.get("http://draperslive1.drapersonline.com");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));
        
        WebElement DrSpinblockTitle = driver.findElement(By.cssSelector(
                "div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));
        
        assertThat(DrSpinblockTitle.getText().toLowerCase(),containsString("news"));
    }
    @Test
    public void canVerifyHsjHomepageOnFirstServer (){
        driver.get("http://hsjlive1.hsj.co.uk");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));
        
        WebElement HsjNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://hsjlive1.hsj.co.uk/news/']"));
        
        assertThat(HsjNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyHvnHomepageOnFirstServer (){
        driver.get("http://hvnlive1.hvnplus.co.uk");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                    "div[id='colmain']")));

        WebElement HvnNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://hvnlive1.hvnplus.co.uk/news/']"));
        
        assertThat(HvnNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyLgcHomepageOnFirstServer (){
        driver.get("http://lgclive1.lgcplus.com");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                    "div[id='colmain']")));

        WebElement LgcJobsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.lgcjobs.com/']"));
        
        assertThat(LgcJobsNavItem.getText().toLowerCase(),is("jobs"));
    }
    @Test
    public void canVerifyLightingHomepageOnFirstServer (){
        driver.get("http://lightinglive1.lighting.co.uk");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                    "div[id='colmain']")));

        WebElement LightingNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://lightinglive1.lighting.co.uk/news/']"));
        
        assertThat(LightingNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyMrwHomepageOnFirstServer (){
        driver.get("http://mrwlive1.mrw.co.uk");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                    "div[id='colmain']")));

        WebElement MrwNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://mrwlive1.mrw.co.uk/news/']"));

        assertThat(MrwNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyNceHomepageOnFirstServer (){
        driver.get("http://ncelive1.nce.co.uk");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                    "div[id='colmain']")));

        WebElement NceNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://ncelive1.nce.co.uk/news/']"));

        assertThat(NceNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyNtHomepageOnFirstServer (){
        driver.get("http://nursinglive1.nursingtimes.net");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                    "div[id='colmain']")));

        WebElement NtPracticeNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://nursinglive1.nursingtimes.net/nursing-practice/']"));

        assertThat(NtPracticeNavItem.getText().toLowerCase(),containsString("practice"));
    }
    @Test
    public void canVerifyRacHomepageOnFirstServer (){
        driver.get("http://raclive1.racplus.com");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                    "div[id='colmain']")));

        WebElement RacNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://raclive1.racplus.com/news/']"));

        assertThat(RacNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyRjHomepageOnFirstServer (){
        driver.get("http://rjlive1.retail-jeweller.com");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                    "div[id='colmain']")));

        WebElement RjProductsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://rjlive1.retail-jeweller.com/products/']"));

        assertThat(RjProductsNavItem.getText().toLowerCase(),is("products"));
    }

    @Test
    public void canVerifyRwHomepageOnFirstServer (){
        driver.get("http://retaillive1.retail-week.com");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                    "div[id='colmain']")));

        WebElement RwCompaniesNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://retaillive1.retail-week.com/companies/']"));

        assertThat(RwCompaniesNavItem.getText().toLowerCase(),is("companies"));
    }


    @AfterClass
    public static void quitDriver (){
        driver.quit();
    }

}
