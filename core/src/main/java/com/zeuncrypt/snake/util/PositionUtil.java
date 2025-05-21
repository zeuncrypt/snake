package com.zeuncrypt.snake.util;

import com.badlogic.gdx.math.Vector2;

public class PositionUtil {
	public static Vector2 caculateCenterPosition(float basedWidth, float basedHeight, float layoutWidth, float layoutHeight) {
		return new Vector2(((basedWidth - layoutWidth) / 2), ((basedHeight - layoutHeight) / 2));
	}
}
