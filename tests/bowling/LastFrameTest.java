package bowling;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LastFrameTest
{
    private LastFrame lastFrame;

    @Test
    public void testLastFrameIsNotOverWithOneStrike()
    {
        lastFrame = new LastFrame();
        lastFrame.roll(10);

        assertFalse(lastFrame.isOver());
    }

    @Test
    public void testLastFrameIsOverWithOneStrikeAndAnotherRoll()
    {
        lastFrame = new LastFrame();
        lastFrame.roll(10);
        lastFrame.roll(5);

        assertTrue(lastFrame.isOver());
    }
}
