package world;

import java.awt.Color;
import java.util.ArrayList;

public class Level2 implements GameLevel {

	private int speed=3;
	private ArrayList<Color> colors;
	private ArrayList<String> shapePaths;
	private int ScoreLimit=5;
	private int timeLimit=5;
	private int size=25;

	public Level2() {
		colors = new ArrayList<>();
		colors.add(Color.RED);
		colors.add(Color.GREEN);
		colors.add(Color.BLUE);
		colors.add(Color.YELLOW);
		colors.add(Color.orange);
		shapePaths = new ArrayList<>();
		shapePaths.add("n22.png");
		shapePaths.add("n33.png");
		shapePaths.add("n44.png");

	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;

	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setColors(ArrayList<Color> colors) {
		this.colors = colors;
	}

	@Override
	public ArrayList<Color> getColors() {
		return this.colors;
	}

	@Override
	public void setShapePaths(ArrayList<String> paths) {
		this.shapePaths = paths;
	}

	@Override
	public ArrayList<String> getShapePaths() {
		// TODO Auto-generated method stub
		return this.shapePaths;
	}

	@Override
	public void setScoreLimit(int score) {
		this.ScoreLimit = score;

	}

	@Override
	public int getScoreLimet() {

		return ScoreLimit;
	}

	@Override
	public void setTimeLimit(int time) {

		this.timeLimit = time;
	}

	@Override
	public int getTimeLimit() {

		return timeLimit;
	}

	@Override
	public int getString() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

}
