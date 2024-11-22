package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents the view for a TicTacToe game. It implements the TicTacToeView interface.
 * It contains a prompt display that tells the user whose turn it is and the results on the game,
 * and a 3x3 grid of buttons that represent the TicTacToe board.
 */
public class SwingTicTacToeView extends JFrame implements TicTacToeView {
  private final JLabel promptDisplay;
  private final JButton[][] buttons;

  /**
   * Construct a SwingTicTacToeView object.
   *
   * @param caption the caption for the window
   */
  public SwingTicTacToeView(String caption) {
    super(caption);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(225, 250));
    setResizable(false);

    // create and add prompt display for turn/game results
    promptDisplay = new JLabel("");
    promptDisplay.setFont(new Font("Arial", Font.PLAIN, 18));
    promptDisplay.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    this.add(promptDisplay, BorderLayout.PAGE_START);

    // create and add game board using buttons
    JPanel boardView = new JPanel(new GridLayout(3, 3));
    boardView.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttons = new JButton[3][3];
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        buttons[r][c] = new JButton();
        buttons[r][c].setPreferredSize(new Dimension(50, 50));
        buttons[r][c].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[r][c].setFocusable(false);
        buttons[r][c].setBorderPainted(true);
        buttons[r][c].setContentAreaFilled(false);
        boardView.add(buttons[r][c]);
      }
    }
    this.add(boardView, BorderLayout.CENTER);

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  @Override
  public void setPromptDisplay(String display) {
    promptDisplay.setText(display);
  }

  @Override
  public void setEventListener(TicTacToeController controller) {
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        final int finalRow = row;
        final int finalCol = col;
        buttons[row][col].addActionListener(evt -> controller.onButtonClick(finalRow, finalCol));
      }
    }
  }

  @Override
  public void setPlayerMove(int row, int col, String player) {
    buttons[row][col].setText(player);
    buttons[row][col].setEnabled(false);
  }

  @Override
  public void setWinningLine(int[][] winningLine) {
    for (int i = 0; i < 3; i++) {
      buttons[winningLine[i][0]][winningLine[i][1]].setBackground(Color.GREEN);
      buttons[winningLine[i][0]][winningLine[i][1]].setOpaque(true);
    }
  }

  @Override
  public void setDisableButtons() {
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        buttons[row][col].setEnabled(false);
      }
    }
  }
}
