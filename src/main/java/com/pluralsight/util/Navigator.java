package com.pluralsight.util;

import com.pluralsight.ui.interfaces.MenuScreen;

import java.util.ArrayList;

public class Navigator {
	private static final ArrayList<MenuScreen> screenHistory = new ArrayList<>();

	public static int getCurrentScreen() {
		return screenHistory.size();
	}

	public static void goToNextScreen(MenuScreen nextScreen) {
		screenHistory.add(nextScreen);
		nextScreen.displayMenu();
	}



}
