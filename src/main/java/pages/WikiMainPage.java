package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.*;

public class WikiMainPage {

    private AndroidDriver driver;

    @AndroidFindBy(id = "org.wikipedia:id/fragment_onboarding_skip_button")
    private WebElement skipButton;

    @AndroidFindBy(id = "org.wikipedia:id/main_toolbar_wordmark")
    private WebElement wikiTitle;

    @AndroidFindBy(id = "org.wikipedia:id/search_container")
    private WebElement searchButton;

    @AndroidFindBy(id = "org.wikipedia:id/search_src_text")
    private WebElement searchField;

    public WikiMainPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public SearchResultPage search(String text) {
        searchButton.click();
        searchField.sendKeys(text);
        return new SearchResultPage(driver);
    }

    public WikiMainPage assertPageIsOpen(){
        if(skipButton.isDisplayed())
            skipButton.click();
        assertTrue(wikiTitle.isDisplayed());
        return this;
    }
}
