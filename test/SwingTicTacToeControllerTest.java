import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import tictactoe.Player;
import tictactoe.SwingTicTacToeController;
import tictactoe.SwingTicTacToeView;
import tictactoe.TicTacToeController;
import tictactoe.TicTacToeModel;
import tictactoe.TicTacToeView;

/**
 * Test cases for the Tic Tac Toe controller. Verifying that the controller properly updates the
 * view and model.
 */
public class SwingTicTacToeControllerTest {
  private TicTacToeView view;
  private TicTacToeModel model;
  private TicTacToeController controller;

  /**
   * Set up the model, view, and controller for testing.
   */
  @Before
  public void setUp() {
    model = new TicTacToeModel();
    view = new SwingTicTacToeView("Tic Tac Toe");
    controller = new SwingTicTacToeController(view, model);
  }

  /**
   * Test the playGame() method works as expected.
   */
  @Test
  public void testPlayGame() {
    controller.playGame();
    assertEquals(Player.X, model.getTurn());
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  ", model.toString());
    controller.onButtonClick(0, 0);
    assertEquals(Player.O, model.getTurn());
    assertEquals(" X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  ", model.toString());
  }

  /**
   * Test the onButtonClick() method works as expected.
   */
  @Test
  public void testOnButtonClick() {
    controller.onButtonClick(0, 0);
    controller.onButtonClick(1, 0);
    controller.onButtonClick(0, 1);
    controller.onButtonClick(2, 0);
    controller.onButtonClick(0, 2);
    assertEquals(Player.X, model.getWinner());
    assertEquals(" X | X | X\n"
        + "-----------\n"
        + " O |   |  \n"
        + "-----------\n"
        + " O |   |  ", model.toString());
  }

  /**
   * Test the constructor throws an exception when given a null view.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullView() {
    controller = new SwingTicTacToeController(null, model);
  }

  /**
   * Test the constructor throws an exception when given a null model.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    controller = new SwingTicTacToeController(view, null);
  }
}
