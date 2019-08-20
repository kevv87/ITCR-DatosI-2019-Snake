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

    public static final int SIZE = 10;
    public static final Color COLOR = new Color(0.1, 0.1, 0.1, 1);

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
        snake = new Snake(this, new Point(rows/2, cols/2));

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



    public double getWidth() {
        return rows * SIZE;
    }

    public double getHeight() {
        return cols * SIZE;
    }

    /**
     * Esto es para que la serpiente se devuelva al lado opuesto
     * de la pantalla si se sale
     * */
    public Point wrap(Point point) {
        int x = point.getX();
        int y = point.getY();
        if (x >= rows) x = 0;
        if (y >= cols) y = 0;
        if (x < 0) x = rows - 1;
        if (y < 0) y = cols - 1;
        return new Point(x, y);
    }

    public void update(){
        // Si el punto de la comida es igual al punto de la cabeza, extender, si no mover
        snake.move();
    }

}
