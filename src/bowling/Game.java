package bowling;

public class Game
{
    private static final int NUM_FRAMES = 10;
    private static final int LAST_FRAME = NUM_FRAMES - 1;

    private final Frame[] frames = new Frame[NUM_FRAMES];
    private int currentFrame;

    public Game()
    {
        initFrames();
    }

    private void initFrames()
    {
        for (int i = 0; i < LAST_FRAME; i++)
            frames[i] = new Frame();

        frames[LAST_FRAME] = new LastFrame();

        for (int i = 0; i < LAST_FRAME; i++)
            frames[i].setNextFrame(frames[i + 1]);
    }

    public void roll(int pins)
    {
        currentFrame().roll(pins);

        if (currentFrame().isOver())
            moveToNextFrame();
    }

    private int moveToNextFrame()
    {
        return currentFrame++;
    }

    private Frame currentFrame()
    {
        return frames[currentFrame];
    }

    public int score()
    {
        int score = 0;
        for (Frame frame : frames)
            score += frame.scoreWithBouns();
        return score;
    }
}
