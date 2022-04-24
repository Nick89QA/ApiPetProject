import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;


abstract public class BaseTest {

    public void setUp() {
        WebDriverManager.chromedriver().setup(); //установка хромдрайвера при запуске
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true; //разрешение для вебдрайвер менеджера
        Configuration.browserSize = "1920*1080"; //разрешение браузера
        Configuration.headless = false; //настройка отображения экрана
    }

    @Before
    public void init() { //вызов метода setUp
        setUp();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver(); //закрытие вебдрайвера
    }

}
