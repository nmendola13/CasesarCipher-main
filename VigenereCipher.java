import java.io.PrintWriter;

/*
* A simple implementation of Vigenère Cipher.
*
* @author Samuel A. Rebelsky
* @author Noah Mendola
* @version 2.0 of october 2023
*/

public class VigenereCipher {
     /**
     * Prints the given string.
     *
     * @param str the string to print
     */ 
    public static void print (String str) {
      PrintWriter pen = new PrintWriter(System.out, true);
      pen.println(str);
    }

    /**
     * Encodes the given string using the Vigenere Cipher.
     * It moves each character over by the corresponding key character.
     *
     * @param str the string to encode
     * @param key the key to use for encoding
     */
    public static void encode (String str, String key) {
      char[] str1 = str.toCharArray();
      char[] str2 = key.toCharArray();
          for (int j = 0; j < str.length(); j++) {
            int keyIndex = j % key.length(); 
            int temp = str1[j];
            int keytemp = str2[keyIndex];
            int charnum = ((temp - 'a' + keytemp - 'a') % 26) + 'a';
            char postChange = (char) charnum;
            str1[j] = postChange;
          }
        String newStr = new String(str1);
        print(newStr);
      }

    /**
     * Decodes the given string using the Vigenere Cipher.
     * It moves each character over by the corresponding key character.
     *
     * @param str the string to decode
     * @param key the key to use for decoding
     */
    public static void decode (String str, String key) {
      char[] str1 = str.toCharArray();
      char[] str2 = key.toCharArray();
        for (int j = 0; j < str.length(); j++) {
            int keyIndex = j % key.length(); 
            int temp = str1[j];
            int keytemp = str2[keyIndex];
            int charnum = ((temp - keytemp + 26) % 26) + 'a';
            char postChange = (char) charnum;
            str1[j] = postChange;
        }
        String newStr = new String(str1);
        print(newStr);
      }
    

    /**
     * The main method.
     * It checks for argument requirements and runs either encode or decode depending on arguments.
     *
     * @param args the command line arguments
     * @throws Exception if any error occurs
     */
    public static void main (String args[]) throws Exception {
      PrintWriter pen = new PrintWriter(System.out, true);
        if (args.length == 2) {
            pen.println(args[1]);
            System.exit(1);
        }
        else if (args.length != 3) {
            pen.println("Invalid number of arguments");
            System.exit(1);
        }
        String operation = args[0];
        String input = args[1];
        String key = args[2];
      
        if (operation.equals("encode")) {
            encode(input, key);
        } else if (operation.equals("decode")) {
            decode(input, key);
        } else {
            pen.println("Valid options are 'encode' or 'decode'");
        }
    }
}
