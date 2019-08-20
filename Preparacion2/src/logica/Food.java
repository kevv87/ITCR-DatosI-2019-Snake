package logica;

import javafx.scene.paint.Color;

/**
 * Clase que representa la comida.
 * Atributos:
 *   Color
 *   Punto
 * Metodos:
 *   Getters & Setters
 * */
public class Food {
    public static final Color COLOR = Color.ROSYBROWN;

    private Point point;

    Food(Point point){
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
