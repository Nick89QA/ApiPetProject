import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница сайта Appleinsider.ru
 */

public class MainPage {
    private static SelenideElement searchButton = $x("//form");

    public void clickOnSearch() { //метод клик по кнопке
        searchButton.click();
    }

    public void openWebSite(String url) {
        Selenide.open(url);
    }
}
