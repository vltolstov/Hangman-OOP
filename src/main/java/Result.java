public class Result {

    public boolean check(GameField gameField, Mistake mistake) {
        if (!gameField.getField().contains("-") && mistake.getMistakesCount() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
