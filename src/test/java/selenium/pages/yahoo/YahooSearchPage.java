package selenium.pages.yahoo;

import org.junit.After;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.pages.SearchPage;

import java.util.List;

public class YahooSearchPage implements SearchPage {
    WebDriver driver = new ChromeDriver();
    private String url = "http://yahoo.com";
    @FindBy(css = "#header-search-input")
    private WebElement searchInput;
    @FindAll(@FindBy(css = "ol.searchCenterMiddle > li"))
    private List<WebElement> getElements;

    public YahooSearchPage() {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getSearchResult(String word) {
        driver.get(url);
        searchInput.sendKeys(word);
        searchInput.sendKeys(Keys.ENTER);
        return getElements;
    }

    @After
    public void afterMethod() {
        driver.quit();
    }
}
