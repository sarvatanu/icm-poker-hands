package au.com.icm;


import au.com.icm.poker.games.Game;
import au.com.icm.poker.games.utils.GameUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PokerApplication {

    public static void main(String... arg) {
        try {
            List<Game> gamesPlayed = parsePokerHands();
            Long gamesWonByPlayer1 = printWinningHandCount(gamesPlayed);

            System.out.println(String.format("Total Games Played: %d", gamesPlayed.size()));
            System.out.println(String.format("Player 1: %d hands", gamesWonByPlayer1));
            System.out.println(String.format("Player 2: %d hands", (gamesPlayed.size() - gamesWonByPlayer1)));

        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Game> parsePokerHands() throws AssertionError {
        Scanner inputScanner = new Scanner(System.in);
        List<Game> gamesPlayed = new ArrayList<>();

        while (inputScanner.hasNext()) {
            String readLine = inputScanner.nextLine();
            String[] numberOfCards = readLine.split(" ");
            assert numberOfCards.length == 10 : String.format("Invalid number of Cards in %s", readLine);
            gamesPlayed.add(GameUtils.parsePlayerCards(readLine));
        }
        inputScanner.close();

        return gamesPlayed;
    }

    public static Long printWinningHandCount(List<Game> games) {
        Predicate<Game> predicate = game -> game.getWinner().getPlayerId() == 1;
        Long gamesWonByPlayer1 = games.stream().filter(predicate).count();
        return gamesWonByPlayer1;
    }
}
