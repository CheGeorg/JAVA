package selenium.pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface SearchPage {
    List<WebElement> getSearchResult(String word);
}
