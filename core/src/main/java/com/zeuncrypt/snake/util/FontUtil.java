package com.zeuncrypt.utils;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class FontUtil {
	private FontUtil() {}

	public static void drawCenteredText(BitmapFont font, SpriteBatch batch, String text, float worldWidth, float worldHeight) {
		GlyphLayout layout = new GlyphLayout();
		layout.setText(font, text);

		Vector2 position = PositionUtil.caculateCenterPosition(worldWidth, worldHeight, layout.width, layout.height);

		font.draw(batch, layout, position.x, position.y);
	}
}
