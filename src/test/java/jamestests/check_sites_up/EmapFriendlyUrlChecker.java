package jamestests.check_sites_up;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;


/**
 * Created by Macdonald on 18/01/14.
 */
public class EmapFriendlyUrlChecker {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
    }

    /**
     * Intention is simple check that a page is loaded on friendly url
     * For each site: navigates to section page on friendly url.
     * Tells Webdriver to wait maximum 10 secs whilst it checks
     * page title to confirm page has loaded. NB. some sites don't populate
     * <title>!.
     * Locates a text element on page, such as a spinblock title and asserts
     * match to expected text string.
     * NB. Tests can therefore fail just through text change in CMS.
     * At some point will refactor to use more permanent page elements
     */
    @Test
    public void openAjSectionPgFriendlyUrlAndCheckForText (){
        driver.get("http://www.architectsjournal.co.uk/news/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Architect"));
        WebElement AjSpinblockTitle = driver.findElement
                (By.cssSelector("div.column.columnTwo > div.style > div.colour1 > div.sectionhead " +
                        "> div.sectionhead_sleeve > h2"));
                assertThat(AjSpinblockTitle.getText().toLowerCase(),is ("latest news"));
    }
    @Test
    public void openArSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.architectural-review.com/buildings/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement ArSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='twoColumnsSmallRight'] > div[class='columnContainer'] " +
                        "div[class='column columnOne'] div[class='sectionhead_sleeve'] h2"));
                assertThat(ArSpinblockTitle.getText().toLowerCase(),is ("buildings"));
    }
    @Test
    public void openCnSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.cnplus.co.uk/opinion/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Construction"));
        WebElement CnSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='columnContainer'] > div[class='column columnOne'] > " +
                        "div[class='htmlContent'] div[class='sectionhead_sleeve'] h2"));
        assertThat(CnSpinblockTitle.getText().toLowerCase(),is ("today's picks"));
    }
    @Test
    public void openDrSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.drapersonline.com/fashion/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement DrPageIntroText = driver.findElement
                (By.cssSelector("div[id='section_intro']"));
        assertThat(DrPageIntroText.getText().toLowerCase(),is ("fashion brand news, fashion trends"));
    }
    @Test
    public void openHsjSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.hsj.co.uk/news/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("HSJ"));
        assertThat(driver.getTitle().toLowerCase(),containsString ("nhs news"));
    }
    @Test
    public void openHvnSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.hvnplus.co.uk/comment/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement HvnSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='colour1'] div[class='sectionhead_sleeve'] > h2"));
        assertThat(HvnSpinblockTitle.getText().toLowerCase(),is ("your views"));
    }
    @Test
    public void openLgcSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.lgcplus.com/opinion/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Government"));
        WebElement LgcPageIntroText = driver.findElement
                (By.cssSelector("div[id='section_intro'] > h4"));
        assertThat(LgcPageIntroText.getText().toLowerCase(),is ("opinion from lgc"));
    }
    @Test
    public void openLightingSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.lighting.co.uk/hardware");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("hardware"));
        WebElement LightingHyperlinkedSpinblockTitle = driver.findElement
                (By.cssSelector("a[href='http://www.lighting.co.uk/section1.aspx?navCode=1244']"));
        assertThat(LightingHyperlinkedSpinblockTitle.getText().toLowerCase(),is ("lamps"));
    }
    @Test
    public void openMrw2ndLevelSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.mrw.co.uk/news/collections/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("Recycling"));
        WebElement MrwSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='section_column1'] > div[class='colour1'] h2"));
        assertThat(MrwSpinblockTitle.getText().toLowerCase(),is ("collections news"));
    }
    @Test
    public void openNceSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.nce.co.uk/features/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains(""));
        WebElement NcePageIntroText = driver.findElement
                (By.cssSelector("div[id='section_intro']"));
        assertThat(NcePageIntroText.getText().toLowerCase(),startsWith("features"));
    }
    @Test
    public void openNtSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.nursingtimes.net/nursing-practice/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("practice"));
        WebElement NtHtmlBlockTitle = driver.findElement
                (By.cssSelector("div[class='section_column1'] > div[class='htmlContent'] " +
                        "div[class='sectionhead_sleeve']"));
        assertThat(NtHtmlBlockTitle.getText().toLowerCase(),containsString("archive"));
    }
    @Test
    public void openRacSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.racplus.com/features/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("RAC"));
        WebElement RacSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='sectionhead_sleeve'] > h2"));
        assertThat(RacSpinblockTitle.getText().toLowerCase(),startsWith("rac"));
    }
    @Test
    public void openRjSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.retail-jeweller.com/products/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("product"));
        WebElement RjSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='sectionhead_sleeve'] > h2"));
        assertThat(RjSpinblockTitle.getText().toLowerCase(),is("product news"));
    }
    @Test
    public void openRw2ndLevelSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.retail-week.com/sectors/food/");
        new WebDriverWait(driver,10,300).until(
                ExpectedConditions.titleContains("food"));
        WebElement RwBlockTitle = driver.findElement
                (By.cssSelector("div[class='section-header-2013']"));
        assertThat(RwBlockTitle.getText().toLowerCase(),is("sectors"));
    }
    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
