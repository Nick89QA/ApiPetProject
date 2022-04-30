import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


abstract public class BaseTest {

    public void setUp() {
        WebDriverManager.chromedriver().setup(); //установка хромдрайвера при запуске
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true; //разрешение для вебдрайвер менеджера
        Configuration.browserSize = "1920*1080"; //разрешение браузера
        Configuration.headless = false; //настройка отображения экрана
    }

    @BeforeEach
    public void init() { //вызов метода setUp
        setUp();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver(); //закрытие вебдрайвера
    }

}
