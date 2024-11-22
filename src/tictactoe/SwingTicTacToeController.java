package tictactoe;

/**
 * This class represents the controller for a TicTacToe game. It implements the TicTacToeController
 * interface. It contains a TicTacToeView and a TicTacToeModel. It is responsible for updating the
 * view and model based on user input.
 */
public class SwingTicTacToeController implements TicTacToeController {

  private final TicTacToeView view;
  private final TicTacToe model;

  /**
   * Construct a SwingTicTacToeController object.
   *
   * @param view  the view
   * @param model  the model
   * @throws IllegalArgumentException if either the view or the model is null
   */
  public SwingTicTacToeController(TicTacToeView view, tictactoe.TicTacToe model)
      throws IllegalArgumentException {
    if (view == null) {
      throw new IllegalArgumentException("View cannot be null.");
    }
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null.");
    }
    this.view = view;
    this.model = model;
    view.setEventListener(this);
  }

  @Override
  public void playGame() {
    view.setPromptDisplay("Turn: " + model.getTurn().toString());
  }

  @Override
  public void onButtonClick(int r, int c) {
    // display current turn and make move
    view.setPlayerMove(r, c, model.getTurn().toString());
    model.move(r, c);

    // check if game is over
    if (model.isGameOver()) {
      // display if tie game or who won, update board to show winning line if there is a winner
      if (model.getWinner() == null) {
        view.setPromptDisplay("Game over! Tie game.");

      } else if (model.getWinner() == Player.X) {
        view.setPromptDisplay("Game over! X wins!");
        int[][] winningLine = model.getWinningLine();
        view.setWinningLine(winningLine);

      } else if (model.getWinner() == Player.O) {
        view.setPromptDisplay("Game over! O wins!");
        int[][] winningLine = model.getWinningLine();
        view.setWinningLine(winningLine);
      }

      // disable buttons to prevent further moves
      view.setDisableButtons();

    // display whose turn it is if game is not over
    } else {
      view.setPromptDisplay("Turn: " + model.getTurn().toString());
    }
  }
}
