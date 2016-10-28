package sample;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Bouse PC on 12/10/2016.
 */
public class Controller {


    Controller(AIPlayer playerOne, HumanPlayer playerTwo, int startingStack) throws IOException {


        int round = 1;
        Game game = new Game(playerOne, playerTwo);
        game.setPlayersStartingStackSize(startingStack);
        Scanner in  = new Scanner(System.in);

        while(playerOne.getChipStack() > 0 || playerTwo.getChipStack() > 0){

            game.initGame();
            System.out.println("\n\nRound:" + round);
            System.out.println("Player One: $" + playerOne.getChipStack() + "\nPlayer Two: $" + playerTwo.getChipStack());
            System.out.println("Pot:" + game.getPot());
            System.out.println(playerTwo.getPlayerCard() + " - is Player Two Card");

            switch (playerOne.playerChoice())
            {
                case 1: {
                    System.out.println("Player One Bet \nPot:"+game.getPot());
                    System.out.println("Press 'C' to Call or 'F' to Fold");
                    game.addToPot(playerOne.playerBet(1));
                    String s = in.nextLine();
                    if(s.equals("F"))
                    {
                        playerOne.addToChipStack(game.getPot());
                        System.out.println("Player One wins");
                    }
                    else if(s.equals("C"))
                    {
                        game.addToPot(playerTwo.playerBet(1));
                        System.out.println(game.evaluate() + " Wins pot");
                    }
                    break;

                        }
                case 0:
                {
                    System.out.println("Player One Checked");
                    System.out.println("Press 'C' to Check or 'F' to Fold");
                    String s = in.nextLine();
                    if(s.equals("F"))
                    {
                        playerOne.addToChipStack(game.getPot());
                        System.out.println("Player One wins");
                    }
                    else
                    {
                        System.out.println(game.evaluate());
                    }
                    break;
                }
            }
            round++;
        }
    }
}


