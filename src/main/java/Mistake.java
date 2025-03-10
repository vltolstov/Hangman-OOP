import java.util.ArrayList;
import java.util.List;

public class Mistake {

    private int mistakes;
    private List<String> duplicateWrongLetters;

    private Mistake() {
        this.mistakes = 0;
        this.duplicateWrongLetters = new ArrayList<>();
    }

    public void addMistake() {
        this.mistakes += 1;
    }

    public int getMistakes() {
        return this.mistakes;
    }

    public void setDuplicateWrongChars(Character letter) {
        duplicateWrongLetters.add(Character.toString(letter));
    }
}
