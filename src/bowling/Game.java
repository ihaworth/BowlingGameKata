package bowling;

public class Game
{
    private int score;
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
        score += pins;
    }

    private Frame currentFrame()
    {
        return frames[currentFrame];
    }

    public int score()
    {
        return score;
    }
}
