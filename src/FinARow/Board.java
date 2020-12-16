package FinARow;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Board {
    private GameSettings settings;
    private Group root;
    private Scene window;
    private ArrayList<ArrayList<Cell>> state;
    private boolean gameFinished = false;

    public boolean isGameFinished() {
        return gameFinished;
    }

    public GameSettings getSettings() {
        return settings;
    }

    public void setSettings(GameSettings settings) {
        this.settings = settings;
    }

    public Group getRoot() {
        return root;
    }

    public void setRoot(Group root) {
        this.root = root;
    }

    public Scene getWindow() {
        return window;
    }

    public void setWindow(Scene window) {
        this.window = window;
    }

    public Board(GameSettings gameSettings){
        this.settings = gameSettings;
        this.state = new ArrayList<ArrayList<Cell>>();
        this.root = new Group();
        this.window = new Scene(this.root, gameSettings.getScreenWidth(), gameSettings.getScreenHeight());

        float cellWidth = this.settings.getScreenWidth() / this.settings.getBoardSizeX();
        float cellHeight = this.settings.getScreenHeight() / this.settings.getBoardSizeY();
        float offsetX = 0;
        float offsetY = 0;
        for (int i = 0; i < this.settings.getBoardSizeY(); i++){
            ArrayList<Cell> tmpRow = new ArrayList<Cell>();
            for (int j = 0; j < this.settings.getBoardSizeX(); j++) {
                Rectangle r = new Rectangle();
                r.setHeight(cellHeight);
                r.setWidth(cellWidth);
                r.setX(offsetX);
                r.setY(offsetY);
                r.setFill(Color.WHITE);
                r.setStroke(Color.BLACK);
                r.setStrokeWidth(1);
                this.root.getChildren().add(r);
                offsetX += cellWidth;
                tmpRow.add(new Cell(r));
            }
            offsetX = 0;
            offsetY += cellHeight;
            this.state.add(tmpRow);
        }
    }

    private Cell getByPosition(int row, int column){
        ArrayList<Cell> tmpRow = this.state.get(row);
        return tmpRow.get(column);
    }

    private boolean check_NS(Player player, int row, int column){
        int inARow = 1;
        int iteration = 1;
        boolean blockCheckToTop = false;
        boolean bloackCheckToBottom = false;

        while (iteration <= this.settings.getRequiredInARow()) {
            if ((row + iteration < this.settings.getBoardSizeY()) && !bloackCheckToBottom) {
                if (getByPosition(row, column).getOccupation() == getByPosition(row + iteration, column).getOccupation()) {
                    inARow++;
                } else {
                    bloackCheckToBottom = true;
                }
            }

            if ((row - iteration >=0) && !blockCheckToTop){
                if (getByPosition(row, column).getOccupation() == getByPosition(row - iteration, column).getOccupation()){
                    inARow++;
                } else {
                    blockCheckToTop = true;
                }
            }
            iteration++;
        }

        if (inARow >= this.settings.getRequiredInARow()){
            return true;
        }

        return false;
    }

    private boolean check_WE(Player player, int row, int column){
        int inARow = 1;
        int iteration = 1;
        boolean blockCheckToTop = false;
        boolean bloackCheckToBottom = false;

        while (iteration <= this.settings.getRequiredInARow()) {
            if ((column + iteration < this.settings.getBoardSizeX()) && !bloackCheckToBottom) {
                if (getByPosition(row, column).getOccupation() == getByPosition(row, column + iteration).getOccupation()) {
                    inARow++;
                } else {
                    bloackCheckToBottom = true;
                }
            }

            if ((column - iteration >= 0) && !blockCheckToTop) {
                if (getByPosition(row, column).getOccupation() == getByPosition(row, column - iteration).getOccupation()) {
                    inARow++;
                } else {
                    blockCheckToTop = true;
                }
            }
            iteration++;
        }

        if (inARow >= this.settings.getRequiredInARow()){
            return true;
        }
        return false;
    }

    private boolean check_NW_SE(Player player, int row, int column){
        int inARow = 1;
        int iteration = 1;
        boolean blockCheckToTop = false;
        boolean bloackCheckToBottom = false;

        while (iteration <= this.settings.getRequiredInARow()) {
            if ((row + iteration < this.settings.getBoardSizeY()) && (column + iteration < this.settings.getBoardSizeX()) && !bloackCheckToBottom) {
                if (getByPosition(row, column).getOccupation() == getByPosition(row + iteration, column + iteration).getOccupation()) {
                    inARow++;
                } else {
                    bloackCheckToBottom = true;
                }
            }

            if ((row - iteration >= 0) && (column - iteration >= 0) && !blockCheckToTop){
                if (getByPosition(row, column).getOccupation() == getByPosition(row - iteration, column - iteration).getOccupation()){
                    inARow++;
                } else {
                    blockCheckToTop = true;
                }
            }
            iteration++;
        }
        if (inARow >= this.settings.getRequiredInARow()){
            return true;
        }
        return false;
    }

    private boolean check_NE_SW(Player player, int row, int column){
        int inARow = 1;
        int iteration = 1;
        boolean blockCheckToTop = false;
        boolean bloackCheckToBottom = false;

        while (iteration <= this.settings.getRequiredInARow()) {
            if ((row + iteration < this.settings.getBoardSizeY()) && (column - iteration >= 0) && !bloackCheckToBottom) {
                if (getByPosition(row, column).getOccupation() == getByPosition(row + iteration, column - iteration).getOccupation()) {
                    inARow++;
                } else {
                    bloackCheckToBottom = true;
                }
            }

            if ((row - iteration >= 0) && (column + iteration < this.settings.getBoardSizeX()) && !blockCheckToTop){
                if (getByPosition(row, column).getOccupation() == getByPosition(row - iteration, column + iteration).getOccupation()){
                    inARow++;
                } else {
                    blockCheckToTop = true;
                }
            }
            iteration++;
        }
        if (inARow >= this.settings.getRequiredInARow()){
            return true;
        }
        return false;
    }

    private void ckeck_win_condition(Player player, int row, int column){
        //returns true if win conditions are met
        if (check_NS(player, row, column) ||
            check_WE(player, row, column) ||
            check_NE_SW(player, row, column) ||
            check_NW_SE(player, row, column)){
            System.out.println("win!");
            gameFinished = true;
        }
    }

    public boolean place_peace(Player player, int row, int column){
        //returns TRUE if success
        System.out.println("player: " + player.getId() + " X:" + row + " Y:" + column);
        ArrayList<Cell> tmpRow = this.state.get(row);
        Cell tmpCell = tmpRow.get(column);
        Rectangle tmpCellImg = tmpCell.getImage();
        if (tmpCell.getOccupation() == Cell.NO_OCCUPATION){
            tmpCell.setOccupation(player.getId());
            tmpCellImg.setFill(player.getColor());
            tmpCell.setImage(tmpCellImg);
            tmpRow.set(column, tmpCell);
            this.state.set(row, tmpRow);
            ckeck_win_condition(player,row, column);
            return true;
        }
        return false;
    }

    public void show_board_state(){
        for (int i = 0; i < this.settings.getBoardSizeY(); i++){
            ArrayList<Cell> tmpRow = state.get(i);
            for (int j = 0; j < tmpRow.size(); j++) {
                System.out.print(tmpRow.get(j).getOccupation() + " ");
            };
            System.out.println();
        }
    }
}
