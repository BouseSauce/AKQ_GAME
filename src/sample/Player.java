package sample;

/**
 * Created by Bouse PC on 30/09/2016.
 */
public interface Player {
    void setChipStack(int temp_chipStack);

    int getChipStack();

    char getPlayerCard();

    void setPlayerCard(char tempPlayerCard);

    int playerBet(int betSize);

    void addToChipStack(int chipsWon);

    int playerChoice();

    void incrementCardWin();

    void incrementCardLoss();

    int getAceCount();

    int getKingCount();

    int getQueenCount();

    int getNoWonAce();

    int getNoWonKing();
}
