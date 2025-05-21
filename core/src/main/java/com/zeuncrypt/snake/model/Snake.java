package com.zeuncrypt.snake.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.zeuncrypt.snake.util.PositionUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Snake {
    private final Queue<SnakeParts> parts;
    private Direction direction = Direction.DOWN;

    public Snake(float width, float height) {
        this.parts = new LinkedList<SnakeParts>();

        Vector2 position = PositionUtil.caculateCenterPosition(width, height, 1,1);
        this.initSnake(position);
    }

    public void initSnake(Vector2 position) {
        parts.add(new SnakeParts(position.x, position.y, 1));
        parts.add(new SnakeParts(position.x, position.y+1, 1));
    }

    public Queue<SnakeParts> getParts() {
        return parts;
    }

    public void move() {
        SnakeParts targetPosition = null;

        int i = 0;
        for (SnakeParts p : parts) {
            if (targetPosition != null) {   // 머리 외
                p.move(targetPosition);
                targetPosition = new SnakeParts(p);
            } else {    // 머리
                targetPosition = new SnakeParts(p);
                p.setDirection(direction);
                p.move();
            }
            i++;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
