package map;

import java.util.ArrayList;
import blocks.Block;
import blocks.ClosedBlock;
import blocks.GoalBlock;
import blocks.finder;

public class MapSolver {

	private static Map map;
	private static boolean isSolved = false;
	private static int NumberOfSteps = 0;
	private static ArrayList<Integer> visitedX = new ArrayList<Integer>();
	private static ArrayList<Integer> visitedY = new ArrayList<Integer>();

	public static void solveMap(Map map) {
		MapSolver.map = map;
		int startX = map.getStartX();
		int startY = map.getStartY();

		visitedX.add(startX);
		visitedY.add(startY);

		solve(startX, startY, 1); // up
		solve(startX, startY, 2); // höger
		solve(startX, startY, 3); // ner
		solve(startX, startY, 4); // vänster
	}

	public static void solve(int x, int y, int dir) {
		if (NumberOfSteps > 1000 || isSolved) {
			return;
		}
		switch (dir) {
		case 1:
			y--;
			break;
		case 2:
			x++;
			break;
		case 3:
			y++;
			break;
		case 4:
			x--;
			break;

		default:
			break;
		}

		Block b = map.getBlock(x, y);
		if (b instanceof ClosedBlock) {
			return;
		}
		if (b == null) {
			return;
		}
		if (visited(x, y)) {
			return;
		}
		NumberOfSteps++;
		visitedX.add(x);
		visitedY.add(y);
		if (b instanceof GoalBlock) {
			System.out.println("Number of Steps: " + NumberOfSteps);
			isSolved = true;
			return;
		}
		if (dir == 1) {
			solve(x, y, 1);
			solve(x, y, 2);
			solve(x, y, 4);
		}
		if (dir == 2) {
			solve(x, y, 1);
			solve(x, y, 3);
			solve(x, y, 2);
		}
		if (dir == 3) {
			solve(x, y, 3);
			solve(x, y, 2);
			solve(x, y, 4);
		}
		if (dir == 4) {
			solve(x, y, 1);
			solve(x, y, 3);
			solve(x, y, 4);
		}

	}

	public static void add(int times) {
		if (times >= visitedX.size()) {
			return;
		} else {
			finder cir = new finder(visitedX.get(times), visitedY.get(times));

			if (times >= 900) {
				cir.setVisible(false);
			}
			map.getChildren().add(cir);
		}
	}

	public static boolean visited(int x, int y) {
		for (int i = 0; i < visitedX.size(); i++) {
			if (x == visitedX.get(i) && y == visitedY.get(i)) {
				return true;
			}
		}
		return false;
	}

}