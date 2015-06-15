import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
   public Map<String, Integer> Phrase(String phrase) {
      Map<String, Integer> wordCountMap = new HashMap();

      for (String word : getWords(phrase)) {
         Integer wordCount = wordCountMap.get(word);
         wordCount = wordCount == null ? 0 : wordCount;
         wordCountMap.put(word, ++wordCount);
      }

      return wordCountMap;
   }

   private List<String> getWords(String phrase) {
      ArrayList<String> words = new ArrayList<>();

      for (String word : phrase.split(" ")) {
         String filteredWord = new CleanWord(word).value;

         if (filteredWord.length() > 0) {
            words.add(filteredWord);
         }
      }

      return words;
   }
}

class CleanWord {
   public CleanWord(String rawWord) {
      this.value = filterWord(rawWord).toLowerCase();
   }

   public String value;

   private String filterWord(String word) {
      String filteredWord = word;

      for (Character c : badCharacters.toCharArray()) {
         filteredWord = filteredWord.replaceAll("\\" + c, "");
      }

      return filteredWord;
   }

   private String badCharacters = ",!&@%&:^$";
}
