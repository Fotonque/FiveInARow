package FinARow;

import javafx.scene.shape.Rectangle;

public class Cell {
    static final int NO_OCCUPATION = 0;
    private int occupation;
    private Rectangle image;

    public Rectangle getImage() {
        return image;
    }

    public void setImage(Rectangle image) {
        this.image = image;
    }

    public Cell(Rectangle image){
        this.occupation = NO_OCCUPATION;
        this.image = image;
    }

    public Cell(int occupation){
        this.occupation = occupation;
    }

    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

}
