package eda.ADT;

import java.util.List;

import eda.DS.Maze;
import eda.EXCEPTIONS.fuera;

public class interMazeSolver {
	public interface MazeSolver {
		List<int[]> solve(Maze maze, int[] origin, int[] destination) throws fuera;
	}
}
