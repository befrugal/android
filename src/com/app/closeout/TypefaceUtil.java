package com.app.closeout;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

// See https://code.google.com/p/android/issues/detail?id=9904
public class TypefaceUtil {
	private static final Map<String, Typeface> sTypefaceCache = new HashMap<String, Typeface>();

	private static final String ROBOTO_R = "RobotoCondensed-Regular.ttf";
	private static final String ROBOTO_R_I = "RobotoCondensed-Italic.ttf";
	private static final String ROBOTO_B = "RobotoCondensed-Bold.ttf";
	private static final String ROBOTO_B_I = "RobotoCondensed-BoldItalic.ttf";
	private static final String PACIFICO = "Pacifico.ttf";

	private static String getTypefaceName(int typefaceCode) {
		switch (typefaceCode) {
		case 0:
			return ROBOTO_R;

		case 1:
			return ROBOTO_R_I;

		case 2:
			return ROBOTO_B;

		case 3:
			return ROBOTO_B_I;

		case 4:
			return PACIFICO;

		default:
			return null;
		}
	}

	public static Typeface getAndCache(Context context, int typefaceCode) {
		synchronized (sTypefaceCache) {

			String typefaceName = getTypefaceName(typefaceCode);

			if (!sTypefaceCache.containsKey(typefaceName)) {
				Typeface tf = Typeface.createFromAsset(context
						.getApplicationContext().getAssets(), typefaceName);
				sTypefaceCache.put(typefaceName, tf);
			}
			return sTypefaceCache.get(typefaceName);
		}
	}
}
