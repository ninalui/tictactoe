package tictactoe;

/**
 * Represents a Controller for Tic Tac Toe: handle user moves by executing them using the model;
 * convey move outcomes to the user in some form.
 */
public interface TicTacToeController {

  /**
   * Execute a single game of Tic Tac Toe given a Tic Tac Toe Model. When the game is over,
   * the playGame method ends.
   */
  void playGame();

  /**
   * Handles button click events from the view. When a button is clicked, the controller tells the
   * model to make a move at the corresponding position. The controller then updates the view with
   * the move. If the game is over, the controller disables all buttons on the view.
   *
   * @param r the row of the intended move
   * @param c the column of the intended move
   */
  void onButtonClick(int r, int c);
}
