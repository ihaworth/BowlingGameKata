package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest
{
    private Game g;

    @Before
    public void setup()
    {
        g = new Game();
    }

    private void rollMany4(int n, int pins)
    {
        for (int i = 0; i < n; i++)
            g.roll(pins);
    }

    @Test
    public void testGutterGame()
    {
        rollMany4(20, 0);
        assertEquals(0, g.score());
    }
    
    @Test
    public void testAllOnes()
    {
        rollMany4(20, 1);
        assertEquals(20, g.score());
    }
}
