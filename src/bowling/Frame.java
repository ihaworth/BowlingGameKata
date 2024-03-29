package bowling;


public class Frame
{
    private static final int MAX_ROLLS = 2;
    private static final int BONUS_WORTHY_SCORE = 10;

    protected int[] rolls;
    private int currentRoll = 0;

    private Frame nextFrame;

    public Frame()
    {
        init();
    }

    private void init()
    {
        rolls = new int[maxRolls()];
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

    public int scoreWithBouns()
    {
        if (isStrike())
            return firstRoll() + nextFrame.strikeBonusForPreviousFrame();
        else if (isSpare())
            return frameTotal() + nextFrame.spareBonusForPreviousFrame();
        else
            return frameTotal();
    }

    int strikeBonusForPreviousFrame()
    {
        if (isStrike())
            return firstRoll() + nextFrame.firstRoll();
        else
            return frameTotal();
    }

    private int frameTotal()
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
        return isStrike() || allRollsHaveBeenMade();
    }

    protected boolean allRollsHaveBeenMade()
    {
        return currentRoll == maxRolls();
    }

    protected boolean twoRollsHaveBeenMade()
    {
        return currentRoll == 2;
    }

    protected int maxRolls()
    {
        return MAX_ROLLS;
    }

    public boolean isSpare()
    {
        return !isStrike() && frameTotal() == BONUS_WORTHY_SCORE;
    }

    public boolean isStrike()
    {
        return firstRoll() == BONUS_WORTHY_SCORE;
    }
}
