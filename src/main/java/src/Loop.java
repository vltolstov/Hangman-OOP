package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loop {

    public static void play(String secretWord, GameField gameField, Mistake mistake, Scanner scanner, Notifier notifier) {

        char userLetter = scanner.next().charAt(0);
        String field = gameField.getField();

        if (field.contains(Character.toString(userLetter))) {
            notifier.getMessage("Такая буква уже есть в слове.");
        } else if (!field.contains(Character.toString(userLetter)) && secretWord.contains(Character.toString(userLetter))) {
            List<Integer> indexes = new ArrayList<>();
            for (int i = 0; i < secretWord.length(); i++) {
                if (userLetter == secretWord.charAt(i)) {
                    indexes.add(i);
                }
            }
            gameField.setField(indexes);
        } else {
            if (!mistake.getDuplicateWrongLetters().contains(Character.toString(userLetter))) {
                mistake.addMistake();
                notifier.gerError(mistake.getMistakesCount());
                mistake.addDuplicateWrongChars(userLetter);
            } else {
                notifier.getMessage("Такую букву вы уже вводили и ее нет в слове.");
            }
        }
    }
}
