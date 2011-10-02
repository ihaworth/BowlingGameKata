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
    
    @Test
    public void testFrameWithNoRollsIsNotOver()
    {
        assertFalse(frame.isOver());
    }
    
    @Test
    public void testFrameWithOneRollIsNotOver()
    {
        frame.roll(1);

        assertFalse(frame.isOver());
    }
    
    @Test
    public void testFrameWithTwoRollsIsOver()
    {
        frame.roll(1);
        frame.roll(1);

        assertTrue(frame.isOver());
    }
    
//    @Test
//    public void testScoreSpareFrameDependsUponNextFrame()
//    {
//        Frame nextFrame = new Frame();
//        frame.setNextFrame(nextFrame);
//        
//        frame.roll(3);
//        frame.roll(7);
//        
//        nextFrame.roll(6);
//        
//        assertEquals(16, frame.score());
//    }
}
