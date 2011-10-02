package bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest
{
    @Test
    public void testGutterFrame()
    {
        Frame frame = new Frame();
        
        frame.roll(0);
        frame.roll(0);
        
        assertEquals(0, frame.score());
    }
    
    @Test
    public void testAllOnes()
    {
        Frame frame = new Frame();
        
        frame.roll(1);
        frame.roll(1);
        
        assertEquals(2, frame.score());
    }
}
