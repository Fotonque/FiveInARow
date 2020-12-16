package FinARow;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {
    ArrayList<Pair> pairs = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
        GameSettings gameSettings = GameSettings.defaultSettings();
        Board board = new Board(gameSettings);

        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        players.add(player1);
        players.add(player2);
        pairs.add(new Pair(board, players));

        */
        /*
        GameSettings gameSettings = GameSettings.defaultSettings();
        Board board = new Board(gameSettings);
        Player player1 = new Player();
        board.place_peace(player1, 0,1);
        board.place_peace(player1, 0,2);
        board.place_peace(player1, 0,3);
        board.place_peace(player1, 0,5);
        board.place_peace(player1, 0,4);
        board.show_board_state();

         */
        /*
        GameSettings gameSettings = new GameSettings();

        Board board = new Board(gameSettings);
        Player player1 = new Player();
        Player player2 = new Player();

        playersOrder.add(player1);
        playersOrder.add(player2);

        currentPlayer = playersOrder.get(0);



        Board board2 = new Board(gameSettings);
        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        */

        /*
        board.place_peace(player1, 0,1);
        board.place_peace(player1, 0,2);
        board.place_peace(player1, 0,3);
        board.place_peace(player1, 0,5);
        board.place_peace(player1, 0,4);
        */
        /*
        board.place_peace(player1, 1,0);
        board.place_peace(player1, 2,0);
        board.place_peace(player1, 3,0);
        board.place_peace(player1, 5,0);
        board.place_peace(player1, 4,0);
        */
        /*
        board.place_peace(player1, 1,1);
        board.place_peace(player1, 2,2);
        board.place_peace(player1, 3,3);
        board.place_peace(player1, 5,5);
        board.place_peace(player1, 4,4);
        */
        /*
        board.place_peace(player1, 0,5);
        board.place_peace(player1, 1,4);
        board.place_peace(player1, 2,3);
        board.place_peace(player1, 3,2);
        board.place_peace(player1, 4,1);
        */
        //board.show_board_state();

        //////////////

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.setVgap(5);
        grid.setHgap(5);

        final String text_x_cells = "X cells";
        final TextField x_cells = new TextField();
        final Label label_x_cells = new Label(text_x_cells);
        x_cells.setPromptText(text_x_cells);
        GridPane.setConstraints(label_x_cells,0,0);
        grid.getChildren().add(label_x_cells);
        GridPane.setConstraints(x_cells, 1, 0);
        grid.getChildren().add(x_cells);

        final String text_y_cells = "Y cells";
        final TextField y_cells = new TextField();
        final Label label_y_cells = new Label(text_y_cells);
        y_cells.setPromptText(text_y_cells);
        GridPane.setConstraints(label_y_cells,0, 1);
        grid.getChildren().add(label_y_cells);
        GridPane.setConstraints(y_cells, 1, 1);
        grid.getChildren().add(y_cells);

        final String text_requiredInARow = "Required in a row";
        final TextField requiredInARow = new TextField();
        final Label label_requiredInARow = new Label(text_requiredInARow);
        requiredInARow.setPromptText(text_requiredInARow);
        GridPane.setConstraints(label_requiredInARow,0,2);
        grid.getChildren().add(label_requiredInARow);
        GridPane.setConstraints(requiredInARow, 1, 2);
        grid.getChildren().add(requiredInARow);

        final String text_screenWidth = "Screen width";
        final TextField screenWidth = new TextField();
        final Label label_screenWidth = new Label(text_screenWidth);
        screenWidth.setPromptText(text_screenWidth);
        GridPane.setConstraints(label_screenWidth,0,3);
        grid.getChildren().add(label_screenWidth);
        GridPane.setConstraints(screenWidth, 1, 3);
        grid.getChildren().add(screenWidth);

        final String text_screenHeight = "Screen height";
        final TextField screenHeight = new TextField();
        final Label label_screenHeight = new Label(text_screenHeight);
        screenHeight.setPromptText(text_screenHeight);
        GridPane.setConstraints(label_screenHeight,0,4);
        grid.getChildren().add(label_screenHeight);
        GridPane.setConstraints(screenHeight, 1, 4);
        grid.getChildren().add(screenHeight);

        final String text_numberOfPlayer = "Number of player";
        final TextField numberOfPlayer = new TextField();
        final Label label_numberOfPlayer = new Label(text_numberOfPlayer);
        numberOfPlayer.setPromptText(text_numberOfPlayer);
        GridPane.setConstraints(label_numberOfPlayer,0,5);
        grid.getChildren().add(label_numberOfPlayer);
        GridPane.setConstraints(numberOfPlayer, 1, 5);
        grid.getChildren().add(numberOfPlayer);

        Button submit = new Button("Create board");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    GameSettings gameSettings = new GameSettings(
                        Integer.parseInt(x_cells.getText()),
                        Integer.parseInt(y_cells.getText()),
                        Integer.parseInt(requiredInARow.getText()),
                        Float.parseFloat(screenWidth.getText()),
                        Float.parseFloat(screenHeight.getText()),
                        Integer.parseInt(numberOfPlayer.getText())
                    );
                    Board board = new Board(gameSettings);
                    ArrayList<Player> players = new ArrayList<>();
                    for (int i = 0; i < Integer.parseInt(numberOfPlayer.getText()); i++) {
                        players.add(new Player());
                    }
                    pairs.add(new Pair(board, players));
                } catch (Exception ex){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "fields must be filled with integer values", ButtonType.OK);
                    alert.show();
                }
            }
        });
        GridPane.setConstraints(submit, 2, 0);
        grid.getChildren().add(submit);

        Button clear = new Button("get default");
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameSettings gs = GameSettings.defaultSettings();
                x_cells.setText(Integer.toString(gs.getBoardSizeX()));
                y_cells.setText(Integer.toString(gs.getBoardSizeY()));
                requiredInARow.setText(Integer.toString(gs.getRequiredInARow()));
                screenHeight.setText(Float.toString(gs.getScreenHeight()));
                screenWidth.setText(Float.toString(gs.getScreenWidth()));
                numberOfPlayer.setText(Integer.toString(gs.getNumberOfPlayer()));
            }
        });
        GridPane.setConstraints(clear, 2, 1);
        grid.getChildren().add(clear);

        Group root = new Group();
        root.getChildren().add(grid);
        Scene win = new Scene(root, 600,500);
        Stage stage = new Stage();
        stage.setTitle("Main window");
        stage.setScene(win);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
