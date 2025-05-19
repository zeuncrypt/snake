package com.zeuncrypt.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.zeuncrypt.TicTacToe;
import com.zeuncrypt.view.OverlayRenderer;

public abstract class BaseScreen implements Screen {

	protected final TicTacToe game;
	protected final OverlayRenderer overlayRenderer;

	public BaseScreen(final TicTacToe game) {
		this.game = game;
		this.overlayRenderer = new OverlayRenderer(game);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(Color.WHITE);

		game.viewport.apply();
		game.batch.setProjectionMatrix(game.viewport.getCamera().combined);

		game.batch.begin();
		this.draw();
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		game.viewport.update(width, height, true);
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
