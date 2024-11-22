package tictactoe;

/**
 * This interface represents the view of a Tic Tac Toe game. It provides methods to display the
 * current state of the game to the user, and to set the event listener for the game board to get
 * the user's moves. It also provides methods to update the game board with a move, and to disable
 * the game board when the game is over.
 */
public interface TicTacToeView {

  /**
   * Shows the user a text view of current turn or winner when game ends.
   *
   * @param display the text string to display to the user
   */
  void setPromptDisplay(String display);

  /**
   * Sets the Tic Tac Toe Controller as the event listener for the Tic Tac Toe game board.
   *
   * @param controller the Tic Tac Toe Controller to set as the event listener
   */
  void setEventListener(TicTacToeController controller);

  /**
   * Updates the Tic Tac Toe game board with a move.
   *
   * @param row     the row of the move
   * @param col     the column of the move
   * @param player  the text string of the player who made the move
   */
  void setPlayerMove(int row, int col, String player);

  /**
   * Updates the Tic Tac Toe game board to show the winning line.
   *
   * @param winningLine the winning line of the game
   */
  void setWinningLine(int[][] winningLine);

  /**
   * Disables all buttons on the Tic Tac Toe game board when the game is over.
   */
  void setDisableButtons();

}
