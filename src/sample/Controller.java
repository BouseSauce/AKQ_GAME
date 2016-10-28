package sample;

import java.io.IOException;

/**
 * Created by Bouse PC on 12/10/2016.
 */
public class Controller {


    Controller(AIPlayer playerOne, HumanPlayer playerTwo, int startingStack) throws IOException {


        Game game = new Game(playerOne, playerTwo);
        GUI playerGui = new GUI();
        game.setPlayersStartingStackSize(startingStack);

        for (;;){
            game.initGame();
            System.out.println(playerOne.getPlayerCard() + " - is Player Ones Card");
            switch (playerOne.playerChoice()) {
                case 1: {
                    System.out.print("Player One Bet");
                    playerGui.setTextBox("Player One Bet $1");
                    game.addToPot(game.playerOne.playerBet(1));
                    playerGui.updatePlayerCard(playerTwo.getPlayerCard());
                    while(!playerGui.getCallButtonClick() || !playerGui.getFoldButtonClick()) {

                    }
                    System.out.println("test");
                    if (playerGui.getCallButtonClick()) {
                        playerGui.setTextBox("Pot is now: " + game.getPot());
                        playerGui.setTextBox(game.evaluate() + " Wins");
                    } else {
                        playerGui.setTextBox("Player Two Folds ");
                        playerGui.setTextBox("Player One wins " + game.getPot());
                    }

                    playerGui.setCallButtonClick(false);
                }
                case 0: {
                    playerGui.setTextBox("Player One Checked");
                    System.out.print("Player One Checked");
                    //game.addToPot(game.playerOne.playerBet(1));
                    while (!playerGui.getCallButtonClick() || !playerGui.getFoldButtonClick()) {

                    }
                    if (playerGui.getCallButtonClick()) {
                        playerGui.setTextBox("Pot is now: " + game.getPot());
                        playerGui.setTextBox(game.evaluate() + " Wins");
                        System.out.print("Player Two Called");
                    } else {
                        playerGui.setTextBox("Player Two Folds ");
                        playerGui.setTextBox("Player One wins " + game.getPot());
                        System.out.print("Player Two Called");
                    }

                    playerGui.setCallButtonClick(false);
                    playerGui.setFoldButtonClick(false);
                }
            }
        }
    }
}


