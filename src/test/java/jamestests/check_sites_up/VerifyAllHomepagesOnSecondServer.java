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

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void canVerifyAjHomepageOnSecondServer (){
        driver.get("http://architectslive2.architectsjournal.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Architect"));
        WebElement AjNavLink = driver.findElement
                (By.cssSelector("a[href='http://architectslive2.architectsjournal.co.uk/buildings/']"));
        assertThat(AjNavLink.getText(),is ("Buildings"));
    }
    @Test
    public void canVerifyArHomepageOnSecondServer (){
        driver.get("http://arlive2.architectural-review.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement ArSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='column columnTwo'] div[class='colour2'] div[class='sectionhead_sleeve'] h2"));
        assertThat(ArSpinblockTitle.getText(),is ("PUBLIC EVENTS"));
    }
    @Test
    public void canVerifyCnHomepageOnSecondServer (){
        driver.get("http://cnlive2.cnplus.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Construction"));
        WebElement CnSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));
        assertThat(CnSpinblockTitle.getText(),is ("TOP STORIES"));
    }
    @Test
    public void canVerifyDrHomepageOnSecondServer (){
        driver.get("http://draperslive2.drapersonline.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement DrSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));
        assertThat(DrSpinblockTitle.getText(),containsString("News"));
    }
    @Test
    public void canVerifyHsjHomepageOnSecondServer (){
        driver.get("http://hsjlive2.hsj.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("HSJ"));
        WebElement HsjNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://hsjlive2.hsj.co.uk/news/']"));
        assertThat(HsjNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyHvnHomepageOnSecondServer (){
        driver.get("http://hvnlive2.hvnplus.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement HvnNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://hvnlive2.hvnplus.co.uk/news/']"));
        assertThat(HvnNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyLgcHomepageOnSecondServer (){
        driver.get("http://lgclive2.lgcplus.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Government"));
        WebElement LgcJobsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.lgcjobs.com/']"));
        assertThat(LgcJobsNavItem.getText(),is("JOBS"));
    }
    @Test
         public void canVerifyLightingHomepageOnSecondServer (){
        driver.get("http://lightinglive2.lighting.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Lighting"));
        WebElement LightingNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://lightinglive2.lighting.co.uk/news/']"));
        assertThat(LightingNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyMrwHomepageOnSecondServer (){
        driver.get("http://mrwlive2.mrw.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Recycling"));
        WebElement MrwNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://mrwlive2.mrw.co.uk/news/']"));
        assertThat(MrwNewsNavItem.getText(),is("News"));
    }
    @Test
    public void canVerifyNceHomepageOnSecondServer (){
        driver.get("http://ncelive2.nce.co.uk");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement NceNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://ncelive2.nce.co.uk/news/']"));
        assertThat(NceNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyNtHomepageOnSecondServer (){
        driver.get("http://nursinglive2.nursingtimes.net");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Nursing"));
        WebElement NtPracticeNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://nursinglive2.nursingtimes.net/nursing-practice/']"));
        assertThat(NtPracticeNavItem.getText(),containsString("PRACTICE"));
    }
    @Test
    public void canVerifyRacHomepageOnSecondServer (){
        driver.get("http://raclive2.racplus.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("RAC"));
        WebElement RacNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://raclive2.racplus.com/news/']"));
        assertThat(RacNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyRjHomepageOnSecondServer (){
        driver.get("http://rjlive2.retail-jeweller.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("jewel"));
        WebElement RjProductsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://rjlive2.retail-jeweller.com/products/']"));
        assertThat(RjProductsNavItem.getText(),is("PRODUCTS"));
    }
    @Test
    public void canVerifyRwHomepageOnSecondServer (){
        driver.get("http://retaillive2.retail-week.com");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("retail"));
        WebElement RwCompaniesNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://retaillive2.retail-week.com/companies/']"));
        assertThat(RwCompaniesNavItem.getText(),is("Companies"));
    }


    @AfterClass
    public static void quitDriver (){
        driver.quit();
    }

}
