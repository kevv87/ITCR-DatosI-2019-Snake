package gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logica.Food;
import logica.Grid;
import logica.Point;
import logica.Snake;

import static logica.Grid.SIZE;


/**
 * Clase encargada de dibujar en el canvas
 * @author Subhomoy Haldar
 * @version 2016.12.17
 * */
public class Painter {
    public static void paint(Grid grid, GraphicsContext gc) {
        gc.setFill(Grid.COLOR);  // Pongo el color negro
        gc.fillRect(0,0, grid.getWidth(), grid.getHeight());  // hago un rectangulo desde abajo hasta arriba de color negro

        // Food
        gc.setFill(Food.COLOR);
        paintPoint(grid.getFood().getPoint(), gc);

        // Snake
        Snake snake = grid.getSnake();
        gc.setFill(Snake.COLOR);
        snake.getPoints().forEach(point -> {paintPoint(point, gc);});
        if(!snake.isSafe()){
            gc.setFill(Snake.DEAD);
            paintPoint(snake.getHead(), gc);
        }

        //Score
        gc.setFill(Color.WHITE);
        gc.fillText("Score: "+100*snake.getPoints().size(), 10, 490);

    }

    /**
     * Metodo que pinta un punto
     * @param point Punto a pintar
     * */
    private static void paintPoint(Point point, GraphicsContext gc){
        // Dado un punto voy a pintar todo el punto
        gc.fillRect(point.getX()*SIZE, point.getY()*SIZE, SIZE, SIZE);

    }

    /**
     * Metodo que escribe el mensaje de resetear
     * */
    public static void paintResetMessage(GraphicsContext gc){
        gc.setFill(Color.AQUAMARINE);
        gc.fillText("Hit RETURN to reset", 10, 10);// Mensaje, posx. posy
    }
}
