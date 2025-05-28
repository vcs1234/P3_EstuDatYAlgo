package eda.DS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import eda.ADT.interMazeSolver.MazeSolver;
import eda.EXCEPTIONS.fuera;

public class ImplMazeSolver implements MazeSolver {

	@Override
	public List<int[]> solve(Maze maze, int[] origin, int[] destination) throws fuera {
	    List<int[]> r = new ArrayList<>();
	    findway(maze, r, origin, destination);
	    return r; // Devuelve el camino desde origen a destino
	}
	
	public boolean findway(Maze maze, List<int[]> r, int[] pos, int[] destination) throws fuera {
	    int vi = pos[0], vj = pos[1];
	    int xi = destination[0], xj = destination[1];
		
	    if (maze.data[vi][vj] != 0 || yaVisitado(r, pos)) return false;

	    r.add(pos);

	    if (vi == xi && vj == xj) return true;

	    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	    for (int[] d : dir) {
	        try {
	            int[] next = maze.move(pos, d[0], d[1]);
	            if (findway(maze, r, next, destination)) return true;
	        } catch (fuera e) {
	            // Movimiento fuera del laberinto, ignorar
	        }
	    }
	    
	    r.remove(r.size() - 1); // backtracking si no hay camino
	    return false;
	}
	
	private boolean yaVisitado(List<int[]> r, int[] pos) {
	    for (int[] p : r) {
	        if (Arrays.equals(p, pos)) return true;
	    }
	    return false;
	}
}