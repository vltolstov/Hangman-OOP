import src.Dictionary;
import src.GameField;
import src.Loop;
import src.Mistake;
import src.Notifier;
import src.Result;
import src.Status;

import java.util.Scanner;

public class Hangman {

    private static final String START_COMMAND = "старт";
    private static final int ERROR_COUNT = 6;
    static Scanner scanner = new Scanner(System.in);
    static Notifier notifier = new Notifier();
    static Status status = new Status();
    static Result result = new Result();

    public static void main(String[] args) {
        do {
            initialization();
            if (status.getGameStatus()) {
                Mistake mistake = new Mistake(ERROR_COUNT);
                Dictionary dictionary = new Dictionary();
                String secretWord = dictionary.getWord();
                GameField gameField = new GameField(secretWord);
                gameField.renderField();

                while (status.getGameLoopStatus()) {
                    Loop.play(secretWord, gameField, mistake, scanner, notifier);
                    gameField.renderField();
                    status.checkGameStatus(gameField, mistake);
                }

                if (result.check(gameField, mistake)) {
                    notifier.getCongratulations();
                } else {
                    notifier.getCondolences(secretWord);
                }
            }
            int a = 1;
            boolean s = status.getGameStatus();
        } while (status.getGameStatus());
    }

    public static void initialization() {
        System.out.println("Для старта новой игры введите 'Старт'. Для отмены игры введите любой символ");
        String commandFromUserInput = scanner.nextLine().toLowerCase();
        if (commandFromUserInput.equals(START_COMMAND)) {
            status.setGameStatus(true);
            status.setGameLoopStatus(true);
        } else if (!commandFromUserInput.isEmpty()) {
            status.setGameStatus(false);
        }
    }
}
