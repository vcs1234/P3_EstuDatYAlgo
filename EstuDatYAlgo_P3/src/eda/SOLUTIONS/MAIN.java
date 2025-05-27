package eda.SOLUTIONS;

import eda.EXCEPTIONS.pequeño;
import eda.ADT.interMazeGenerator.MazeGenerator;
import eda.DS.Maze;
import eda.DS.ImplMazeGenerator;

public class MAIN {
    public static void main(String[] args) {
        try {
            MazeGenerator generator = new ImplMazeGenerator(); // ✅ Instancia del generador
            Maze m = generator.generate(6, 6);                 // ✅ Generación del laberinto
            m.p();                                             // ✅ Imprimir laberinto
        } catch (pequeño e) {
            System.out.println(e.getMessage());
        }
    }
}
