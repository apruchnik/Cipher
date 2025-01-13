//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Input text: ");
        String code = userInput.nextLine();
        code = code.toLowerCase();
        System.out.print("Key: ");
        int key = userInput.nextInt();
        PrintStream var10000 = System.out;
        String var10001 = decypherCode(code, key);
        var10000.println("Message: " + var10001);
    }

    public static String decypherCode(String code, int key) {
        char newChar = true;
        String decString = "";

        for (Scanner wordReader = (new Scanner(code)).useDelimiter(" "); wordReader.hasNext(); decString = decString + " ") {
            String word = wordReader.next();

            for (int i = 0; i < word.length(); ++i) {
                char origChar = word.charAt(i);
                String alphabet = "abcdefghijklmnopqrstuvwxyz";

                for (int j = 0; j < alphabet.length(); ++j) {
                    char alphabetChar = alphabet.charAt(j);
                    if (origChar != alphabetChar) {
                        decString = decString + origChar;
                        break;
                    }

                    int alphabetIndex = j;
                    alphabetIndex += key;
                    if (alphabetIndex >= 26) {
                        alphabetIndex -= 26;
                    }

                    char newChar = alphabet.charAt(alphabetIndex);
                    decString = decString + newChar;
                }
            }
        }

        return decString;
    }
}