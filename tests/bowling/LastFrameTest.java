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

    @Test
    public void testLastFrameIsNotOverWithOneStrike()
    {
        lastFrame.roll(10);

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void testLastFrameIsNotOverWithOneStrikeAndOneMoreRoll()
    {
        lastFrame.roll(10);
        lastFrame.roll(5);

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void testLastFrameIsOverWithOneStrikeAndTwoMoreRoll()
    {
        lastFrame.roll(10);
        lastFrame.roll(5);
        lastFrame.roll(3);

        assertTrue(lastFrame.isOver());
    }

    @Test
    public void testLastFrameIsNotOverWithASpare()
    {
        lastFrame.roll(3);
        lastFrame.roll(7);

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void testLastFrameIsOverWithASpareAndOneMoreRoll()
    {
        lastFrame.roll(3);
        lastFrame.roll(7);

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
        lastFrame.roll(4);
        lastFrame.roll(6);
        
        lastFrame.roll(2);
        
        assertEquals(12, lastFrame.score());
    }
    
    @Test
    public void testScoreOfStrikeLastFrameIsTotalOfPinsInThreeRolls()
    {
        lastFrame.roll(10);
        lastFrame.roll(6);
        lastFrame.roll(2);
        
        assertEquals(18, lastFrame.score());
    }
}
