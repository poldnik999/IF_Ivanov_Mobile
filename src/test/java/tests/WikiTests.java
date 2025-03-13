package tests;

import config.ConfigLoader;
import driverManager.DriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SearchResultPage;
import pages.WikiMainPage;

public class WikiTests extends DriverManager {

    private SearchResultPage searchPage;
    private static ConfigLoader prop = new ConfigLoader();

    @Test
    @DisplayName("Проверка первого результата запроса")
    public void wikiSearchTest(){
        searchPage = new WikiMainPage(driver)
                .assertPageIsOpen()
                .search(prop.getProperty("test.search.text"));

        searchPage
                .assertPageIsOpen()
                .assertResultTextIsEqual();
    }
}
