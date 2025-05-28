package eda.SOLUTIONS;

import java.util.List;

import eda.EXCEPTIONS.fuera;
import eda.EXCEPTIONS.pequeño;
import eda.ADT.interMazeGenerator.MazeGenerator;
import eda.ADT.interMazeSolver.MazeSolver;
import eda.DS.ImplMazeGenerator;
import eda.DS.ImplMazeSolver;
import eda.DS.Maze;

public class MAIN {
    public static void main(String[] args) {
        try {
            //  Crear generador y laberinto
            MazeGenerator generator = new ImplMazeGenerator();
            Maze maze = generator.generate(6, 6); // >=9 celdas, OK
            System.out.println("Laberinto generado:");
            maze.p();

            //  Mostrar inicio y fin
            System.out.println("\nInicio: " + maze.getInicio());
            System.out.println("Fin: " + maze.getFin());

            //  Convertir String "x,y" a int[]
            int[] inicio = parsePos(maze.getInicio());
            int[] fin = parsePos(maze.getFin());

            //  Probar método move() desde inicio hacia la derecha
            
           int[] moved = maze.move(inicio, 0, 1); // moverse a la derecha
           System.out.println("\nMovimiento válido a la derecha: (" + moved[0] + "," + moved[1] + ")");

            //  Resolver el laberinto
            MazeSolver solver = new ImplMazeSolver();
            List<int[]> path = solver.solve(maze, inicio, fin);

            System.out.println("\nRuta encontrada:");
            for (int[] step : path) {
                System.out.println("(" + step[0] + "," + step[1] + ")");
            }

        } catch (pequeño e) {
            System.out.println("Excepción: " + e.getMessage());
        } catch (fuera e) {
            System.out.println("Excepción: " + e.getMessage());
        }

    }

    // Método de utilidad para convertir "i,j" en int[]{i,j}
    private static int[] parsePos(String s) {
        String[] parts = s.split(",");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }
}
