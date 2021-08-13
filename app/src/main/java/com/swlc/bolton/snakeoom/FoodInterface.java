package com.swlc.bolton.snakeoom;

import com.swlc.bolton.snakeoom.impl.Snake;

import java.awt.geom.Ellipse2D;

public interface FoodInterface {

    void next(Snake snake);

    Ellipse2D.Double getShape();
}
