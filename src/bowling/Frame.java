package bowling;

public class Frame
{
    private static final int MAX_ROLLS = 2;

    private int[] rolls = new int[MAX_ROLLS];
    private int currentRoll = 0;

    public void roll(int pins)
    {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    public int score()
    {
        return firstRoll() + secondRoll();
    }

    private int firstRoll()
    {
        return rolls[0];
    }

    private int secondRoll()
    {
        return rolls[1];
    }

    public boolean isOver()
    {
        return currentRoll == 2;
    }
}
