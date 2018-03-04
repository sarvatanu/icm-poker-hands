package au.com.icm.poker.games;


public final class Game {

    private final Hand player1;
    private final Hand player2;
    private final Hand winner;

    private Game(String[] player1, String[] player2) {
        this.player1 = Hand.build(player1, 1);
        this.player2 = Hand.build(player2, 2);
        winner = findWinningHand();
    }

    public static Game build(String[] player1, String[] player2) {
        return new Game(player1, player2);
    }

    public Hand getPlayer1() {
        return player1;
    }

    public Hand getPlayer2() {
        return player2;
    }

    public Hand getWinner() {
        return winner;
    }

    private Hand findWinningHand() {
        if (player1.getPokerHandValue() > player2.getPokerHandValue()) {
            return player1;
        } else {
            return player2;
        }
    }
}
