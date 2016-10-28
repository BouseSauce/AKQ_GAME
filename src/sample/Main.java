package sample;


import java.io.IOException;

public class Main {

    public static void main(String args[]){
        HumanPlayer humanPlayer = new HumanPlayer();
        AIPlayer aiPlayer = new AIPlayer();

        int startingStack = 20;

        try {
            Controller controller = new Controller(aiPlayer, humanPlayer, startingStack);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
