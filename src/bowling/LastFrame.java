package bowling;

public class LastFrame extends Frame
{
    private static final int MAX_ROLLS = 3;

    @Override
    public boolean isOver()
    {
        return isStrike() && allRollsHaveBeenMade() ||
                isSpare() && allRollsHaveBeenMade() ||
                !isStrike() && !isSpare() && twoRollsHaveBeenMade();
    }

    @Override
    protected int maxRolls()
    {
        return MAX_ROLLS;
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
