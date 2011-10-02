package bowling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LastFrameTest
{
    private LastFrame lastFrame;

    @Before
    public void setup()
    {
        lastFrame = new LastFrame();
    }

    private void rollStrike()
    {
        lastFrame.roll(10);
    }

    private void rollSpare(int pins)
    {
        lastFrame.roll(pins);
        lastFrame.roll(10 - pins);
    }
    

    @Test
    public void testLastFrameIsNotOverWithOneStrike()
    {
        rollStrike();

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void testLastFrameIsNotOverWithOneStrikeAndOneMoreRoll()
    {
        rollStrike();
        lastFrame.roll(5);

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void testLastFrameIsOverWithOneStrikeAndTwoMoreRoll()
    {
        rollStrike();
        lastFrame.roll(5);
        lastFrame.roll(3);

        assertTrue(lastFrame.isOver());
    }

    @Test
    public void testLastFrameIsNotOverWithASpare()
    {
        rollSpare(3);

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void testLastFrameIsOverWithASpareAndOneMoreRoll()
    {
        rollSpare(3);
        lastFrame.roll(6);

        assertTrue(lastFrame.isOver());
    }

    @Test
    public void testLastFrameIsNotOverWithOneRoll()
    {
        lastFrame.roll(3);

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void testLastFrameIsOverWithTwoRollsAndPinsLeft()
    {
        lastFrame.roll(3);
        lastFrame.roll(5);

        assertTrue(lastFrame.isOver());
    }
    
    @Test
    public void testScoreOfOrdinaryLastFrameIsTotalOfPinsInTwoRolls()
    {
        lastFrame.roll(2);
        lastFrame.roll(6);
        
        assertEquals(8, lastFrame.score());
    }

    @Test
    public void testScoreOfSpareLastFrameIsTotalOfPinsInThreeRolls()
    {
        rollSpare(4);
        lastFrame.roll(2);
        
        assertEquals(12, lastFrame.score());
    }

    @Test
    public void testScoreOfStrikeLastFrameIsTotalOfPinsInThreeRolls()
    {
        rollStrike();
        lastFrame.roll(6);
        lastFrame.roll(2);
        
        assertEquals(18, lastFrame.score());
    }
}
