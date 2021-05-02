package edu.wit.cs.comp1050;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * The player using the O symbol.
 * 
 * @author Jonathan Moussa
 */
public class PlayerO extends Player {

	@Override
	public char getName() {
		return 'O';
	}

	@Override
	public void drawSymbol(Cell cell) {
		Ellipse circle = new Ellipse(cell.getWidth() / 2, cell.getHeight() / 2, cell.getWidth() / 2 - 10,
				cell.getHeight() / 2 - 10);
		circle.centerXProperty().bind(cell.widthProperty().divide(2));
		circle.centerYProperty().bind(cell.heightProperty().divide(2));
		circle.radiusXProperty().bind(cell.widthProperty().divide(2).subtract(10));
		circle.radiusYProperty().bind(cell.heightProperty().divide(2).subtract(10));
		circle.setStroke(Color.BLACK);
		circle.setFill(getColor());
		cell.getChildren().add(circle);
	}
}
