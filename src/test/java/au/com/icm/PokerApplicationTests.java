package au.com.icm;


import au.com.icm.poker.games.Game;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class PokerApplicationTests {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testPokerGameShouldReadInputPokerHands() {

        setInputStream("poker-hands.txt");

        List<Game> gamesPlayed = PokerApplication.parsePokerHands();

        assert gamesPlayed != null;
    }

    @Test
    public void testPokerGameShouldThrowAssertionException() {

        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("Invalid number of Cards in 6C 5H AS 4H 7S 2S KD 7H 2C");

        setInputStream("Invalid_poker-hands.txt");

        List<Game> gamesPlayed = PokerApplication.parsePokerHands();
    }

    @Test
    public void testPokerGamePrintWinningHandCountShouldReturn3HandWinForPlayer1() {

        setInputStream("poker-hands.txt");

        List<Game> gamesPlayed = PokerApplication.parsePokerHands();
        Long gamesWon = PokerApplication.printWinningHandCount(gamesPlayed);

        assert gamesWon == 3;
    }

    /**
     * Classpath file InputStream reader for testing.
     */
    private void setInputStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try {
            final FileInputStream fileInputStream = new FileInputStream(file);
            System.setIn(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
