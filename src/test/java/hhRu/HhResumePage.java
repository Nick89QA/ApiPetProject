package hhRu;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HhResumePage {

    private final SelenideElement checkGender = $x("//span[@data-qa='resume-personal-gender']");
    private final SelenideElement age = $x("//span[@data-qa='resume-personal-age']/span");
    private final SelenideElement city = $x("//span[@data-qa='resume-personal-address']");

    /**
     * в конструкторе передаем url который находится в HhTest.java
     * @param url
     */
    public HhResumePage(String url) {
        Selenide.open(url);
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


}
