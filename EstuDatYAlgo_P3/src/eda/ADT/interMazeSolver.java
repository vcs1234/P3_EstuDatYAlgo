package eda.ADT;

import java.util.List;

import eda.DS.Maze;

public class interMazeSolver {
	public interface MazeSolver {
		List<int[]> solve(Maze maze, int[] origin, int[] destination);
	}
}
