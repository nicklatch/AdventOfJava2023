package org.godDamnElves.dayTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

  // TODO: left off here
  private final Map<String, Integer> scores;
  private final int gameID;
  private final boolean validGame;


  public Game(String game) {
    String[] parsed = game.split(": ");
    this.scores = scoreGame(parseGameString(parsed[1]));
    this.gameID = Integer.parseInt(parseGameID(parsed[0]));
    this.validGame = setValidGame();
  }

  private static String parseGameID(String gameInfo) {
    return gameInfo.substring(gameInfo.indexOf('\s')).trim();
  }

  private static String[] parseGameString(String gameHands) {
    String[] splitToRounds = gameHands.trim().split(";");
    System.out.println(Arrays.toString(Arrays.stream(splitToRounds).map(x -> x)));

    return splitToRounds;
  }

  private Map<String, Integer> scoreGame(String[] game) {

    Map<String, Integer> gameCubes = new HashMap<>(Map.of("r", 0, "g", 0, "b", 0));

    Arrays.stream(game).map(String::trim).toList().forEach(hand -> {
      var splitHand = hand.split(" ");
      switch (splitHand[1]) {
        case "red" -> gameCubes.put("r", gameCubes.get("r") + Integer.parseInt(splitHand[0]));
        case "green" -> gameCubes.put("g", gameCubes.get("g") + Integer.parseInt(splitHand[0]));
        case "blue" -> gameCubes.put("b", gameCubes.get("b") + Integer.parseInt(splitHand[0]));
      }
    });

    System.out.println();

    return gameCubes;
  }

  private boolean setValidGame() {
    if (scores.get("r") > 12) {
      return false;
    } else if (scores.get("g") > 13) {
      return false;
    } else {
      return scores.get("b") <= 14;
    }
  }

  public int getValidGame() {
    System.out.println(validGame ? gameID : 0);
    return validGame ? gameID : 0;
  }
}
