package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.pages.SearchPage;
import selenium.pages.google.GoogleSearchPage;
import selenium.pages.yahoo.YahooSearchPage;

import java.util.List;

public class SearchTest {
    String searchWord;
    SearchPage page;

    @Before
    public void beforeMethod() {

        System.setProperty("webdriver.chrome.driver", "D:\\Soft\\WebDriversSelenium\\chromedriver.exe");
        searchWord = "selenium";
    }

    @Test
    public void testMethod() {
        page = new GoogleSearchPage();
        List<WebElement> elements = page.getSearchResult(searchWord);
        for (WebElement el: elements) {
            Assert.assertTrue(el.getText().toLowerCase().contains(searchWord.toLowerCase()));
        }
    }
    @Test
    public void testMethod2() {
        page = new YahooSearchPage();
        List<WebElement> elements = page.getSearchResult(searchWord);
        System.out.println(elements.size());
        for (WebElement el: elements) {
            Assert.assertTrue(el.getText().toLowerCase().contains(searchWord.toLowerCase()));
        }
    }

}
