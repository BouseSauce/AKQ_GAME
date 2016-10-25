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
        while (playerGui.isActive()) {
            game.initGame();
            playerGui.setTextBox("Round number: " + game.getRound());
            switch (playerOne.playerChoice()) {
                case "Bet": {
                    System.out.print("Player One Bet");
                    playerGui.setTextBox("Player One Bet $1");
                    game.addToPot(game.playerOne.playerBet(1));
                    playerGui.updatePlayerCard(playerTwo.getPlayerCard());
                    while(!playerGui.getCallButtonClick() || !playerGui.getFoldButtonClick()) {
                        try {
                            wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (playerGui.getCallButtonClick()) {
                        playerGui.setTextBox("Pot is now: " + game.getPot());
                        playerGui.setTextBox(game.evaluate() + " Wins");
                    } else {
                        playerGui.setTextBox("Player Two Folds ");
                        playerGui.setTextBox("Player One wins " + game.getPot());
                    }

                    playerGui.setCallButtonClick(false);
                }
                case "Call": {
                    playerGui.setTextBox("Player One Checked");
                    System.out.print("Player One Checked");
                    //game.addToPot(game.playerOne.playerBet(1));
                    while (!playerGui.getCallButtonClick() || !playerGui.getFoldButtonClick()) {

                    }
                    if (playerGui.getCallButtonClick()) {
                        playerGui.setTextBox("Pot is now: " + game.getPot());
                        playerGui.setTextBox(game.evaluate() + " Wins");
                    } else {
                        playerGui.setTextBox("Player Two Folds ");
                        playerGui.setTextBox("Player One wins " + game.getPot());
                    }

                    playerGui.setCallButtonClick(false);
                    playerGui.setFoldButtonClick(false);
                }
            }
        }
    }
}


