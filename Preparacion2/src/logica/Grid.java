package logica;

import javafx.scene.paint.Color;

import java.util.Random;

/**
 * El sistema posicional del juego. El sera renderizado por el Canvas despues.
 *
 * @author Subhomoy Haldar
 * @version 2016.12.17
 * */

public class Grid {

    public static final int SIZE = 10;  // quiero que cada casilla sea de diez pixeles
    public static final Color COLOR = new Color(0.1,0.1,0.1,0.1); // Quiero que tenga un color negro

    private final int cols; // Columnas
    private final int rows; // Rows

    private Snake snake; // Instancia de la clase Snake para tener una referencia a ella
    private Food food; // Lo mismo con food

    /**
     * Constructor de la clase
     * @param width Largo del grid
     * @param height Alto del grid
     * */
    public Grid(final double width, final double height){  // Constructor
        rows = (int) width/SIZE;
        cols = (int) height/SIZE;

        // Inicializar la serpiente

        // Inicializar la comida

    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public double getWidth() {
        return rows * SIZE;
    }

    public double getHeight() {
        return cols * SIZE;
    }

}
