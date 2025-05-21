package com.zeuncrypt.snake.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.zeuncrypt.snake.Main;
import com.zeuncrypt.snake.model.Snake;
import com.zeuncrypt.snake.model.SnakeParts;
import com.zeuncrypt.snake.model.Direction;
import com.zeuncrypt.snake.renderer.SnakeRenderer;
import com.zeuncrypt.snake.util.PositionUtil;

import java.util.LinkedList;
import java.util.Queue;

public class GameScreen extends com.zeuncrypt.snake.base.BaseScreen {

    private SnakeRenderer snakeRenderer;
    private Snake snake;

    private static final float FIXED_TIMESTAEP = 0.5f;
    private float accumulator = 0f;

    public GameScreen(Main game) {
        super(game);

        this.snake = new Snake(viewport.getWorldWidth(), viewport.getWorldHeight());
        this.snakeRenderer = new SnakeRenderer(snake, batch);
    }

    @Override
    protected void draw() {
        snakeRenderer.render();


        // 위치 업데이트
        accumulator += Gdx.graphics.getDeltaTime();
        if (accumulator >= FIXED_TIMESTAEP) {
            // 경과 시간 초기화
            accumulator = 0f;
            snake.move();
        }
    }

}
