package FinARow;

public class GameSettings {
    private int boardSizeX;
    private int boardSizeY;
    private int requiredInARow;
    private float ScreenWidth;
    private float ScreenHeight;
    private int numberOfPlayer;

    public GameSettings(int boardSizeX,int boardSizeY,int requiredInARow, float ScreenWidth, float ScreenHeight, int numberOfPlayer){
        this.boardSizeX = boardSizeX;
        this.boardSizeY = boardSizeY;
        this.requiredInARow = requiredInARow;
        this.ScreenWidth = ScreenWidth;
        this.ScreenHeight = ScreenHeight;
        this.numberOfPlayer = numberOfPlayer;
    }

    static public GameSettings defaultSettings(){
        int boardSizeX = 10;
        int boardSizeY = 10;
        int requiredInARow = 5;
        float ScreenWidth = 800;
        float ScreenHeight = 800;
        int numberOfPlayer = 2;

        return new GameSettings(
            boardSizeX,
            boardSizeY,
            requiredInARow,
            ScreenWidth,
            ScreenHeight,
            numberOfPlayer
        );
    }

    public int getBoardSizeX() {
        return boardSizeX;
    }

    public void setBoardSizeX(int boardSizeX) {
        this.boardSizeX = boardSizeX;
    }

    public int getBoardSizeY() {
        return boardSizeY;
    }

    public void setBoardSizeY(int boardSizeY) {
        this.boardSizeY = boardSizeY;
    }

    public int getRequiredInARow() {
        return requiredInARow;
    }

    public void setRequiredInARow(int requiredInARow) {
        this.requiredInARow = requiredInARow;
    }

    public float getScreenWidth() {
        return ScreenWidth;
    }

    public void setScreenWidth(float screenWidth) {
        ScreenWidth = screenWidth;
    }

    public float getScreenHeight() {
        return ScreenHeight;
    }

    public void setScreenHeight(float screenHeight) {
        ScreenHeight = screenHeight;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }
}
