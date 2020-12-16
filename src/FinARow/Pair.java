package FinARow;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Pair {
    private Board board;
    private ArrayList<Player> players;
    private Player currentPlayer;

    public Pair(Board board, ArrayList<Player> players){
        this.board = board;
        this.players = players;
        this.currentPlayer = players.get(0);
        startPair();
    }

    public void startPair(){
        Stage stage = new Stage();
        stage.setScene(this.board.getWindow());
        stage.show();

        this.board.getWindow().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                double row = event.getSceneY() / (board.getSettings().getScreenHeight() / board.getSettings().getBoardSizeY());
                double column = event.getSceneX() / (board.getSettings().getScreenWidth() / board.getSettings().getBoardSizeX());
                long row_iPart;
                long column_iPart;
                row_iPart = (long) row;
                column_iPart = (long) column;

                boolean result = false;
                if (!board.isGameFinished()){
                    result = board.place_peace(currentPlayer, (int) row_iPart, (int) column_iPart);
                }
                if (result){
                    if (board.isGameFinished()){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Game is finished", ButtonType.OK);
                        alert.show();
                        System.out.println(currentPlayer);
                        System.out.println("!!!!!!!!!!!!!!!!!!!");
                    }
                    board.show_board_state();

                    for (int i = 0; i < players.size(); i++) {
                        if (currentPlayer == players.get(i)){
                            System.out.println(i);
                            if ((i + 1) < (players.size())){
                                currentPlayer = players.get(i+1);
                            } else {
                                currentPlayer = players.get(0);
                            }
                            break;
                        }
                    }

                    System.out.println(event.getSceneX());
                    System.out.println(event.getSceneY());
                }
            }
        });
    }
}
