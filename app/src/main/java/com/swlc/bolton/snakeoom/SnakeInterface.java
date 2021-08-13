package com.swlc.bolton.snakeoom;

import java.awt.geom.Ellipse2D;
import java.util.List;

public interface SnakeInterface {

    void changeDirection(Route route);

    void move();

    List<Ellipse2D.Double> getParts();

    void check();

    boolean isGameOver();
}
