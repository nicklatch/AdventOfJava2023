package org.godDamnElves.dayOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PartOne implements DayOne{

  private final List<Integer> intList;

  public PartOne() {
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
    String[] cleanedLine = line.replaceAll("\\D", "").split("");
    intList.add(Integer.parseInt(cleanedLine[0] + cleanedLine[cleanedLine.length - 1]));
  }

  public int getSum() {
    return intList.stream().reduce(0, Integer::sum);
  }
}
