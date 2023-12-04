import java.util.Arrays;
import org.godDamnElves.dayOne.PartOne;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOnePartOneTest {

  private PartOne tester = new PartOne();

  @Test
  public void dayOnePartOneCalibrationSum() throws IOException {
    var testData = new String[]{"1abc2",
        "pqr3stu8vwx",
        "a1b2c3d4e5f",
        "treb7uchet"};

    Arrays.stream(testData).toList().forEach(line -> tester.calibrationSum(line));
    assertEquals(tester.getSum(), 142);
  }

  @Test
  public void dayOnePartOneReturnsCorrectWithAOCData() throws IOException {
    tester.calibrationDocumentHandler("src/main/resources/dayOnePartOneData.txt");
    assertEquals(tester.getSum(), 52974);
  }


}
