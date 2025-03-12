package src;

import java.util.ArrayList;
import java.util.List;

public class Mistake {

    private int count;
    private List<String> duplicateWrongLetters;

    public Mistake(int count) {
        this.count = count;
        this.duplicateWrongLetters = new ArrayList<>();
    }

    public void addMistake() {
        this.count -= 1;
    }

    public int getMistakesCount() {
        return this.count;
    }

    public void addDuplicateWrongChars(Character letter) {
        duplicateWrongLetters.add(Character.toString(letter));
    }

    public List<String> getDuplicateWrongLetters() {
        return duplicateWrongLetters;
    }
}
