package eda.DS;

import java.util.HashMap;
import java.util.Map;

import eda.ADT.interMazeGenerator.MazeGenerator;
import eda.EXCEPTIONS.pequeño;

public class ImplMazeGenerator implements MazeGenerator {

	@Override
	public Maze generate(int rows, int cols) throws pequeño {
		if(rows*cols <= 9 )throw new pequeño();//Aquí iría la excepción 
		Maze n = new Maze(rows,cols);
		Map<String,String> mapaCeldas = new HashMap<>();
		//Mapa de celdas que ya hemos recorrido
		
		//Necesitamos unas celdas base.
		int vi = 1, vj = 1;
		
		n.setInicio(vi+","+vj);

		for(vi = 1; vi < rows ; vi += 2) {
		    for(vj = 1; vj < cols ; vj += 2) {
		        mapaCeldas.put(vi+","+ vj,"");	
		        n.mod(vi, vj);
		        n.setFin(vi+","+vj);
		    }
		}
		
		return n;
	}
	
	public void m(int i, int j, Maze n, Map<String, String> mapaCeldas) {
	    // Si llegamos al destino, paramos.
	    if ((i + "," + j).equals(n.getFin())) {
	        return;
	    }

	    int auxi, auxj;
	    do {
	        int r = (int)(Math.random() * 4);  // 0 a 3
	        auxi = i;
	        auxj = j;

	        switch (r) {
	            case 0: // arriba
	                System.out.println("Dirección: arriba");
	                auxi = i - 1;
	                break;
	            case 1: // derecha
	                System.out.println("Dirección: derecha");
	                auxj = j + 1;
	                break;
	            case 2: // abajo
	                System.out.println("Dirección: abajo");
	                auxi = i + 1;
	                break;
	            case 3: // izquierda
	                System.out.println("Dirección: izquierda");
	                auxj = j - 1;
	                break;
	            default:
	                System.out.println("Valor inesperado: " + r);
	                break;
	        }
	        // Validamos que la nueva posición está dentro del laberinto y no ha sido visitada
	    } while (
	        (auxi <= 0 || auxi >= n.getRows() || auxj <= 0 || auxj >= n.getCols()) ||
	        mapaCeldas.containsKey(auxi + "," + auxj)
	    );

	    // Marcamos la celda como visitada
	    mapaCeldas.put(auxi + "," + auxj, null);
	    n.mod(auxi, auxj);

	    // Llamada recursiva
	    m(auxi, auxj, n, mapaCeldas);
	}


}
