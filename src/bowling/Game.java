package bowling;

public class Game
{
    private Frame[] frames = new Frame[10];
    private int currentFrame;

    public Game()
    {
        for (int i = 0; i < 10; i++)
            frames[i] = new Frame();
    }

    public void roll(int pins)
    {
        currentFrame().roll(pins);
        
        if (currentFrame().isOver())
            currentFrame++;
    }

    private Frame currentFrame()
    {
        return frames[currentFrame];
    }

    public int score()
    {
        int score = 0;
        for (Frame frame : frames)
            score += frame.score();
        return score;
    }
}
