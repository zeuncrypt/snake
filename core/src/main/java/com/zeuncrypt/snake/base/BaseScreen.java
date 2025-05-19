package com.zeuncrypt.snake.base;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.zeuncrypt.snake.Main;
import com.zeuncrypt.snake.renderer.OverlayRenderer;

public abstract class BaseScreen implements Screen {

	protected final Main game;

    protected final SpriteBatch batch;
    protected final BitmapFont font;
    protected final FitViewport viewport;

	protected final OverlayRenderer overlayRenderer;

	public BaseScreen(final Main game) {
		this.game = game;

        this.batch = game.getBatch();
        this.font = game.getFont();
        this.viewport = game.getViewport();

		this.overlayRenderer = new OverlayRenderer(game);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(Color.WHITE);

		viewport.apply();
		batch.setProjectionMatrix(viewport.getCamera().combined);

		batch.begin();
		this.draw();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	protected abstract void draw();
}
