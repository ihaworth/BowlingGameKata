package bowling;

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
}
