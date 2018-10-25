package nl.hva.ict.ds;

import java.util.List;
import static junit.framework.TestCase.assertEquals;
import nl.hva.ict.ds.util.LinearProbingMultiValueSymbolTable;
import org.junit.Test;

/**
 * If you have any tests that should be overwritten or added please put them to this class.
 */
public class ExtendedPlayerFinderTest extends HighScorePlayerFinderTest {
    
    
    @Test
    public void linearTest(){
        highscores.add(harry);
        List<Player> harrys = highscores.findPlayer("Harry", null);
        
        assertEquals(2, harrys.size());
        assertEquals(harry, harrys.get(0));
    }

    
}
