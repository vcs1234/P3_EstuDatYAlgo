package eda.DS;

import eda.EXCEPTIONS.fuera;

public class Maze {
	public static final int EMPTY = 0;
	public static final int WALL = 1;
	public int[][] data;
	public int rows;
	public int cols;
	public String inicio, fin;
	public Maze(int rows, int cols) {
		this.data = new int[rows][cols];
		this.rows = rows;
		this.cols = cols;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				data[i][j] = WALL;
	}
	public void mod (int r, int c) {
		data[r][c] = EMPTY; 
	}
	
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	
	public int[] move(int [] p, int vi, int vj) throws fuera {// Para moverse dento del maze.
		if(p[0] + vi> rows || p[0] + vi <0) {
			throw new fuera();
		}else {p[0] += vi;}
		if(p[1]+vj>cols || p[1] + vi < 0) {
			throw new fuera();
		}else {
			p[1] += vj;
		}
		return p;
		
	}
	
	public void p() {
		for( int i = 0; i<data.length; i++) {
			for(int j = 0; j<data[i].length; j++) {
				if(data[i][j] == EMPTY) {
					System.out.print(" ");
				}else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}
}