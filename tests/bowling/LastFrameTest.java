package bowling;

import static org.junit.Assert.assertFalse;

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
}
