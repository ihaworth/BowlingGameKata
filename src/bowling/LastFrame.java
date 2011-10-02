package bowling;

public class LastFrame extends Frame
{
    private static final int MAX_ROLLS = 3;

    @Override
    protected void init()
    {
        rolls = new int[MAX_ROLLS];
    }

    @Override
    public boolean isOver()
    {
        return isStrike() && currentRoll == 3 ||
                isSpare() && currentRoll == 3 ||
                !isStrike() && !isSpare() && currentRoll == 2;
    }

    @Override
    int strikeBonusForPreviousFrame()
    {
        return 0;
    }

    @Override
    public int score()
    {
        return firstRoll() + secondRoll() + thirdRoll();
    }

    private int thirdRoll()
    {
        return rolls[2];
    }
}
