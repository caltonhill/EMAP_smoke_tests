package jamestests.search_results_displayed;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;


/**
 * Created by Macdonald on 12/02/14.
 */
public class SearchRetailWeek {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();

    }

    @Test
    public void searchRetailWeek(){
        driver.get("http://www.retail-week.com");
        //locate search box
        WebElement searchBox = driver.findElement(By.cssSelector("div[id='mastsearch'] input[id='qkeyword']"));
        //clear search box (not really necessary but just in case)
        searchBox.clear();
        //populate box with string London
        searchBox.sendKeys("London");

        //locate search button
        WebElement searchButton = driver.findElement(By.cssSelector("input[class='button nofix']"));
        //click search button
        searchButton.click();
        //tells Webdriver to wait until load of search results page is verified
        new WebDriverWait(driver,10,20).until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='results_heading'] > h1")));

        //finds text string for number of results returned
        WebElement resultsReturned = driver.findElement(By.cssSelector("div[id='results_matches'] > p > strong"));
            //Expects that string before results returned != "No"
            assertThat(resultsReturned.getText(),not("No"));
            //converts results returned text to integer
            int numResults = Integer.parseInt(resultsReturned.getText());
            //Expects that the integer discovered is greater than 0
            assertTrue("Expected results returned > 0", numResults > 0);

        //Expects all 5 sort options to be present in correct order
        List <WebElement> sortOptions = driver.findElements(By.cssSelector(
                "div[id='results_body_sleeve'] > p[class='sort'] > a"));
            assertEquals(5, sortOptions.size());
            assertThat(sortOptions.get(0).getText().toLowerCase(), is("last 24 hours"));
            assertThat(sortOptions.get(1).getText().toLowerCase(), is("last 7 days"));
            assertThat(sortOptions.get(2).getText().toLowerCase(), is("last 28 days"));
            assertThat(sortOptions.get(3).getText().toLowerCase(), is("newest first"));
            assertThat(sortOptions.get(4).getText().toLowerCase(), is("oldest first"));

        //Expects number of headlines in results list displayed to equal 10
        List <WebElement> numSearchResults = driver.findElements(By.cssSelector("ul[id='results_list'] > li > h3"));
            assertEquals(10,numSearchResults.size());

        //Expects number of right-hand search filters to equal 5
        List <WebElement> filterSections = driver.findElements(By.cssSelector(
                "div[id='filter_sleeve'] > div[class='filter_box']"));
            assertEquals(5,filterSections.size());

    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }

}
