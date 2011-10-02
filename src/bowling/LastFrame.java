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
        return isStrike() && currentRoll == 3;
    }
}
