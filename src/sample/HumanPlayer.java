package sample;

import javax.sound.midi.Soundbank;

/**
 * Created by Bouse PC on 3/10/2016.
 */

class HumanPlayer implements Player {

    int chipStack;
    char playerCard = ' ';

    public void setChipStack(int temp_chipStack)
    {
        this.chipStack = temp_chipStack;
    }

    public int getChipStack()
    {
        return chipStack;
    }

    public char getPlayerCard()
    {
        return playerCard;
    }

    public void setPlayerCard(char tempPlayerCard)
    {
        this.playerCard = tempPlayerCard;
    }

    public int playerBet(int betSize)
    {
        chipStack = chipStack - betSize;
        return betSize;
    }
    public void addToChipStack(int chipsWon)
    {
        chipStack+=chipsWon;
    }

    public int playerChoice()
    {
        System.out.print("playerChoice");
        return 0;
    }
}

