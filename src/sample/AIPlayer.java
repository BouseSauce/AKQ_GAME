package sample;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Bouse PC on 3/10/2016.
 */
public class AIPlayer implements Player {


    private int chipStack;
    private char playerCard = ' ';


    AIPlayer() {

    }

    public void setChipStack(int temp_chipStack) {
        this.chipStack = temp_chipStack;
    }

    public int getChipStack() {
        return chipStack;
    }

    public char getPlayerCard() {
        return playerCard;
    }

    public void setPlayerCard(char tempPlayerCard) {
        this.playerCard = tempPlayerCard;
    }

    public int playerBet(int betSize) {
        chipStack = chipStack - betSize;
        return betSize;
    }

    public void addToChipStack(int chipsWon) {
        chipStack += chipsWon;
    }

    public int playerChoice() {
        Random random = new Random();

        int qBetPercentage = 1;

        if (playerCard == 'A') {
            playerBet(1);
            return 1;
        }
        if (playerCard == 'K') {
            return 0;
        }
        if ((random.nextInt(qBetPercentage) == 1)) {
            playerBet(1);
            return 1;
        } else
            return 0;
    }




}

