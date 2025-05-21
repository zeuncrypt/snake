package com.zeuncrypt.snake.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zeuncrypt.snake.model.Direction;
import com.zeuncrypt.snake.model.Snake;
import com.zeuncrypt.snake.model.SnakeParts;

import java.util.Queue;

public class SnakeRenderer {

    private SpriteBatch batch;

    private Snake snake;

    private Texture head;
    private Texture body;
    private Texture tail;

    public SnakeRenderer(Snake snake, SpriteBatch batch) {
        this.batch = batch;
        this.snake = snake;

        this.head = new Texture("head.png");
        this.body = new Texture("body.png");
        this.tail = new Texture("tail.png");
    }

    public void render() {
        this.renderSnake();
    }

    private void renderSnake() {
        int idx = 0;
        for (SnakeParts p : snake.getParts()) {
            Texture currentTexture = body;
            if (idx == 0) {
                currentTexture = head;
            } else if (idx == snake.getParts().size() - 1) {
                currentTexture = tail;
            }

            batch.draw(currentTexture, p.getPosition().x, p.getPosition().y, p.getBounds().width, p.getBounds().height);
            Gdx.app.log("DEBUG", String.format("[%d] x: %f, y: %f", idx, p.getPosition().x, p.getPosition().y));

            idx++;
        }
    }
}

