import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class LangsteWoord {
        public static void main(String [ ] args) throws FileNotFoundException {
            new LangsteWoord().getLongestWords();
    }

public String getLongestWords() throws FileNotFoundException {

            String longestWord = "";
            String current;
            Scanner scan = new Scanner(new File("src/WoordenLijst.txt"));


            while (scan.hasNext()) {
                current = scan.next();
                if (current.length() > longestWord.length()) {
                    longestWord = current;
                }

            }
            System.out.println(longestWord);
            return longestWord;
        }

    }

