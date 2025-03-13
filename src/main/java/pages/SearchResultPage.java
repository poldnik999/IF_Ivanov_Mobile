package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchResultPage {

    @AndroidFindBy(id = "org.wikipedia:id/search_results_list")
    private List<WebElement> searchResults;

    @AndroidFindBy(id = "org.wikipedia:id/search_container")
    private WebElement searchContainer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_title\"]")
    private WebElement resultTextView;

    @AndroidFindBy(id = "org.wikipedia:id/search_src_text")
    private WebElement searchText;

    private AndroidDriver driver;

    public SearchResultPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public SearchResultPage assertPageIsOpen(){
        assertTrue(searchContainer.isDisplayed());
        return this;
    }
    public void assertResultTextIsEqual(){
        assertThat(searchResults
                .get(0)
                .findElement(By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_title\"]"))
                .getText())
                .contains(searchText.getText());
    }
}
