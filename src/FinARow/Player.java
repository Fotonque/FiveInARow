package FinARow;

import javafx.scene.paint.Color;

public class Player {
    private static int id_iteration = 1;
    private int id;
    private Color color;

    public Player(){
        this.id = id_iteration;

        this.color = Color.rgb(
                (int) ((Math.random() * 255-0) + 0),
                (int) ((Math.random() * 255-0) + 0),
                (int) ((Math.random() * 255-0) + 0));
        id_iteration++;
    }

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }
}
