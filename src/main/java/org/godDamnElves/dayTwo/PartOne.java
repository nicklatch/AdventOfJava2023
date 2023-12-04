package org.godDamnElves.dayTwo;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PartOne {

  // INCOMPLETE

  private static final List<Integer> validGameIDs = new ArrayList<>();

  public static int parseGames(String filePath) {
    try (BufferedReader reader = Files.newBufferedReader(
        Path.of(filePath)); Stream<String> lines = reader.lines()) {

      lines.forEach(line -> {
        var valid = new Game(line).getValidGame();
        if (valid != 0) {
          validGameIDs.add(valid);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }

    return validGameIDs.stream().reduce(0, Integer::sum);
  }
}
