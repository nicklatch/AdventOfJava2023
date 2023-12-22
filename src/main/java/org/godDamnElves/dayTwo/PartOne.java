package org.godDamnElves.dayTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PartOne {

  public static void main(String[] args) throws IOException {
    System.out.println(fileHandler("src/main/resources/dayTwoPartOneData.txt"));
  }

  public static int fileHandler(String filePath) throws IOException {
    List<Integer> validSum = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(
        Path.of(filePath)); Stream<String> lines = reader.lines()) {
      lines.forEach(line -> {
        if (validityChecker(gameParser(line))) {
          validSum.add(Integer.parseInt(idExtractor(line.substring(0, line.indexOf(":")))));
        }
      });
    } catch (IOException eIO) {
      eIO.printStackTrace();
      throw new IOException("File not found or something else, man", eIO);
    }
    return validSum.stream().reduce(0, Integer::sum);
  }

  public static List<List<String>> gameParser(String game) {
    List<String> splitGames = Arrays.stream(
        game.substring(game.indexOf(": ") + 1).trim().split(";\\s")).toList();

    return splitGames.stream().map(g -> Arrays.stream(g.split(", ")).toList()).toList();

  }

  public static String idExtractor(String part) {
    return part.split("\\s")[1];
  }

  public static boolean validityChecker(List<List<String>> games) {
    List<Boolean> valid = new ArrayList<>();

    games.forEach(game -> {
      game.forEach(blocks -> {
        switch (blocks.split("")[1]) {
          case "red" -> valid.add(Integer.parseInt(blockSplit[0]) <= 12);
          case "green" -> valid.add(Integer.parseInt(blockSplit[0]) <= 13);
          case "blue" -> valid.add(Integer.parseInt(blockSplit[0]) <= 14);
        }
      });
    });
    return !valid.contains(false);
  }

}
