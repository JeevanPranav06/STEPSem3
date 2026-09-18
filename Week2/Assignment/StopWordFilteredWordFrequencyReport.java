import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StopWordFilteredWordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");
        HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }
            boolean isStopWord = false;
            for (int j = 0; j < stopWords.length; j++) {
                if (word.equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }
            if (isStopWord) {
                continue;
            }
            Integer current = frequencies.get(word);
            if (current == null) {
                frequencies.put(word, 1);
            } else {
                frequencies.put(word, current + 1);
            }
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(frequencies.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> first, Map.Entry<String, Integer> second) {
                return second.getValue() - first.getValue();
            }
        });
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<String, Integer> entry = entries.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
