import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameField {

    private String secretWord;
    private String field = "";
    private Random random = new Random();

    public GameField(String secretWord) {
        this.secretWord = secretWord;
        resetField();
        setRandomOpenLetters();
    }

    public String getField() {
        return this.field;
    }

    public void setField(List<Integer> indexes) {
        StringBuilder fieldSB = new StringBuilder(this.field);
        for (Integer index : indexes) {
            fieldSB.setCharAt(index, this.secretWord.charAt(index));
        }
        this.field = fieldSB.toString();
    }

    public void renderField() {
        System.out.println(field);
    }

    private void resetField() {
        for (int i = 0; i < this.secretWord.length(); i++) {
            this.field += "-";
        }
    }

    private void setRandomOpenLetters() {
        Character firstLetter;
        Character secondLetter;
        do {
            int randomFirstIndex = random.nextInt(this.secretWord.length());
            int randomSecondIndex = random.nextInt(this.secretWord.length());
            firstLetter = this.secretWord.charAt(randomFirstIndex);
            secondLetter = this.secretWord.charAt(randomSecondIndex);
        } while (firstLetter.equals(secondLetter));

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < this.secretWord.length(); i++) {
            if (firstLetter == this.secretWord.charAt(i) || secondLetter == this.secretWord.charAt(i)) {
                indexes.add(i);
            }
        }
        setField(indexes);
    }
}
