package bowling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FrameTest
{
    private Frame frame;

    @Before
    public void setup()
    {
        frame = new Frame();
    }

    @Test
    public void gutterFrameScoresZero()
    {
        frame.roll(0);
        frame.roll(0);

        assertEquals(0, frame.scoreWithBouns());
    }

    @Test
    public void twoOnesScoresTwo()
    {
        frame.roll(1);
        frame.roll(1);

        assertEquals(2, frame.scoreWithBouns());
    }

    @Test
    public void frameWithNoRollsIsNotOver()
    {
        assertFalse(frame.isOver());
    }

    @Test
    public void frameWithOneRollIsNotOver()
    {
        frame.roll(1);

        assertFalse(frame.isOver());
    }

    @Test
    public void frameWithTwoRollsIsOver()
    {
        frame.roll(1);
        frame.roll(1);

        assertTrue(frame.isOver());
    }

    @Test
    public void frameWithAStrikeIsOver()
    {
        frame.roll(10);

        assertTrue(frame.isOver());
    }

    @Test
    public void spareFrameGets1BonusFromNextFrame()
    {
        Frame nextFrame = new Frame();
        frame.setNextFrame(nextFrame);

        frame.roll(3);
        frame.roll(7);

        nextFrame.roll(6);
        nextFrame.roll(3);

        assertEquals(16, frame.scoreWithBouns());
    }

    @Test
    public void strikeFrameGets2BonuesFromNextFrame()
    {
        Frame nextFrame = new Frame();
        frame.setNextFrame(nextFrame);

        frame.roll(10);

        nextFrame.roll(6);
        nextFrame.roll(3);

        assertEquals(19, frame.scoreWithBouns());
    }

    @Test
    public void strikeFollowedByStrikeGetsBonusFromNextFrameAndNextButOneFrame()
    {
        Frame nextFrame = new Frame();
        Frame nextButOneFrame = new Frame();
        frame.setNextFrame(nextFrame);
        nextFrame.setNextFrame(nextButOneFrame);

        frame.roll(10);
        nextFrame.roll(10);
        nextButOneFrame.roll(5);
        nextButOneFrame.roll(4);

        assertEquals(25, frame.scoreWithBouns());
    }

    @Test
    public void pinsLeftStandingIsNotASpare()
    {
        frame.roll(1);
        frame.roll(1);

        assertFalse(frame.isSpare());
    }

    @Test
    public void noPinsLeftStandingWithTwoRollsIsASpare()
    {
        frame.roll(3);
        frame.roll(7);

        assertTrue(frame.isSpare());
    }

    @Test
    public void aStrikeIsNotASpare()
    {
        frame.roll(10);

        assertFalse(frame.isSpare());
    }

    @Test
    public void pinsLeftStandingIsNotAStrike()
    {
        frame.roll(1);
        frame.roll(1);

        assertFalse(frame.isStrike());
    }

    @Test
    public void aSpareIsNotAStrike()
    {
        frame.roll(3);
        frame.roll(7);

        assertFalse(frame.isStrike());
    }

    @Test
    public void hitAllPinsWithFirstRollIsAStrike()
    {
        frame.roll(10);

        assertTrue(frame.isStrike());
    }
}
