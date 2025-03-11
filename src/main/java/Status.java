public class Status {

    private boolean gameStatus;
    private boolean endGameStatus;

    Status(boolean gameStatus, boolean endGameStatus) {
        this.gameStatus = gameStatus;
        this.endGameStatus = endGameStatus;
    }

    public boolean getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean getEndGameStatus() {
        return endGameStatus;
    }

    public void setEndGameStatus(boolean endGameStatus) {
        this.endGameStatus = endGameStatus;
    }
}
