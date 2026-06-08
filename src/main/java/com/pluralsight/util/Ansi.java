package com.pluralsight.util;

public class Ansi {

	public static final String RESET = "\u001B[0m";

	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";

	// Bright colors
	public static final String LIGHT_GRAY = "\u001B[90m";
	public static final String BRIGHT_RED = "\u001B[91m";
	public static final String BRIGHT_GREEN = "\u001B[92m";
	public static final String BRIGHT_YELLOW = "\u001B[93m";
	public static final String BRIGHT_BLUE = "\u001B[94m";
	public static final String BRIGHT_PURPLE = "\u001B[95m";
	public static final String BRIGHT_CYAN = "\u001B[96m";
	public static final String BRIGHT_WHITE = "\u001B[97m";

	public static final String PRIMARY_BLUE = "\u001B[38;2;0;114;206m";
	public static final String DARK_NAVY = "\u001B[38;2;0;58;112m";
	public static final String GREEN_ACCENT = "\u001B[38;2;120;190;32m";


	public static String color(String text, String color) {
		return color + text + RESET;
	}
}