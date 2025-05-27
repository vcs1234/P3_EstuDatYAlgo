package eda.EXCEPTIONS;

//Crear una excepción que hace que si el número de casillas disponible es menor que 9 no se pueda crear el laberinto por la falta de espacio.
public class pequeño extends Exception {
	public pequeño() {
        super("Las dimensiones propuestas son muy pequeñas");
    }
}
