package appleinsider;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница сайта Appleinsider.ru
 */

public class MainPage {
    private static SelenideElement textBoxInput = $x("//input[@type='text']");

    public void mainPage(String url) {
        Selenide.open(url);
    }

    /**
     * search articles and press enter
     *
     * @param searchString
     */
    public void search(String searchString) { //метод клик по кнопке
        textBoxInput.setValue(searchString);
        textBoxInput.pressEnter();
    }


}


