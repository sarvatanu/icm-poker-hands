package au.com.icm.poker.games;


import org.junit.Test;

public class GameTests {

    @Test
    public void testGameShouldReturnNonEmptyHandsForTwoPlayers() {
        String[] player1 = {"6C", "5H", "AS", "4H", "7S"};
        String[] player2 = {"2S", "KD", "7H", "2C", "AC"};

        Game game = Game.build(player1, player2);

        assert game.getPlayer1() != null;
        assert game.getPlayer2() != null;
    }

    @Test
    public void testGameGetWinningHandShouldReturnPlayer2WithFlushOfDiamond() {
        String[] player1 = {"2D", "9C", "AS", "AH", "AC"};
        String[] player2 = {"3D", "6D", "7D", "TD", "QD"};
        Game game = Game.build(player1, player2);

        Hand winnderHand = game.getWinner();
        assert winnderHand.getPlayerId() == 2;
    }

    @Test
    public void testGameGetWinningHandShouldReturnPlayer2ForPairOf9() {
        String[] player1 = {"4H", "4C", "6S", "7H", "KD"};
        String[] player2 = {"2C", "3S", "9S", "9D", "TD"};
        Game game = Game.build(player1, player2);

        Hand winnderHand = game.getWinner();
        assert winnderHand.getPlayerId() == 2;
    }

    @Test
    public void testGameGetWinningHandShouldReturnPlayer1ForHighestCardOfAce() {
        String[] player1 = {"5D", "8C", "9S", "JS", "AC"};
        String[] player2 = {"2C", "5C", "7D", "8S", "QH"};
        Game game = Game.build(player1, player2);

        Hand winnderHand = game.getWinner();
        assert winnderHand.getPlayerId() == 1;
    }

    @Test
    public void testGameGetWinningHandShouldReturnPlayer2ForHighestCardof9() {
        String[] player1 = {"4D", "6S", "9H", "QH", "QC"};
        String[] player2 = {"3D", "6D", "7H", "QD", "QH"};
        Game game = Game.build(player1, player2);

        Hand winnderHand = game.getWinner();
        assert winnderHand.getPlayerId() == 1;
    }

    @Test
    public void testGameGetWinningHandShouldReturnPlayer1ForThreeFours() {
        String[] player1 = {"2H", "2D", "4C", "4D", "4S"};
        String[] player2 = {"3C", "3D", "3S", "9S", "9D"};
        Game game = Game.build(player1, player2);

        Hand winnderHand = game.getWinner();
        assert winnderHand.getPlayerId() == 1;
    }
}
