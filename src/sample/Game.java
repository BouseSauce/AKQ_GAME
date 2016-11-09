package sample;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Bouse PC on 30/09/2016.
 */
public class Game{

    private int pot = 0;
    private int round = 0;
    private List gameDeck;

    protected Player playerOne;
    protected Player playerTwo;

    public Game(AIPlayer playerOne, HumanPlayer playerTwo)
    {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Game(HumanPlayer playerOne, AIPlayer playerTwo)
    {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Game(AIPlayer playerOne, AIPlayer playerTwo)
    {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Game(HumanPlayer playerOne, HumanPlayer playerTwo)
    {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String toString(char card)
    {
        if(card == 'A')
        {
            return("Ace");
        }
        else if(card == 'K')
        {
            return ("King");
        }
        else
        {
            return ("Queen");
        }

    }

    public void printRoundInfo()
    {
        System.out.print("*********************");
        System.out.print("\n* Round: " + round);

        if(round >= 100) {
            System.out.print("        *\n");
        }
        else if (round >= 10) {
            System.out.print("         *\n");
        }
        else {
            System.out.print("          *\n");
        }
        System.out.print("* Player One: $" + playerOne.getChipStack());

        if(playerOne.getChipStack() >= 10) {
            System.out.print("   *\n");
        }
        else {
            System.out.print("    *\n");
        }
        System.out.print("* Player Two: $" + playerTwo.getChipStack());
        if(playerTwo.getChipStack() >= 10) {
            System.out.print("   *\n");
        }
        else {
            System.out.print("    *\n");
        }
        System.out.print("*********************\n");
    }

    public void incrementRound()
    {
        round++;
    }

    public int getRound() {
        return round;
    }

    void initGame()
    {
        deductAnte(playerOne,playerTwo);
        initDeck();
        dealCard(playerOne);
        dealCard(playerTwo);
    }

    void setPlayersStartingStackSize(int startingStack)
    {
        playerOne.setChipStack(startingStack);
        playerTwo.setChipStack(startingStack);
    }

    public int getPot()
    {
        return pot;
    }

    public void addToPot(int betAmmount)
    {
        pot+=betAmmount;
    }

    protected String evaluate()
    {
        if(playerOne.getPlayerCard() == 'A')
        {
            playerOne.addToChipStack(pot);
            playerTwo.incrementCardLoss();
            return "Player One";
        }
        else if(playerTwo.getPlayerCard() == 'A')
        {
            playerTwo.addToChipStack(pot);
            playerTwo.incrementCardWin();
            return "Player Two";
        }
        else if(playerOne.getPlayerCard() == 'K')
        {
            playerOne.addToChipStack(pot);
            playerTwo.incrementCardLoss();
            return "Player One";
        }
        else {
            playerTwo.addToChipStack(pot);
            playerTwo.incrementCardWin();
            return "Player Two";
        }

    }

    private void initDeck()
    {
        List deck = new ArrayList<>();
        deck.add('A');
        deck.add('K');
        deck.add('Q');
        gameDeck = deck;
    }

    private void deductAnte(Player playerOne, Player playerTwo)
    {
        addToPot(playerOne.playerBet(1) + playerTwo.playerBet(1));
    }

    private void dealCard(Player player)
    {
        Random random = new Random();
        int randPos = random.nextInt(gameDeck.size());
        player.setPlayerCard((Character) gameDeck.get(randPos));
        gameDeck.remove(randPos);

    }



}
