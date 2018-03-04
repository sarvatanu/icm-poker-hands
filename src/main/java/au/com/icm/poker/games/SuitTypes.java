package au.com.icm.poker.games;

public enum SuitTypes {
    SPADES("S", 1),
    CLUBS("C", 2),
    DIAMONDS("D", 3),
    HEARTS("H", 4),
    INVALID("I", -1);

    private String type;
    private int suitRank;

    SuitTypes(String type, int suitRank) {
        this.type = type;
        this.suitRank = suitRank;
    }

    public String getType() {
        return type;
    }

    public int getSuitRank() {
        return suitRank;
    }

    public static SuitTypes fromCode(String str) {
        for (SuitTypes val : SuitTypes.values()) {
            if (str.equals(val.getType())) {
                return val;
            }
        }
        return INVALID;
    }
}
