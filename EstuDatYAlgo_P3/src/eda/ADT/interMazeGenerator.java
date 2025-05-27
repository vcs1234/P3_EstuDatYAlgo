package eda.ADT;

import eda.DS.Maze;
import eda.EXCEPTIONS.pequeño;

public class interMazeGenerator {
	public interface MazeGenerator{
		Maze generate(int rows, int cols) throws pequeño;
	}

}