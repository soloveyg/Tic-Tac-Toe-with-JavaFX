package edu.wit.cs.comp1050;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * A cell on the game board.
 * 
 * @author Gloria Solovey
 */
public class Cell extends Pane {

	/**
	 * The player occupying this cell.
	 */
	private Player player;
	
	/**
	 * The parent game board.
	 */
	private Board board;
	
	/**
	 * The constructor that initializes the board.
	 * 
	 * @param board		the parent board 
	 */
	public Cell(Board board) {
		this.board = board;
		setStyle("-fx-border-color : black");
		this.setPrefSize(10000,10000);
		this.setOnMouseClicked(e -> handleClick());
	}
	
	/**
	 * Handles a mouse click event and gives the board a chance to process the event as well.
	 */
	private void handleClick() {
		if (this.player == null && board.getCurrentPlayer() != null) {
			setPlayer(board.getCurrentPlayer());
			board.processClick();
		}
	}

	/**
	 * Returns the occupying player.
	 * 
	 * @return	the occupying player.
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * Sets the occupying player and allows the player to draw a symbol on the cell.
	 * 
	 * @param player	the player to occupy this cell
	 */
	public void setPlayer(Player player) {
		this.player = player;
		player.drawSymbol(this);
	}
}
