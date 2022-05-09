package hhRu;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;
import static javax.swing.UIManager.put;

public class HhResumePage {

    private final SelenideElement checkGender = $x("//span[@data-qa='resume-personal-gender']");
    private final SelenideElement age = $x("//span[@data-qa='resume-personal-age']/span");
    private final SelenideElement city = $x("//span[@data-qa='resume-personal-address']");
    private final SelenideElement liveData = $x("//span[@data-qa='resume-personal-address']/ancestor::p");
    private final SelenideElement tick = $x("//div[@data-qa='resume-contacts-phone']/span[1]");

    /**
     * ключи для хешкарты
     */
    public static String GENDER = "Пол";
    public static String CITY = "Город";
    public static String AGE = "Возраст";
    public static String Confirmed_Phone = "Подтвержденный номер";
    public static String READY_TO_RELOCATE = "Готовность к переезду";

    /**
     * в конструкторе передаем url который находится в HhTest.java
     * @param url
     */
    public HhResumePage(String url) {
        Selenide.open(url);
    }

    /**
     * метод проверяет наличие галочки на дисплее
     * @return
     */
    public boolean isPhoneConfirmed() {
       return tick.isDisplayed();
    }

    /**
     * создали хешкарту и положили актуальные результаты
     * @return
     */
    public Map<String,Object> getAttributes() {
        return new HashMap<String, Object>(){{
        put(GENDER, getGenderHard());
        put(AGE, getAge());
        put(CITY, getCity());
        put(Confirmed_Phone, isPhoneConfirmed());
        put(READY_TO_RELOCATE, isReadyToRelocate());
            }};
    }

    public String getCity() {
        return city.getText();
    }

    /**
     * метод который сравнивает текст в переменной
     * @return
     */
    public String getGenderHard() {
      return checkGender.getText().equals("Мужчина") ? "М" : "Ж";
    }

    public int getAge() {
     return Integer.parseInt(age.getText().replaceAll("\\D+", ""));
    }

    public boolean isReadyToRelocate() {
        return liveData.getText().split("")[1].equals("не готов к переезду");

    }


}
