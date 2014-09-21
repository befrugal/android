package com.app.closeout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class TypefaceButton extends Button {

	public TypefaceButton(Context context) {
		super(context);
		init(context, null, 0);
	}

	public TypefaceButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs, defStyle);
	}

	public TypefaceButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs, 0);
	}

	private void init(Context context, AttributeSet attrs, int defStyle) {
		final TypedArray styledAttrs = context.obtainStyledAttributes(attrs,
				R.styleable.TypefacedTextView, defStyle, 0);
		int typefaceCode = styledAttrs.getInt(
				R.styleable.TypefacedTextView_fontStyle, -1);
		int shadowDx = styledAttrs.getDimensionPixelSize(
				R.styleable.TypefacedTextView_shadowDx, 0);
		int shadowDy = styledAttrs.getDimensionPixelSize(
				R.styleable.TypefacedTextView_shadowDy, 0);
		int shadowRadius = styledAttrs.getDimensionPixelSize(
				R.styleable.TypefacedTextView_shadowRadius, 0);
		int shadowColor = styledAttrs.getColor(
				R.styleable.TypefacedTextView_shadowColor, 0);
		//styledAttrs.recycle();

		if (isInEditMode()) {
			return;
		}

		if (shadowColor != 0) {
			setShadowLayer(shadowRadius, shadowDx, shadowDy, shadowColor);
		}

		Typeface typeface = TypefaceUtil.getAndCache(context, typefaceCode);
		setTypeface(typeface);
	}

}
