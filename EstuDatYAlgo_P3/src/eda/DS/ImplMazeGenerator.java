package eda.DS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eda.ADT.interMazeGenerator.MazeGenerator;
import eda.EXCEPTIONS.pequeño;

public class ImplMazeGenerator implements MazeGenerator {

	@Override
	public Maze generate(int rows, int cols) throws pequeño {
		if(rows*cols <= 9 )throw new pequeño();//Aquí iría la excepción 
		Maze n = new Maze(rows,cols);
		Map<String,Boolean> mapaCeldas = new HashMap<>();
		//Mapa de celdas que ya hemos recorrido
		
		//Necesitamos unas celdas base.
		int vi = 1, vj = 1;
		
		n.setInicio(vi+","+vj);

		for(vi = 1; vi < rows ; vi += 2) {
		    for(vj = 1; vj < cols ; vj += 2) {
		        mapaCeldas.put(vi+","+ vj,false);
		        n.mod(vi, vj);
		        n.setFin(vi+","+vj);
		    }
		}
		mapaCeldas.put("1,1", true); // <- marcar inicio como visitado
		return m(1,1,n,mapaCeldas);
	}
	
	public Maze m(int i, int j, Maze n, Map<String,Boolean> mapaCeldas) {
	    // Si llegamos al destino, paramos.
	    if ((i + "," + j).equals(n.getFin())) {
	        return n;
	    }
	    
	    // Direcciones: arriba, derecha, abajo, izquierda
	    int[][] dirs = {{-2,0},{0,2},{2,0},{0,-2}};
	    List<int[]> opciones = new ArrayList<>(List.of(dirs));
	    Collections.shuffle(opciones); // Mezclar para aleatoriedad
	    
	    for (int[] dir : opciones) {//(int i = 0, i<opciones.lenght,i++)
	    	int ni = i + dir[0];
	        int nj = j + dir[1];
	        String clave = ni + "," + nj;
	        
	        // Verificar límites y si ya fue visitado
	        if (ni > 0 && ni < n.getRows() && nj > 0 && nj < n.getCols() && !mapaCeldas.getOrDefault(clave, false)) {
	            // Marcar celda intermedia como vacía (romper pared)
	            int midI = i + dir[0]/2;
	            int midJ = j + dir[1]/2;
	            n.mod(midI, midJ);

	            // Marcar la celda
	            mapaCeldas.put(clave, true);

	            // Recursión
	            m(ni, nj, n, mapaCeldas);
	            
	        }
	    }return n;// El return prodría ir antes, en el for pero lo ponemos aquí para que hayn más caminos.
	}
}