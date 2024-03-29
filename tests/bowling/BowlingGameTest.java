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

    @Test
    public void gutterGameScoresZero()
    {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    @Test
    public void allOnesScoresTwenty()
    {
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    @Test
    public void oneSpareGetsSpareBouns()
    {
        rollSpare(5);
        g.roll(3);
        rollMany(17, 0);
        assertEquals(16, g.score());
    }

    @Test
    public void oneStrikeGetsStrikeBonus()
    {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    @Test
    public void perfectGameScores300()
    {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }

    private void rollStrike()
    {
        g.roll(10);
    }

    private void rollSpare(int pins)
    {
        g.roll(pins);
        g.roll(10 - pins);
    }

    private void rollMany(int n, int pins)
    {
        for (int i = 0; i < n; i++)
            g.roll(pins);
    }
}
