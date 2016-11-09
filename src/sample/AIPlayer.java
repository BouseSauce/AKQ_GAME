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
        int qBetPercentage = new Random().nextInt(7);
        /*
            qBetPercentage is the percentage of time player One should bluff with a Queen
            To demonstrate Nash Equilibrium we want to find out how many time's we should bluff
            a queen to be indifferent to Player Two calling

            1/3 of the time we will have a Q. 1/2 of those time's our opponent will have an Ace and will call.
            In which we lose $2 the other time's we will win $1 and all the time's our opponent calls our raises
            when we are holding the ace we will win $2 so we should bet 1/6 of our Queens
         */


        if (playerCard == 'A') {
            return 1;
        }
        else if (playerCard == 'K') {
            return 0;
        }
        if (qBetPercentage == 1) {
            return 1;
        } else
            return 0;
    }

    @Override
    public void incrementCardWin() {

    }

    @Override
    public void incrementCardLoss() {

    }

    @Override
    public int getAceCount() {
        return 0;
    }

    @Override
    public int getKingCount() {
        return 0;
    }

    @Override
    public int getQueenCount() {
        return 0;
    }

    @Override
    public int getNoWonAce() {
        return 0;
    }

    @Override
    public int getNoWonKing() {
        return 0;
    }


}

