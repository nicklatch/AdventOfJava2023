package org.godDamnElves.dayOne;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class PartTwo implements DayOne {

  private final List<Integer> intList;

  public PartTwo() {
    this.intList = new ArrayList<>();
  }

  @Override
  public void calibrationDocumentHandler(String filePath) {
    try (BufferedReader reader = Files.newBufferedReader(
        Path.of(filePath)); Stream<String> lines = reader.lines()) {
      lines.forEach(this::calibrationSum);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void calibrationSum(String line) {
    var swappedLine = swapNameWithNum(line);
    String[] cleanedLine = swappedLine.replaceAll("\\D", "").split("");
    intList.add(Integer.parseInt(cleanedLine[0] + cleanedLine[cleanedLine.length - 1]));
  }

  public static String swapNameWithNum(String input) {
    return input.replaceAll("one", "one1one").replaceAll("two", "t2o")
        .replaceAll("three", "three3three").replaceAll("four", "f4r")
        .replaceAll("five", "five5five").replaceAll("six", "s6x")
        .replaceAll("seven", "seven7seven").replaceAll("eight", "e8t")
        .replaceAll("nine", "n9e");
  }

  @Override
  public int getSum() {
    return intList.stream().reduce(0, Integer::sum);
  }


}