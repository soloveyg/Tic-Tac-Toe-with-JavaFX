package edu.wit.cs.comp1050;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * The player using the X symbol.
 * 
 * @author Jonathan Moussa
 */
public class PlayerX extends Player {
	
	@Override
	public char getName() {
		return 'X';
	}

	@Override
	public void drawSymbol(Cell cell) {
		Line topLeftToBottomRight = new Line(10, 10, cell.getWidth() - 10, cell.getHeight() - 10);
		topLeftToBottomRight.setStroke(getColor());
		topLeftToBottomRight.setStrokeWidth(10);
		topLeftToBottomRight.endXProperty().bind(cell.widthProperty().subtract(10));
		topLeftToBottomRight.endYProperty().bind(cell.heightProperty().subtract(10));
		
		Line topRightToBottomLeft = new Line(10, cell.getHeight() - 10, cell.getWidth() - 10, 10);
		topRightToBottomLeft.setStroke(getColor());
		topRightToBottomLeft.setStrokeWidth(10);
		topRightToBottomLeft.endXProperty().bind(cell.widthProperty().subtract(10));
		topRightToBottomLeft.startYProperty().bind(cell.heightProperty().subtract(10));
		
		cell.getChildren().addAll(topLeftToBottomRight, topRightToBottomLeft);
	}

}
