package tictactoe;

/**
 * Driver class for the TicTacToe game.
 */
public class Main {

  /**
   * Run a TicTacToe game using the Swing GUI.
   *
   * @param args not used
   */
  public static void main(String[] args) {
    TicTacToe model = new TicTacToeModel();
    TicTacToeView view = new SwingTicTacToeView("Tic-Tac-Toe");
    TicTacToeController controller = new SwingTicTacToeController(view, model);
    controller.playGame();
  }
}
