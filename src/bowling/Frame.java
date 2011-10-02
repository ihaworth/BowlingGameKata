package bowling;

public class Frame
{
    private int[] rolls = new int[2];
    private int currentRoll = 0;

    public void roll(int pins)
    {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    public int score()
    {
        return rolls[0] + rolls[1];
    }
}
