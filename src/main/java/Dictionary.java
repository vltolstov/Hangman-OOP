import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {

    private List<String> dictionary;
    private Random random = new Random();

    public Dictionary() {
        dictionary = new ArrayList<String>();
        readAllWords();
    }

    public void readAllWords() {
        try {
            dictionary = Files.readAllLines(Paths.get("src/main/resources/words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWord() {
        int randomIndex = random.nextInt(dictionary.size());
        return dictionary.get(randomIndex);
    }
}
