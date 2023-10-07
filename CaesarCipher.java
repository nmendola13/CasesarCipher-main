import java.io.PrintWriter;

/*
 * A simple implementation of Caesar Cipher.
 *
 * @author Samuel A. Rebelsky
 * @author Noah Mendola
 * @version 2.0 of october 2023
 */

public class CaesarCipher {
    /**
     * Prints the given string along with the shift value.
     *
     * @param str the string to print
     * @param i the shift value
     */
    public static void print(String str, int i) {
        PrintWriter pen = new PrintWriter(System.out, true);
        pen.print("n = " + i + ": ");
        pen.println(str);
    }

    /**
     * Encodes the given string by shifting each character over by n positions.
     * It performs the shift for all values of n from 0 to 25.
     *
     * @param str the string to encode
     */
    public static void encode(String str) {
        char[] str1 = str.toCharArray();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < str.length(); j++) {
                int temp = str1[j];
                int charnum = ((temp - 97 + i) % 26 + 97);
                char postChange = (char) charnum;
                str1[j] = postChange;
            }
            String newStr = new String(str1);
            print(newStr, i);
        }
    }

    /**
     * Decodes the given string by shifting each character back by n positions.
     * It performs the shift for all values of n from 0 to 25.
     *
     * @param str the string to decode
     */
    public static void decode(String str) {
        char[] str2 = str.toCharArray();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < str.length(); j++) {
                int temp = str2[j];
                int charnum = ((temp - 97 - i + 26) % 26 + 97);
                char postChange = (char) charnum;
                str2[j] = postChange;
            }
            String newStr = new String(str2);
            print(newStr, i);
        }
    }

    /**
     * The main method.
     * It checks for argument requirements and runs either encode or decode depending on arguments.
     *
     * @param args the command line arguments
     * @throws Exception if any error occurs
     */
    public static void main(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        if (args.length != 2) {
            pen.println("Invalid number of arguments");
            System.exit(1);
        }
        String operation = args[0];
        String input = args[1];

        if (operation.equals("encode")) {
            encode(input);
        } else if (operation.equals("decode")) {
            decode(input);
        } else {
            pen.println("Valid options are 'encode' or 'decode'");
        }
    }
}



