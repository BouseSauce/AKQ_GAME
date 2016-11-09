package sample;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Bouse PC on 12/10/2016.
 */
public class Controller {


    Controller(AIPlayer playerOne, HumanPlayer playerTwo, int startingStack) throws IOException, InterruptedException {

        Game game = new Game(playerOne, playerTwo);
        game.setPlayersStartingStackSize(startingStack);
        Scanner in  = new Scanner(System.in);

        while (playerOne.getChipStack() > 0 && playerTwo.getChipStack() > 0) {


            if(game.getRound() == 0)
            {
                System.out.println("Welcome to my Ace King Queen Game" +
                        "\nYou will play as Player 2,You have the choices Call (C) or Fold (F)" +
                        "\nAce > King > Queen" +
                        "\nThe Game is over when a player has no chips left" + "" +
                        "\nPress Q to end the game" +
                        "\nGood Luck!\n");
            }



            game.printRoundInfo();
            game.initGame();

            System.out.println("Pot: $" + game.getPot());
            System.out.println("Card: " +game.toString(playerTwo.getPlayerCard()));


            //Assumes correct user input
            switch (playerOne.playerChoice())
            {
                case 1: {
                    game.addToPot(playerOne.playerBet(1));
                    System.out.println("Action: Player One Bet");
                    System.out.println("Call (C) $" + (game.getPot()-2) + " or Fold (F)");
                    String s = in.nextLine();
                    if(s.toUpperCase().equals("F"))
                    {
                        System.out.println("Player Two Folds");
                        playerOne.addToChipStack(game.getPot());
                        System.out.println("Player One wins");
                    }
                    else if(s.toUpperCase().equals("C"))
                    {
                        System.out.println("Player Two Calls");
                        game.addToPot(playerTwo.playerBet(1));
                        System.out.println("Winner:"+ game.evaluate());
                    } else if (s.toUpperCase().equals("Q")) {
                        playerTwo.setChipStack(0);
                    }
                    else
                    {
                        System.out.println("INVALID INPUT");
                        System.out.println("Round Reset");
                        playerOne.addToChipStack(2);
                        playerTwo.addToChipStack(1);

                    }
                    break;

                        }
                case 0:
                {
                    System.out.println("Player One Checked");
                    System.out.println("Check (C) or Fold (F)");
                    String s = in.nextLine();
                    if(s.toUpperCase().equals("F"))
                    {
                        System.out.println("Player Two Folds");
                        playerOne.addToChipStack(game.getPot());
                        System.out.println("Player One wins");
                    }
                    else if(s.toUpperCase().equals("C"))
                    {
                        System.out.println("Player Two Calls");
                        System.out.println("Winner:"+ game.evaluate());
                    } else if (s.toUpperCase().equals("Q")) {
                        playerTwo.setChipStack(0);
                    }
                    else
                    {
                        System.out.println("INVALID INPUT");
                        System.out.println("Round Reset");
                        playerOne.addToChipStack(1);
                        playerTwo.addToChipStack(1);
                    }
                    break;
                }
                default:
                {

                    break;
                }

            }
            game.incrementRound();
            game.addToPot(-game.getPot());
        }

        System.out.print("\n\n*************" +
                        " \n* Game Over * "+
                         "\n*************");
        if(playerOne.getChipStack() > playerTwo.getChipStack())
        {
            System.out.println("\nWinner: Player One");
        }
        else if(playerTwo.getChipStack() > playerOne.getChipStack())
        {
            System.out.println("Winner: Player Two");
        }
        else
        {
            System.out.println("Draw!");
        }
        System.out.print("\nNumber of Hands Played: " + game.getRound());
        System.out.print("\nWon with Aces at Showdown: "+ playerTwo.getNoWonAce()
        + " \nWon with Kings at Showdown: " + playerTwo.getNoWonKing()
        + "\nYou had a Ace " + (((playerTwo.getAceCount()*100)/ game.getRound() *100) /100) + "% of the time" +
                "\nYou had a King " + (((playerTwo.getKingCount()*100)/ game.getRound() *100) /100) + "% of the time" +
                "\nYou had a Queen " + (((playerTwo.getQueenCount()*100)/ game.getRound() *100) /100) + "% of the time");








    }
}


