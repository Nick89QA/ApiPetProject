import com.codeborne.selenide.Selenide;
import org.junit.Test;

public class AppleTest extends BaseTest {

    private final static String BASE_URL = "https://appleinsider.ru/"; //url
    private final static String SEARCH_STRING = "Чем Iphone 13 отличается от Iphone 12";

    @Test
    public void checkHref() {
       MainPage mainPage = new MainPage(); //инициализация класса
        mainPage.openWebSite(BASE_URL);
    }

}
