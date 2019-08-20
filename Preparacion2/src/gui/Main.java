package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logica.Gameloop;
import logica.Grid;

// Importante que lo extienda
public class Main extends Application{

    private Gameloop loop;
    private Grid grid;
    private GraphicsContext context;

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


        root.getChildren().add(canvas);

        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        primaryStage.setOnCloseRequest(e->System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.show();

        (new Thread(loop)).start();
    }

}
