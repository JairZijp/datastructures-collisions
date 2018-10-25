package nl.hva.ict.ds;

import nl.hva.ict.ds.util.LinearProbingMultiValueSymbolTable;
import org.junit.Test;

/**
 * If you have any tests that should be overwritten or added please put them to this class.
 */
public class ExtendedPlayerFinderTest extends HighScorePlayerFinderTest {
    
    
    @Test
    public void linearTest(){
        voldemort = new Player("polygene", "lubricants", harry.getHighScore() - 10);
        LinearProbingMultiValueSymbolTable table = new LinearProbingMultiValueSymbolTable(7);
        table.put(nearlyHeadlessNick.getFirstName(), nearlyHeadlessNick);
    }

    
}
