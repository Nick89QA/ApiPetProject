package hhRu;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import core.BaseTest;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(ScreenShooterExtension.class)
public class HhTest extends BaseTest {

    private final static String URL = "https://hh.ru/applicant/resumes/view?resume=1edf0c93ff095811d20039ed1f6a3638497073";

    @Test
    public void checkAttributesHashMap() {

        /**
         * Ожидаемые атрибуты в виде хешмапы
         * ключи лежат в hhResumePage
         */
        HhResumePage hhResumePage = new HhResumePage(URL);

        Map<String, Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(HhResumePage.GENDER, "М");
        expectedAttributes.put(HhResumePage.AGE, "26");
        expectedAttributes.put(HhResumePage.CITY, "Санкт-Петербург");
        expectedAttributes.put(HhResumePage.Confirmed_Phone, true);
        expectedAttributes.put(HhResumePage.READY_TO_RELOCATE, true);

        Map<String, Object> actualAttributes = hhResumePage.getAttributes();
        Assert.assertEquals(expectedAttributes, actualAttributes);

    }

    /**
     * создаем экземпляры класа
     * вызываем через геттер эти методы
     */
    @Test
    public void checkAttributesClass() {
        HhResumePage hhResumePage = new HhResumePage(URL);
        Resume expectedAttributes = new Resume("M",26,"Санкт-Петербург",true,
                true);
        Resume actualAttributes = new Resume(hhResumePage.getGender(),hhResumePage.getAge(),hhResumePage.getCity(),
                hhResumePage.isPhoneConfirmed(),hhResumePage.isReadyToRelocate());
        Assert.assertTrue(EqualsBuilder.reflectionEquals(01,02));
    }


}
