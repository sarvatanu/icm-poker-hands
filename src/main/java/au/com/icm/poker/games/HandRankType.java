package au.com.icm.poker.games;


public enum HandRankType {
    STRAIGHT_FLUSH(8000000),
    FOUR_OF_A_KIND(7000000),
    FULL_HOUSE(6000000),
    FLUSH(5000000),
    STRAIGHT(4000000),
    THREE_OF_A_KIND(3000000),
    TWO_PAIRS(2000000),
    PAIR(1000000);

    private Integer rank;

    HandRankType(Integer rank) {
        this.rank = rank;
    }

    public Integer getRank() {
        return rank;
    }
}
