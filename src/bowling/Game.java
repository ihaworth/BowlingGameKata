package bowling;

public class Game
{
    private int score;

    public void roll(int pins)
    {
        currentFrame().roll(pins);
        score += pins;
    }

    private Frame currentFrame()
    {
        return new Frame();
    }

    public int score()
    {
        return score;
    }
}
