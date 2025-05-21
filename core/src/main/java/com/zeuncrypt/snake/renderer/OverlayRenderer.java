package com.zeuncrypt.snake.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.zeuncrypt.snake.Main;

public class OverlayRenderer {

    private SpriteBatch batch;
    private FitViewport viewport;
    private ShapeRenderer renderer;

	public OverlayRenderer(Main main) {
		this.renderer = new ShapeRenderer();
        this.batch = main.getBatch();
        this.viewport = main.getViewport();
	}

	public void renderFullScreenOverlay(float r, float g, float b, float a) {
		renderer.setProjectionMatrix(batch.getProjectionMatrix());

		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

		renderer.begin(ShapeRenderer.ShapeType.Filled);

		renderer.setColor(r, g, b, a);
		renderer.rect(0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());

		renderer.end();

		Gdx.gl.glDisable(GL20.GL_BLEND);
	}

	public void dispose() {
		renderer.dispose();
	}
}
