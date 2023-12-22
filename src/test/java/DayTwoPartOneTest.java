import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.godDamnElves.dayTwo.PartOne;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class DayTwoPartOneTest {

  @Test
  void testGameParser() {
    String input = "1: red 12, green 11, blue 10; red 12, green 11, blue 10";
    List<List<String>> expected = List.of(List.of("red 12", "green 11", "blue 10"),
        List.of("red 12", "green 11", "blue 10"));

    List<List<String>> actual = PartOne.gameParser(input);

    assertEquals(expected, actual);
  }

  @Test
  void testIdExtractor() {
    String input = "Elf 123:";
    String expected = "123:";

    String actual = PartOne.idExtractor(input);

    assertEquals(expected, actual);
  }

  @Test
  void testValidityChecker_valid() {
    List<List<String>> input = List.of(List.of("red 12", "green 11", "blue 10"),
        List.of("red 12", "green 11", "blue 10"));

    boolean expected = true;

    boolean actual = PartOne.validityChecker(input);

    assertEquals(expected, actual);
  }

  @Test
  void testValidityChecker_invalid() {
    List<List<String>> input = List.of(List.of("red 12", "green 11", "blue 10"),
        List.of("red 15", "green 11", "blue 10"));

    boolean expected = false;

    boolean actual = PartOne.validityChecker(input);

    assertEquals(expected, actual);
  }

  @Test
  void testFileHandler() throws IOException {
    int expected = 2617;
    int actual = PartOne.fileHandler("src/main/resources/dayTwoPartOneData.txt");

    assertEquals(expected, actual);
  }

}

