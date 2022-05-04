package hhRu;

import core.BaseTest;
import org.junit.Test;

public class HhTest extends BaseTest {

  private final static String URL ="https://hh.ru/applicant/resumes/view?resume=1edf0c93ff095811d20039ed1f6a3638497073";

  @Test
  public void checkAttributesHashMap(){

      HhResumePage hhResumePage = new HhResumePage(URL);
      hhResumePage.getGenderHard();

  }

}
