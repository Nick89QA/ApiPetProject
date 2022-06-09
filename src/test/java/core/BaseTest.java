package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


abstract public class BaseTest {

    /**
     * Инициализация selenide с настройками
     */

    public void setUp() {
        WebDriverManager.chromedriver().setup(); //установка хромдрайвера при запуске
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true; //разрешение для вебдрайвер менеджера
        Configuration.browserSize = "1920*1080"; //разрешение браузера
        Configuration.headless = true; //настройка отображения экрана
    }

    /**
     * Метод выполняется перед каждым запуском
     */

    @BeforeEach
    public void init() { //вызов метода setUp
        setUp();
    }

    /**
     * Метод выполняется после запуска
     */

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver(); //закрытие вебдрайвера
    }

}
