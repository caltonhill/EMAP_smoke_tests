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
public class VerifyAllHomepagesOnMainDomain {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void canVerifyAjHomepageOnMainDomain (){
        driver.get("http://www.architectsjournal.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Architect"));
        WebElement AjNavLink = driver.findElement
                (By.cssSelector("a[href='http://www.architectsjournal.co.uk/buildings/']"));
        assertThat(AjNavLink.getText(),is ("Buildings"));
    }
    @Test
    public void canVerifyArHomepageOnMainDomain (){
        driver.get("http://www.architectural-review.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement ArSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='column columnTwo'] div[class='colour2'] div[class='sectionhead_sleeve'] h2"));
        assertThat(ArSpinblockTitle.getText(),is ("PUBLIC EVENTS"));
    }
    @Test
    public void canVerifyCnHomepageOnMainDomain (){
        driver.get("http://www.cnplus.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Construction"));
        WebElement CnSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));
        assertThat(CnSpinblockTitle.getText(),is ("TOP STORIES"));
    }
    @Test
    public void canVerifyDrHomepageOnMainDomain (){
        driver.get("http://www.drapersonline.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement DrSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));
        assertThat(DrSpinblockTitle.getText(),containsString("News"));
    }
    @Test
    public void canVerifyHsjHomepageOnMainDomain (){
        driver.get("http://www.hsj.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("HSJ"));
        WebElement HsjNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.hsj.co.uk/news/']"));
        assertThat(HsjNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyHvnHomepageOnMainDomain (){
        driver.get("http://www.hvnplus.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement HvnNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.hvnplus.co.uk/news/']"));
        assertThat(HvnNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyLgcHomepageOnMainDomain (){
        driver.get("http://www.lgcplus.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Government"));
        WebElement LgcJobsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.lgcjobs.com/']"));
        assertThat(LgcJobsNavItem.getText(),is("JOBS"));
    }
    @Test
         public void canVerifyLightingHomepageOnMainDomain (){
        driver.get("http://www.lighting.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Lighting"));
        WebElement LightingNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.lighting.co.uk/news/']"));
        assertThat(LightingNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyMrwHomepageOnMainDomain (){
        driver.get("http://www.mrw.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Recycling"));
        WebElement MrwNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.mrw.co.uk/news/']"));
        assertThat(MrwNewsNavItem.getText(),is("News"));
    }
    @Test
    public void canVerifyNceHomepageOnMainDomain (){
        driver.get("http://www.nce.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement NceNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.nce.co.uk/news/']"));
        assertThat(NceNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyNtHomepageOnMainDomain (){
        driver.get("http://www.nursingtimes.net");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Nursing"));
        WebElement NtPracticeNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.nursingtimes.net/nursing-practice/']"));
        assertThat(NtPracticeNavItem.getText(),containsString("PRACTICE"));
    }
    @Test
    public void canVerifyRacHomepageOnMainDomain (){
        driver.get("http://www.racplus.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("RAC"));
        WebElement RacNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.racplus.com/news/']"));
        assertThat(RacNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyRjHomepageOnMainDomain (){
        driver.get("http://www.retail-jeweller.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Jewel"));
        WebElement RjProductsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.retail-jeweller.com/products/']"));
        assertThat(RjProductsNavItem.getText(),is("PRODUCTS"));
    }
    @Test
    public void canVerifyRwHomepageOnMainDomain (){
        driver.get("http://www.retail-week.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("retail"));
        WebElement RwCompaniesNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.retail-week.com/companies/']"));
        assertThat(RwCompaniesNavItem.getText(),is("Companies"));
    }


    @AfterClass
    public static void quitDriver (){
        driver.quit();
    }

}
