import java.util.Scanner;

public class Hangman {

    private static final String START_COMMAND = "старт";
    static Scanner scanner = new Scanner(System.in);
    private static boolean GAME_STATUS;
    private static boolean END_GAME_STATUS;

    public static void main(String[] args) {
        do {
            initialization();
            if (GAME_STATUS) {

                Mistake mistake = new Mistake(6);
                Dictionary dictionary = new Dictionary();
                String secretWord = dictionary.getWord();
                GameField gameField = new GameField(secretWord);
                System.out.println(gameField.getGameField());

//                while (!END_GAME_STATUS) {
//                playerTurn();
//                System.out.println(GAME_FIELD);
//                checkGameStatus();
//                }
//                viewResult();
            }
        } while (GAME_STATUS);
    }

    public static void initialization() {
        System.out.println("Для старта новой игры введите 'Старт'. Для отмены игры нажмите Enter: ");
        String commandFromUserInput = scanner.nextLine().toLowerCase();
        if (commandFromUserInput.equals(START_COMMAND)) {
            GAME_STATUS = true;
            END_GAME_STATUS = false;
        } else {
            GAME_STATUS = false;
        }
    }
}
