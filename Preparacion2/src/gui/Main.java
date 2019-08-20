package gui;

import com.sun.javaws.IconUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logica.Gameloop;
import logica.Grid;
import logica.Snake;

import static java.awt.Event.*;
import static javax.swing.JSplitPane.LEFT;
import static javax.swing.JSplitPane.RIGHT;

// Importante que lo extienda
public class Main extends Application{

    private Gameloop loop;
    private Grid grid;
    private GraphicsContext context;

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String[] args){
        Application.launch(args);  // Esto es necesario, inicia la app
    }

    // Metodo necesario, tambien, es como el constructor de la clase
    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(500,500);
        context = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);

        // Agregar el listener de los eventos
       canvas.setOnKeyPressed(event -> {
           Snake snake = grid.getSnake();
           if(loop.isKeyPressed()){
               return;
           }
           switch (event.getCode()) {
                case UP:  // Arriba
                    snake.setUp();
                    break;
                case DOWN:  // Abajo
                    snake.setDown();
                    break;
                case LEFT:  // Izquierda
                    snake.setLeft();
                    break;
                case RIGHT:  // Derecha
                    snake.setRight();
                    break;
                case ENTER:  // Pausa
                    if (loop.isPaused()) {
                        reset();  // Resetea
                        (new Thread(loop)).start();
                    }
            }
       });

        reset();

        root.getChildren().add(canvas);

        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        primaryStage.setOnCloseRequest(e->System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.show();

        (new Thread(loop)).start();
    }

    private void reset(){ // Inicializa un nuevo juego
        grid = new Grid(WIDTH, HEIGHT);
        loop = new Gameloop(grid, context);
        Painter.paint(grid, context);
    }

}
