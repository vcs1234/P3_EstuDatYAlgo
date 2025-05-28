package eda.DS;

import java.util.ArrayList;
import java.util.List;

import eda.ADT.interMazeSolver.MazeSolver;

public class ImplMazeSolver implements MazeSolver {

	@Override
	public List<int[]> solve(Maze maze, int[] origin, int[] destination) {
		int vi = origin[0],vj = origin[1], xi=destination[0], xj = destination[1];
		List<int[]> r = new ArrayList<>();
		
		r.add(origin);
		return r;//Devolvemos la lista de las celdas(el camino) con el coste mínimo.
	}
	
	public void findway(Maze maze, List<int[]> r, int[] pos, int[] destination){
		int vi = pos[0],vj = pos[1], xi=destination[0], xj = destination[1];
		if (vi == xi && vj == xj) return;
		int [][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		if (maze[vi +1] == EMPTY && !list.contains(maze[vi +1])) {	
			findway( maze,  r,  maze.move(pos, 1, 0), destination);
		}
		if (maze[vi -1] == EMPTY && !list.contains(maze[vi -1])) {	
			findway( maze,  r,  maze.move(pos, 0, 1), destination);
		}
		if (maze[vi][vj +1] == EMPTY && !list.contains(maze[vi +1])) {	
			findway( maze,  r,  maze.move(pos, -1, 0), destination);
		}
		if (maze[vi][vj +1] == EMPTY && !list.contains(maze[vi +1])) {	
			findway( maze,  r,  maze.move(pos, 0, -1), destination);
		}
	}

}
