import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class LangsteWoord {
        public static void main(String [ ] args) throws FileNotFoundException {
            new LangsteWoord().getLongestWords();
    }

    //////LANGSTE WOORD, 25 tekens

public String getLongestWords() throws FileNotFoundException {

            String longestWord = "";
            String current;
            Scanner scan = new Scanner(new File("D:\\IdeaProjects\\InleverOpdracht2_JoeriJorisITV2E\\src\\WoordenLijst.txt"));


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

