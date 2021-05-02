package edu.wit.cs.comp1050;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;

/**
 * The Tic Tac Toe application.
 * 
 * @author 	Gloria Solovey, Jonathan Moussa
 */
public class TicTacToe extends Application {
	/**
	 * The primary stage of the application.
	 */
	private Stage primaryStage;
	
	/**
	 * The scene containing the boards' border pane.
	 */
	private Scene scene;
	
	/**
	 * The game board.
	 */
	private Board board;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		initialize();
	}
	
	/**
	 * Initializes a new round of the game.
	 */
	private void initialize() {
		Player startingPlayer = null;
		if (board == null) {
			startingPlayer = Board.playerX;
		} else {
			startingPlayer = Board.playerX.equals(board.getStartingPlayer()) ? Board.playerO : Board.playerX;
		}
		board = new Board(this, startingPlayer);
		scene = new Scene(board.getBorderPane(), getSceneWidth(), getSceneHeight());
		primaryStage.setMinWidth(300);
		primaryStage.setMinHeight(300);
		primaryStage.setTitle("Tic Tac Toe with JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	/**
	 * Returns the scene width.
	 * 
	 * @return	the scene width.
	 */
	private double getSceneWidth() {
		return scene == null ? 300 : scene.getWidth();
	}
	
	/**
	 * Returns the scene height.
	 * 
	 * @return	the scene height.
	 */
	private double getSceneHeight() {
		return scene == null ? 300 : scene.getHeight();
	}

	/**
	 * The main method launching the game.
	 * 
	 * @param args	the arguments passed in on the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Closes the application.
	 */
	public void close() {
		Platform.exit();
	}
	
	/**
	 * Resets the game.
	 */
	public void reset() {
		initialize();
	}

}
