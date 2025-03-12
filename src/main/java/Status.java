public class Status {

    private boolean gameStatus;
    private boolean gameLoopStatus;

    public boolean getGameStatus() {
        return this.gameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean getGameLoopStatus() {
        return gameLoopStatus;
    }

    public void setGameLoopStatus(boolean endGameStatus) {
        this.gameLoopStatus = endGameStatus;
    }

    public void checkGameStatus(GameField gameField, Mistake mistake) {
        if (!gameField.getField().contains("-") || mistake.getMistakesCount() == 0) {
            this.gameLoopStatus = false;
        }
    }
}
