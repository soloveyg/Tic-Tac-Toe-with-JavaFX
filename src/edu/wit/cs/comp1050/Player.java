package edu.wit.cs.comp1050;

import javafx.scene.paint.Color;

/**
 * Abstract player class providing some base logic to its descendants.
 * 
 * @author Jonathan Moussa 
 */
public abstract class Player {
	
	/**
	 * The color this player uses to draw a symbol.
	 */
	private Color color;
	
	/**
	 * Returns the player name.
	 * 
	 * @return	the player name.
	 */
	public abstract char getName();
	
	/**
	 * Draws a symbol on the cell this player occupies.
	 * 
	 * @param cell	the cell to draw a symbol on.
	 */
	public abstract void drawSymbol(Cell cell);
	
	/**
	 * Sets the color this player uses to draw a symbol.
	 * 
	 * @param color		the color this player uses to draw a symbol.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Returns the color this player uses to draw a symbol.
	 * 
	 * @return	the color this player uses to draw a symbol.
	 */
	public Color getColor() {
		return color;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Player other = (Player) obj;
		return getName() == other.getName();
	}

}
