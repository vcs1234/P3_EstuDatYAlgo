package eda.ADT;

import eda.DS.Maze;

public class interMazeGenerator {
	public interface MazeGenerator{
		Maze generate(int rows, int cols);
	}

}
