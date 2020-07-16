package selenium.pages.google;

import org.junit.After;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import selenium.pages.SearchPage;

import java.util.List;

public class GoogleSearchPage implements SearchPage {
    WebDriver driver = new ChromeDriver();
    private String url = "http://google.com.ua";
    @FindBy(css = "input[name='q']")
    private WebElement searchInput;
    @FindAll(value = @FindBy(css = "div.rc"))
    private List<WebElement> getElements;

    public GoogleSearchPage() {
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
