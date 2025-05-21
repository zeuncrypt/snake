package com.zeuncrypt.snake.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class SnakeParts {
    private final Vector2 position;
    private final Rectangle bounds;
    private Direction direction = Direction.DOWN;
    private boolean isTurnPosition = false;     // 방향 전환되는 지점인지

    public SnakeParts(float x, float y, float size) {
        x = (float) Math.floor(x);
        y = (float) Math.floor(y);

        this.position = new Vector2(x, y);
        this.bounds = new Rectangle(x, y, size, size);
    }

    public SnakeParts(SnakeParts snakeParts) {
        float x = snakeParts.getPosition().x;
        float y = snakeParts.getPosition().y;
        float size = snakeParts.getBounds().getHeight();

        this.position = new Vector2(x, y);
        this.bounds = new Rectangle(x, y, size, size);
        this.direction = snakeParts.getDirection();
    }

    public void setDirection(Direction direction) {
        if (this.direction != direction) {
            this.isTurnPosition = true;
            this.direction = direction;
        } else {
            this.isTurnPosition = false;
        }
    }

    public void move() {
        switch (direction) {
            case DOWN: {
                this.move(position.x, position.y-1);
                break;
            }
            case UP: {
                this.move(position.x, position.y+1);
                break;
            }
            case LEFT: {
                this.move(position.x-1, position.y);
                break;
            }
            case RIGHT: {
                this.move(position.x+1, position.y);
            }
        }
    }

    public void move(SnakeParts parts) {
        this.move(parts.getPosition().x, parts.getPosition().y);
    }

    public void move(float x, float y) {
        this.bounds.set(x, y, bounds.getWidth(), bounds.getHeight());
        this.position.set(x, y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Direction getDirection() {
        return direction;
    }
}
