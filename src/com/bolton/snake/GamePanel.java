package com.bolton.snake;

public class GamePanel implements Runnable {

	public static final int DELAY = 400;

	private Main main;
	private GaminField gameField;
	private Snake snake;
	private Food food;

	public GamePanel(GaminField gameField, Snake snake, Main main) {
		food = new Food(100, 100);
		this.main = main;
		this.snake = snake;
		this.gameField = gameField;

		this.gameField.setSnakeParts(snake.getParts());
		this.gameField.setApple(food);
	}

	@Override
	public void run() {
		try {
			while (true) {
				snake.move();
				snake.check();
				if (snake.isGameOver()) {
					Thread.currentThread().interrupt();
				}
				if (!Thread.currentThread().isInterrupted()) {
					gameField.repaint();
				}
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException ex) {
			main.gameOver();
		}
	}

}
