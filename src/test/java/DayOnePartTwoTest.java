import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import org.godDamnElves.dayOne.PartOne;
import org.godDamnElves.dayOne.PartTwo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayOnePartTwoTest {

  private final PartTwo tester = new PartTwo();

  private static final String[] testData = {"two1nine", "eightwothree", "abcone2threexyz",
      "xtwone3four", "4nineeightseven2", "zoneight234", "7pqrstsixteen"};

  @Test
  public void swapNameWithNumTest() {
    assertEquals(PartTwo.swapNameWithNum(testData[0]), "t2o1n9e");
    assertEquals(PartTwo.swapNameWithNum(testData[1]), "e8t2othree3three");
  }

  @Test
  public void calibrationSumTest() {
    Arrays.stream(testData).toList().forEach(tester::calibrationSum);
    assertEquals(tester.getSum(), 281);
  }

  @Test
  public void partTwoReturnsCorrectWithAOCData() throws IOException {
    tester.calibrationDocumentHandler("src/main/resources/dayOnePartOneData.txt");
    assertEquals(tester.getSum(), 53340);
  }

}
