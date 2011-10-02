package bowling;

import static org.junit.Assert.assertEquals;

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
    public void testGutterFrame()
    {
        frame.roll(0);
        frame.roll(0);
        
        assertEquals(0, frame.score());
    }
    
    @Test
    public void testAllOnes()
    {
        frame.roll(1);
        frame.roll(1);
        
        assertEquals(2, frame.score());
    }
}
