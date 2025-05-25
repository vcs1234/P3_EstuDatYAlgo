package eda.DS;

import java.util.HashMap;
import java.util.Map;

import eda.ADT.interMazeGenerator.MazeGenerator;

public class ImplMazeGenerator implements MazeGenerator {

	@Override
	public Maze generate(int rows, int cols) {
		if(rows*cols <= 9 )return null;//Aquí iría la excepción 
		//Crear una excepción que hace que si el número de casillas disponible es menor que 9 no se pueda crear el laberinto por la falta de espacio.
		
		Map<int[],String> mapaCeldas = new HashMap<>();
		//Necesitamos unas celdas base.
		int vi = 0, vj = 0;
		int yj = 0, xi = 0;

		for(int i = 0; i < rows / 3; i++) {
		    for(int j = 0; j < cols / 3; j++) {
		    	xi = (int)(Math.random() * 3); // entre 0 y 2
		        yj = (int)(Math.random() * 3); // entre 0 y 2
		        gceldas(vi + xi, vj + yj);
		        vj += 3;
		    }
		    vi += 3;
		    vj = 0;
		}

		return null;
	}
	
	public static int[] gceldas(int valor1, int valor2) {
        int[] resultado = new int[2];
        resultado[0] = valor1;
        resultado[1] = valor2;
        return resultado;
    }

}
