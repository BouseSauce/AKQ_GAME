package sample;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Bouse PC on 3/10/2016.
 */
public class AI_Player implements Player {


    private int chipStack;
    private char playerCard;

    ArrayList<String> opponentChoiceCardHistory = new ArrayList<String>();

    AI_Player() {

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

    public String playerChoice() {
        Random random = new Random();

        int kBetPercentage = 3;
        int qBetPercentage = 1;


        if (playerCard == 'A') {
            return "Bet";
        }
        if (playerCard == 'K') {
            /* if kBetPercentage is 3 there is a 33% chance (0 is an option) that nextInt will
                be 1. Computer would then bet with a King 33% of the time.
             */
            if (random.nextInt(kBetPercentage) == 1)
                return "Bet";
            else
                return "Check";
        }
        if ((random.nextInt(qBetPercentage) == 1)) {
            return "Bet";
        } else
            return "Check";
    }

    public void addToOpponentInformation(String opponentChoice, char opponentCard)
    {

    }



}
