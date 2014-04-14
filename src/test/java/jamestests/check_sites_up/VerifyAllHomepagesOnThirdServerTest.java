package jamestests.Check_Sites_Up;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Macdonald on 21/01/14.
 */
public class VerifyAllHomepagesOnThirdServerTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,10,20);
    }

    @Test
    public void canVerifyAjHomepageOnThirdServer (){
        driver.get("http://architectslive3.architectsjournal.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement AjNavLink = driver.findElement
                (By.cssSelector("a[href='http://architectslive3.architectsjournal.co.uk/buildings/']"));

        assertThat(AjNavLink.getText().toLowerCase(),is ("buildings"));
    }
    @Test
    public void canVerifyArHomepageOnThirdServer (){
        driver.get("http://arlive3.architectural-review.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement ArBuildingsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] a[href='http://arlive3.architectural-review.com/buildings/']"));

        assertThat(ArBuildingsNavItem.getText().toLowerCase(),is("buildings"));
    }
    @Test
    public void canVerifyCnHomepageOnThirdServer (){
        driver.get("http://cnlive3.cnplus.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement CnSpinblockTitle = driver.findElement(By.cssSelector(
                "div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));

        assertThat(CnSpinblockTitle.getText().toLowerCase(),is ("top stories"));
    }
    @Test
    public void canVerifyDrHomepageOnThirdServer (){
        driver.get("http://draperslive3.drapersonline.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement DrSpinblockTitle = driver.findElement(By.cssSelector(
                "div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));

        assertThat(DrSpinblockTitle.getText().toLowerCase(),containsString("news"));
    }
    @Test
    public void canVerifyHsjHomepageOnThirdServer (){
        driver.get("http://hsjlive3.hsj.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement HsjNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://hsjlive3.hsj.co.uk/news/']"));

        assertThat(HsjNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyHvnHomepageOnThirdServer (){
        driver.get("http://hvnlive3.hvnplus.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement HvnNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://hvnlive3.hvnplus.co.uk/news/']"));

        assertThat(HvnNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyLgcHomepageOnThirdServer (){
        driver.get("http://lgclive3.lgcplus.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement LgcJobsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://www.lgcjobs.com/']"));

        assertThat(LgcJobsNavItem.getText().toLowerCase(),is("jobs"));
    }
    @Test
    public void canVerifyLightingHomepageOnThirdServer (){
        driver.get("http://lightinglive3.lighting.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement LightingNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://lightinglive3.lighting.co.uk/news/']"));

        assertThat(LightingNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyMrwHomepageOnThirdServer (){
        driver.get("http://mrwlive3.mrw.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement MrwNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://mrwlive3.mrw.co.uk/news/']"));

        assertThat(MrwNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyNceHomepageOnThirdServer (){
        driver.get("http://ncelive3.nce.co.uk");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement NceNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://ncelive3.nce.co.uk/news/']"));

        assertThat(NceNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyNtHomepageOnThirdServer (){
        driver.get("http://nursinglive3.nursingtimes.net");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement NtPracticeNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://nursinglive3.nursingtimes.net/nursing-practice/']"));

        assertThat(NtPracticeNavItem.getText().toLowerCase(),containsString("practice"));
    }
    @Test
    public void canVerifyRacHomepageOnThirdServer (){
        driver.get("http://raclive3.racplus.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement RacNewsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://raclive3.racplus.com/news/']"));

        assertThat(RacNewsNavItem.getText().toLowerCase(),is("news"));
    }
    @Test
    public void canVerifyRjHomepageOnThirdServer (){
        driver.get("http://rjlive3.retail-jeweller.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement RjProductsNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://rjlive3.retail-jeweller.com/products/']"));

        assertThat(RjProductsNavItem.getText().toLowerCase(),is("products"));
    }

    @Test
    public void canVerifyRwHomepageOnThirdServer (){
        driver.get("http://retaillive3.retail-week.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='colmain']")));

        WebElement RwCompaniesNavItem = driver.findElement(By.cssSelector(
                "div[id='mainnav_sleeve'] > ul > li > a[href='http://retaillive3.retail-week.com/companies/']"));

        assertThat(RwCompaniesNavItem.getText().toLowerCase(),is("companies"));
    }


    @AfterClass
    public static void quitDriver (){
        driver.quit();
    }

}
