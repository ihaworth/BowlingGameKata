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
        return isStrike() && currentRoll == MAX_ROLLS ||
                isSpare() && currentRoll == MAX_ROLLS ||
                !isStrike() && !isSpare() && currentRoll == 2;
    }

    @Override
    int strikeBonusForPreviousFrame()
    {
        return firstRoll() + secondRoll();
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
