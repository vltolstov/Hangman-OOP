import src.Dictionary;
import src.GameField;
import src.Loop;
import src.Mistake;
import src.Notifier;
import src.Result;
import src.Scene;
import src.Status;

import java.util.Scanner;

public class Hangman {

    private static final int ERROR_COUNT = 6;
    static Scanner scanner = new Scanner(System.in);
    static Notifier notifier = new Notifier();
    static Status status = new Status();
    static Result result = new Result();

    public static void main(String[] args) {
        do {
            initialization();
            if (status.getGameStatus() && status.getGameLoopStatus()) {
                Mistake mistake = new Mistake(ERROR_COUNT);
                Dictionary dictionary = new Dictionary();
                String secretWord = dictionary.getWord();
                Scene scene = new Scene();
                scene.renderScene(mistake);
                GameField gameField = new GameField(secretWord);
                gameField.renderField();

                while (status.getGameLoopStatus()) {
                    Loop.play(secretWord, gameField, mistake, scanner, notifier);
                    scene.renderScene(mistake);
                    gameField.renderField();
                    status.checkGameLoopStatus(gameField, mistake);
                }

                if (result.check(gameField, mistake)) {
                    notifier.getCongratulations();
                } else {
                    notifier.getCondolences(secretWord);
                }
            }
        } while (status.getGameStatus());
    }

    public static void initialization() {
        System.out.println("Для старта новой игры введите 'Старт'. Для выхода из игры введите 'Стоп'");
        String commandFromUserInput = scanner.next().toLowerCase();
        if (commandFromUserInput.equals("старт")) {
            status.setGameStatus(true);
            status.setGameLoopStatus(true);
        } else if (commandFromUserInput.equals("стоп")) {
            status.setGameStatus(false);
        } else {
            System.out.println("Некорректный ввод");
            status.setGameStatus(true);
        }
    }
}
