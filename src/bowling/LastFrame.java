package bowling;

public class LastFrame extends Frame
{
    @Override
    public boolean isOver()
    {
        return isStrike() && currentRoll == 2;
    }
}
