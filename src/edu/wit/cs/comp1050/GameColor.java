package edu.wit.cs.comp1050;

import java.util.Random;


import javafx.scene.paint.Color;

/**
 * A helper class to pick random colors for the two players in a game.
 * 
 * @author Gloria Solovey
 */
public class GameColor {
	/**
	 * Random number generator for PlayerO.
	 */
	private final static Random randomO = new Random();
	
	/** 
	 * Random number generator for PlayerX
	 */
	private final static Random randomX = new Random();
	
	/**
	 * Colors for PlayerO.
	 */
	private static final Color[] colorO = new Color[] { Color.ALICEBLUE, Color.ANTIQUEWHITE, Color.AQUA,
			Color.AQUAMARINE, Color.AZURE, Color.BEIGE, Color.BISQUE, Color.BLACK, Color.BLANCHEDALMOND, Color.BLUE,
			Color.BLUEVIOLET, Color.BROWN, Color.BURLYWOOD, Color.CADETBLUE, Color.CHARTREUSE, Color.CHOCOLATE,
			Color.CORAL, Color.CORNFLOWERBLUE, Color.CORNSILK, Color.CRIMSON, Color.CYAN, Color.DARKBLUE,
			Color.DARKCYAN, Color.DARKGOLDENROD, Color.DARKGRAY, Color.DARKGREEN, Color.DARKKHAKI,
			Color.DARKMAGENTA, Color.DARKOLIVEGREEN, Color.DARKORANGE, Color.DARKORCHID, Color.DARKRED,
			Color.DARKSALMON, Color.DARKSEAGREEN, Color.DARKSLATEBLUE, Color.DARKSLATEGRAY, 
			Color.DARKTURQUOISE, Color.DARKVIOLET, Color.DEEPPINK, Color.DEEPSKYBLUE, Color.DIMGRAY, 
			Color.DODGERBLUE, Color.FIREBRICK, Color.FLORALWHITE, Color.FORESTGREEN, Color.FUCHSIA, Color.GAINSBORO,
			Color.GHOSTWHITE, Color.GOLD, Color.GOLDENROD, Color.GRAY, Color.GREEN, Color.GREENYELLOW,
			Color.HONEYDEW, Color.HOTPINK, Color.INDIANRED, Color.INDIGO, Color.IVORY, Color.KHAKI, Color.LAVENDER,
			Color.LAVENDERBLUSH, Color.LAWNGREEN, Color.LEMONCHIFFON, Color.LIGHTBLUE, Color.LIGHTCORAL,
			Color.LIGHTCYAN, Color.LIGHTGOLDENRODYELLOW, Color.LIGHTGRAY, Color.LIGHTGREEN, 
			Color.LIGHTPINK, Color.LIGHTSALMON, Color.LIGHTSEAGREEN, Color.LIGHTSKYBLUE, Color.LIGHTSLATEGRAY,
			Color.LIGHTSTEELBLUE, Color.LIGHTYELLOW, Color.LIME, Color.LIMEGREEN, Color.LINEN,
			Color.MAGENTA, Color.MAROON, Color.MEDIUMAQUAMARINE, Color.MEDIUMBLUE, Color.MEDIUMORCHID,
			Color.MEDIUMPURPLE, Color.MEDIUMSEAGREEN, Color.MEDIUMSLATEBLUE, Color.MEDIUMSPRINGGREEN,
			Color.MEDIUMTURQUOISE, Color.MEDIUMVIOLETRED, Color.MIDNIGHTBLUE, Color.MINTCREAM, Color.MISTYROSE,
			Color.MOCCASIN, Color.NAVAJOWHITE, Color.NAVY, Color.OLDLACE, Color.OLIVE, Color.OLIVEDRAB, Color.ORANGE,
			Color.ORANGERED, Color.ORCHID, Color.PALEGOLDENROD, Color.PALEGREEN, Color.PALETURQUOISE,
			Color.PALEVIOLETRED, Color.PAPAYAWHIP, Color.PEACHPUFF, Color.PERU, Color.PINK, Color.PLUM,
			Color.POWDERBLUE, Color.PURPLE, Color.RED, Color.ROSYBROWN, Color.ROYALBLUE, Color.SADDLEBROWN,
			Color.SALMON, Color.SANDYBROWN, Color.SEAGREEN, Color.SEASHELL, Color.SIENNA, Color.SILVER, Color.SKYBLUE,
			Color.SLATEBLUE, Color.SLATEGRAY, Color.SNOW, Color.SPRINGGREEN, Color.STEELBLUE,
			Color.TAN, Color.TEAL, Color.THISTLE, Color.TOMATO, Color.TRANSPARENT, Color.TURQUOISE, Color.VIOLET,
			Color.WHEAT, Color.WHITE, Color.WHITESMOKE, Color.YELLOW, Color.YELLOWGREEN };	
	
	/**
	 * Colors for playerX. Light colors are excluded.
	 */
	private static final Color[] colorX = new Color[] { Color.AQUA,	Color.AQUAMARINE, Color.BLACK, Color.BLUE,
			Color.BLUEVIOLET, Color.BROWN, Color.BURLYWOOD, Color.CADETBLUE, Color.CHARTREUSE, Color.CHOCOLATE,
			Color.CORAL, Color.CORNFLOWERBLUE, Color.CRIMSON, Color.CYAN, Color.DARKBLUE,
			Color.DARKCYAN, Color.DARKGOLDENROD, Color.DARKGRAY, Color.DARKGREEN, Color.DARKKHAKI,
			Color.DARKMAGENTA, Color.DARKOLIVEGREEN, Color.DARKORANGE, Color.DARKORCHID, Color.DARKRED,
			Color.DARKSALMON, Color.DARKSEAGREEN, Color.DARKSLATEBLUE, Color.DARKSLATEGRAY, 
			Color.DARKTURQUOISE, Color.DARKVIOLET, Color.DEEPPINK, Color.DEEPSKYBLUE, Color.DIMGRAY, 
			Color.DODGERBLUE, Color.FIREBRICK, Color.FORESTGREEN, Color.FUCHSIA,
			Color.GOLD, Color.GOLDENROD, Color.GRAY, Color.GREEN, Color.GREENYELLOW, Color.HOTPINK,
			Color.INDIANRED, Color.INDIGO, Color.LAWNGREEN, Color.LIGHTBLUE, Color.LIGHTCORAL, Color.LIGHTGREEN,
			Color.LIGHTPINK, Color.LIGHTSALMON, Color.LIGHTSEAGREEN, Color.LIGHTSKYBLUE, Color.LIGHTSLATEGRAY,
			Color.LIGHTSTEELBLUE, Color.LIME, Color.LIMEGREEN, Color.MAGENTA, Color.MAROON,
			Color.MEDIUMAQUAMARINE, Color.MEDIUMBLUE, Color.MEDIUMORCHID, Color.MEDIUMPURPLE, Color.MEDIUMSEAGREEN,
			Color.MEDIUMSLATEBLUE, Color.MEDIUMSPRINGGREEN, Color.MEDIUMTURQUOISE, Color.MEDIUMVIOLETRED,
			Color.MIDNIGHTBLUE, Color.NAVY, Color.OLIVE, Color.OLIVEDRAB, Color.ORANGE,
			Color.ORANGERED, Color.ORCHID, Color.PALEGREEN, Color.PALETURQUOISE, Color.PALEVIOLETRED, Color.PERU,
			Color.PINK, Color.PLUM, Color.POWDERBLUE, Color.PURPLE, Color.RED, Color.ROSYBROWN, Color.ROYALBLUE,
			Color.SADDLEBROWN, Color.SALMON, Color.SANDYBROWN, Color.SEAGREEN, Color.SIENNA, Color.SKYBLUE,
			Color.SLATEBLUE, Color.SLATEGRAY, Color.SPRINGGREEN, Color.STEELBLUE, Color.TAN,
			Color.TEAL, Color.THISTLE, Color.TOMATO, Color.TURQUOISE, Color.VIOLET, Color.YELLOW, Color.YELLOWGREEN };	

	/**
	 * Returns a random color for PlayerO.
	 * 
	 * @return	a random color for PlayerO.
	 */
	public static Color getRandomColorO() {
		int r = randomO.nextInt(colorO.length);
		return colorO[r];
	}

	/**
	 * Returns a random color for PlayerX.
	 * 
	 * @return	a random color for PlayerX.
	 */
	public static Color getRandomColorX() {
		int r = randomX.nextInt(colorX.length);
		return colorX[r];
	}
}
