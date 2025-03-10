import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {

    private final Random random = new Random();
    private List<String> dictionary;
    private int randomIndex;

    public Dictionary() {
        this.dictionary = new ArrayList<String>();
        readAllWords();
        setWordIndex();
    }

    public String getWord() {
        return dictionary.get(randomIndex);
    }

    private void readAllWords() {
        try {
            this.dictionary = Files.readAllLines(Paths.get("src/main/resources/words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setWordIndex() {
        randomIndex = random.nextInt(dictionary.size());
    }
}
