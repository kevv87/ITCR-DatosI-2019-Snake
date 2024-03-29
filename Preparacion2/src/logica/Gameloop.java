package logica;

import gui.Painter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase encargada del loop general del juego, tiene que implementar Runnable
 * porque es un hilo.
 * @author Subhomoy Haldar
 * @version 2016.12.17
 * */
public class Gameloop implements Runnable{

    private final Grid grid;
    private final GraphicsContext context;
    private int frameRate; // Tasa a la que voy a actualizar
    private float interval;
    private boolean running; // El juego esta corriendo
    private boolean paused; // El juego esta pausado
    private boolean keyIsPressed; // Tecla presionada

    /**
     * Constructor
     * */
    public Gameloop(final Grid grid, final GraphicsContext context){
        this.grid = grid;
        this.context = context;
        frameRate = 20;
        interval = 1000.0f / frameRate; // 1 segundo
        running = true;
        paused = false;
        keyIsPressed = false;
    }

    @Override
    public void run() {
        while(running & !paused){ // Mientras este corriendo y no este pausado
            float time = System.currentTimeMillis();
            keyIsPressed = false;
            grid.update();
            Painter.paint(grid, context);

            // Agregar el verificador de muerte
            // Si la serpiente no esta segura, pause
            if(!grid.getSnake().isSafe()){
                pause();
                Painter.paintResetMessage(context);
                break;  // Termina el while
            }

            // Ajustes del hilo
            time = System.currentTimeMillis() - time;
            if(time<interval){
                try{
                    Thread.sleep((long)(interval-time));
                }catch(InterruptedException ignore){
                }
            }
        }
    }

    public boolean isKeyPressed(){
        return keyIsPressed;
    }

    public boolean isPaused() {
        return paused;
    }

    public void pause(){
        paused = true;
    }
}
