package bowling;

public class Frame
{
    private static final int MAX_ROLLS = 2;

    protected int[] rolls;
    protected int currentRoll = 0;

    private Frame nextFrame;

    public Frame()
    {
        init();
    }

    protected void init()
    {
        rolls = new int[MAX_ROLLS];
    }

    public void setNextFrame(Frame nextFrame)
    {
        this.nextFrame = nextFrame;
    }

    public void roll(int pins)
    {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    public int score()
    {
        if (isStrike())
            return 10 + nextFrame.strikeBonusForPreviousFrame();
        else if (isSpare())
            return 10 + nextFrame.spareBonusForPreviousFrame();
        else
            return firstRoll() + secondRoll();
    }

    int strikeBonusForPreviousFrame()
    {
        return firstRoll() + secondRoll();
    }

    int spareBonusForPreviousFrame()
    {
        return firstRoll();
    }

    protected int firstRoll()
    {
        return rolls[0];
    }

    protected int secondRoll()
    {
        return rolls[1];
    }

    public boolean isOver()
    {
        return isStrike() || currentRoll == 2;
    }

    public boolean isSpare()
    {
        return !isStrike() && firstRoll() + secondRoll() == 10;
    }

    public boolean isStrike()
    {
        return firstRoll() == 10;
    }
}
