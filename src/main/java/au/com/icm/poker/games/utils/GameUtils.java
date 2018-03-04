package au.com.icm.poker.games.utils;


import au.com.icm.poker.games.Game;

import java.util.stream.IntStream;

public class GameUtils {

    public static Game parsePlayerCards(String gamePlayed) {

        String[] hands = gamePlayed.split(" ");

        String[] player1 = IntStream.range(0, 5)
                .mapToObj(i -> hands[i])
                .toArray(String[]::new);

        String[] player2 = IntStream.range(5, 10)
                .mapToObj(i -> hands[i])
                .toArray(String[]::new);

        Game game = Game.build(player1, player2);
        return game;
    }


}
