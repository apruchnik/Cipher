import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var userInput = new Scanner(System.in);
        System.out.print("Input text: ");
        var code = userInput.nextLine();
        code = code.toLowerCase();

        System.out.print("Key: ");
        var key = userInput.nextInt();

        System.out.println("Message: " + decypherCode(code, key));
    }

    public static String decypherCode(String code, int key) {

        var newChar = 'a';
        var decString = "";
        var wordReader = new Scanner(code).useDelimiter(" ");

        while (wordReader.hasNext()) {

            var word = wordReader.next();

            for (int i = 0; i < word.length(); i++) {

                var origChar = word.charAt(i);
                var alphabet = "abcdefghijklmnopqrstuvwxyz";

                for (int j = 0; j < alphabet.length(); j++) {
                    var alphabetChar = alphabet.charAt(j);

                    if (origChar == alphabetChar) {
                        var alphabetIndex = j;
                        alphabetIndex += key;
                        if (alphabetIndex >= 26) {
                            alphabetIndex -= 26;
                        }
                        newChar = alphabet.charAt(alphabetIndex);
                        decString += newChar;
                    }
                }
            }
            decString += " ";
        }
        return decString;
    }
}