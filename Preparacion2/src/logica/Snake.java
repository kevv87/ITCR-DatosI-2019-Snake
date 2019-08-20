package logica;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase que representa la serpiente.
 * Va a necesitar:
 *   Atributos:
 *     Su Largo
 *     Si esta Viva
 *     Los puntos que la conforman
 *     Una referencia a la cabeza
 *     Su velocidad en X y en Y
 *   Metodos:
 *     Constructor: Toma el punto inicial y el grid donde va a vivir
 *     Un metodo para crecer
 *     Un metodo de movimiento
 *     Un metodo para comer
 *     Un metodo para cada direccion
 *     Getters y setters apropiados
 * */
public class Snake {

    public static final Color COLOR = Color.CORNSILK;
    public static final Color DEAD = Color.RED;
    private Grid grid;
    private int length;
    private boolean safe;
    private List<Point> points;
    private Point head;
    private int xVelocity;
    private int yVelocity;

    /**
     * Constructor
     * @param initialPoint El punto donde se va a poner la cabeza de la serpiente
     * */
    public Snake(Grid grid, Point initialPoint) {
        length = 1;  // largo inicial
        points = new LinkedList<>(); // Lista de puntos
        points.add(initialPoint);  // agrego la cabeza a la lista de puntos
        head = initialPoint;
        safe = true;
        this.grid = grid;

        // Inicia detenido
        xVelocity = 0;
        yVelocity = 0;
    }
    /**
     * This method is called after food has been consumed. It increases the length of the
     * snake by one.
     *
     * @param point The Point where the food was and the new location for the head.
     */
    private void growTo(Point point) {
        length++;  // Le sumo a la longitud
        checkAndAdd(point);  // Agrego un punto
    }

    /**
     * Called during every update. It gets rid of the oldest point and adds the given point.
     *
     * @param point The new Point to add.
     */
    private void shiftTo(Point point) {
        // The head goes to the new location
        checkAndAdd(point);
        // The last/oldest position is dropped
        points.remove(0);
    }

    /**
     * Checks for an intersection and marks the "safe" flag accordingly.
     *
     * @param point The new Point to move to.
     */
    private void checkAndAdd(Point point) {
        point = grid.wrap(point);  // si el punto esta fuera de la pantalla lo pongo dentro
        safe &= !points.contains(point);  // Sigue estando segura si el punto no forma parte de sus propios puntos
        points.add(point);  // Agrego el nuevo punto a la lista de puntos
        head = point;  // Muevo la cabeza
    }
    /**
     * @return The points occupied by the snake.
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * @return {@code true} if the Snake hasn't run into itself yet.
     */
    public boolean isSafe() {
        return safe || length == 1;
    }

    /**
     * @return The location of the head of the Snake.
     */
    public Point getHead() {
        return head;
    }

    private boolean isStill() {
        return xVelocity == 0 & yVelocity == 0;
    }

    /**
     * Make the snake move one square in it's current direction.
     */
    public void move() {
        if (!isStill()) {
            shiftTo(head.translate(xVelocity, yVelocity));
        }
    }

    /**
     * Make the snake extend/grow to the square where it's headed.
     */
    public void extend() {
        if (!isStill()) {
            growTo(head.translate(xVelocity, yVelocity));
        }
    }

    // Metodos para las teclas
    public void setUp() {
        if (yVelocity == 1 && length > 1) return;
        xVelocity = 0;
        yVelocity = -1;
    }

    public void setDown() {
        if (yVelocity == -1 && length > 1) return;
        xVelocity = 0;
        yVelocity = 1;
    }

    public void setLeft() {
        if (xVelocity == 1 && length > 1) return;
        xVelocity = -1;
        yVelocity = 0;
    }

    public void setRight() {
        if (xVelocity == -1 && length > 1) return;
        xVelocity = 1;
        yVelocity = 0;
    }

}
