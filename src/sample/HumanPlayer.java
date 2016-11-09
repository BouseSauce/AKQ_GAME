package sample;

import javax.sound.midi.Soundbank;

/**
 * Created by Bouse PC on 3/10/2016.
 */

class HumanPlayer implements Player{

    private int chipStack;
    private char playerCard = ' ';
    private int aceCount = 0;
    private int kingCount = 0;
    private int queenCount = 0;
    private int noWonAce = 0;
    private int noWonKing = 0;
    private int noLostKing = 0;
    private int callCount = 0;
    private int foldCount = 0;
    private int foldCountWithKing = 0;

    HumanPlayer() {

    }

    public int playerBet(int betSize) {
        chipStack = chipStack - betSize;
        return betSize;
    }

    public void addToChipStack(int chipsWon) {
        chipStack += chipsWon;
    }

    public int playerChoice() {
        System.out.print("playerChoice");
        return 0;
    }

    public void incrementCardWin()
    {
        if (this.playerCard == 'A') {
            noWonAce++;
        } else if (this.playerCard == 'K') {
            noWonKing++;
        }

    }

    public void incrementCardLoss()
    {

        if (this.playerCard == 'K') {
            noWonKing--;
        }
    }

    //Getters and Setters
    public void setPlayerCard(char tempPlayerCard) {
        this.playerCard = tempPlayerCard;
        if (tempPlayerCard == 'A') {
            aceCount++;
        } else if (tempPlayerCard == 'K') {
            kingCount++;
        } else {
            queenCount++;
        }
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

    public int getAceCount() {
        return aceCount;
    }

    public int getKingCount() {
        return kingCount;
    }

    public int getQueenCount()
    {
        return queenCount;
    }

    public int getNoWonAce() {
        return noWonAce;
    }

    public int getNoWonKing()
    {
        return noWonKing;
    }
}

