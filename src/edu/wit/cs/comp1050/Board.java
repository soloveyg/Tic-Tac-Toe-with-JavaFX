package edu.wit.cs.comp1050;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * The game board.
 * 
 * @author Gloria Solovey
 */
public class Board {
	
	/**
	 * The player putting X on the board.
	 */
	public static final Player playerX = new PlayerX();
	
	/**
	 * The player putting O on the board.
	 */
	public static final PlayerO playerO = new PlayerO();
	
	/**
	 * The player that needs to make the next move.
	 */
	private Player currentPlayer;
	
	/**
	 * The player starting the game.
	 */
	private Player startingPlayer;
	
	/**
	 * The nine cells of the board.
	 */
	private Cell[][] cell = new Cell[3][3];
	
	/**
	 * The status message showing information relevant to the current state of the game.
	 */
	private Label statusMessage;
	
	/**
	 * The border pane.
	 */
	private BorderPane borderPane;
	
	/**
	 * Reference to the application container. 
	 */
	private TicTacToe ticTacToe;
	
	/**
	 * Constructor initializing the board.
	 * 
	 * @param ticTacToe			the application container
	 * @param startingPlayer	the starting player	
	 */
	public Board(TicTacToe ticTacToe, Player startingPlayer) {
		this.ticTacToe = ticTacToe;
		
		this.startingPlayer = startingPlayer;
		this.currentPlayer = startingPlayer;
		
		playerX.setColor(GameColor.getRandomColorX());
		playerO.setColor(GameColor.getRandomColorO());
		
		GridPane grid = new GridPane();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cell[i][j] = new Cell(this);
				grid.add(cell[i][j],j,i);
			}
		}
		
		borderPane = new BorderPane();
		borderPane.setCenter(grid);
		statusMessage = new Label(currentPlayer.getName() + "'s turn");
		borderPane.setBottom(statusMessage);
	}
	
	/**
	 * Returns the border pane.
	 * 
	 * @return	the border pane.
	 */
	public Pane getBorderPane() {
		return borderPane;
	}
	
	/**
	 * Returns the current player.
	 * 
	 * @return	the current player.
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Returns the starting player.
	 * 
	 * @return	the starting player.
	 */
	public Player getStartingPlayer() {
		return startingPlayer;
	}
	
	/**
	 * Indicates if the board is full.
	 * 
	 * @return	true if the board is full, false otherwise.
	 */
	public boolean isFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (cell[i][j].getPlayer() == null) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Indicates if the current player has won.
	 * 
	 * @return	true if the current player has won, false otherwise
	 */
	public boolean hasCurrentPlayerWon() {
		for (int i = 0; i < 3; i++) {
			if (currentPlayer.equals(cell[i][0].getPlayer()) 
					&& currentPlayer.equals(cell[i][1].getPlayer())  
					&& currentPlayer.equals(cell[i][2].getPlayer())){
				return true;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (currentPlayer.equals(cell[0][i].getPlayer()) 
					&& currentPlayer.equals(cell[1][i].getPlayer()) 
					&& currentPlayer.equals(cell[2][i].getPlayer())) {
				return true;
			}
		}
			
		if (currentPlayer.equals(cell[0][0].getPlayer()) 
				&& currentPlayer.equals(cell[1][1].getPlayer()) 
				&& currentPlayer.equals(cell[2][2].getPlayer())) {
			return true;
		}
		
		if (currentPlayer.equals(cell[0][2].getPlayer())
				&& currentPlayer.equals(cell[1][1].getPlayer()) 
				&& currentPlayer.equals(cell[2][0].getPlayer())) {
			return true;
		}
		
		return false;
	}

	/**
	 * Processes mouse click and determines the next state of the game.
	 */
	public void processClick() {
		if (hasCurrentPlayerWon()) {
			statusMessage.setText(currentPlayer.getName() + " won!");
			String message = currentPlayer.getName() + " won! Do you want to reset?";
			currentPlayer = null;
			showMessage(message);
		} else if (isFull()) {
			statusMessage.setText("Draw!");
			currentPlayer = null;
			showMessage("Draw! Do you want to reset?");
		} else {
			currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
			statusMessage.setText(currentPlayer.getName() + "'s turn !");
		}
	}
	
	/**
	 * Show information message and gives a chance to reset the game.
	 * 
	 * @param message	text to display.
	 */
	private void showMessage(String message) {
		Alert alert = new Alert(AlertType.INFORMATION, message, ButtonType.OK, ButtonType.CLOSE);
		alert.showAndWait();

		if (alert.getResult() == ButtonType.OK) {
		    reset();
		} else {
			close();
		}
	}

	/**
	 * Closes the application.
	 */
	private void close() {
		ticTacToe.close();
	}

	/**
	 * Resets the game.
	 */
	private void reset() {
		ticTacToe.reset();
	}
}
