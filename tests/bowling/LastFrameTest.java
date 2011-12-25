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
    public void lastFrameIsNotOverWithOneStrike()
    {
        rollStrike();

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void lastFrameIsNotOverWithOneStrikeAndOneMoreRoll()
    {
        rollStrike();
        lastFrame.roll(5);

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void lastFrameIsOverWithOneStrikeAndTwoMoreRolls()
    {
        rollStrike();
        lastFrame.roll(5);
        lastFrame.roll(3);

        assertTrue(lastFrame.isOver());
    }

    @Test
    public void lastFrameIsNotOverWithASpare()
    {
        rollSpare(3);

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void lastFrameIsOverWithASpareAndOneMoreRoll()
    {
        rollSpare(3);
        lastFrame.roll(6);

        assertTrue(lastFrame.isOver());
    }

    @Test
    public void lastFrameIsNotOverWithOneRoll()
    {
        lastFrame.roll(3);

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void lastFrameIsOverWithTwoRollsAndPinsLeft()
    {
        lastFrame.roll(3);
        lastFrame.roll(5);

        assertTrue(lastFrame.isOver());
    }

    @Test
    public void scoreOfOrdinaryLastFrameIsTotalOfPinsInTwoRolls()
    {
        lastFrame.roll(2);
        lastFrame.roll(6);

        assertEquals(8, lastFrame.scoreWithBouns());
    }

    @Test
    public void scoreOfSpareLastFrameIsTotalOfPinsInThreeRolls()
    {
        rollSpare(4);
        lastFrame.roll(2);

        assertEquals(12, lastFrame.scoreWithBouns());
    }

    @Test
    public void scoreOfStrikeLastFrameIsTotalOfPinsInThreeRolls()
    {
        rollStrike();
        lastFrame.roll(6);
        lastFrame.roll(2);

        assertEquals(18, lastFrame.scoreWithBouns());
    }

    @Test
    public void strikeBonusForPreviousFrameIsTotalOfFirstTwoRolls()
    {
        lastFrame.roll(6);
        lastFrame.roll(2);

        assertEquals(8, lastFrame.strikeBonusForPreviousFrame());
    }

    @Test
    public void strikeBonusForPreviousFrameIsTotalOfFirstTwoRollsWhenLastFrameStartsWithAStrike()
    {
        rollStrike();
        lastFrame.roll(2);

        assertEquals(12, lastFrame.strikeBonusForPreviousFrame());
    }
}
