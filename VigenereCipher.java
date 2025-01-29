import java.util.Scanner;

public class VigenereCipher {
    static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase().repeat((text.length() / key.length()) + 1);
        for (int i = 0; i < text.length(); i++) {
            char ch = (char) (((text.charAt(i) - 'A' + (key.charAt(i) - 'A')) % 26) + 'A');
            result.append(ch);
        }
        return result.toString();
    }

    static String decrypt(String cipher, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase().repeat((cipher.length() / key.length()) + 1);
        for (int i = 0; i < cipher.length(); i++) {
            char ch = (char) (((cipher.charAt(i) - key.charAt(i) + 26) % 26) + 'A');
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext (A-Z): ");
        String text = sc.nextLine().toUpperCase();
        System.out.print("Enter key (A-Z): ");
        String key = sc.nextLine().toUpperCase();

        String cipher = encrypt(text, key);
        System.out.println("Encrypted: " + cipher);
        System.out.println("Decrypted: " + decrypt(cipher,key)); }
}

//Output

//Enter plaintext (A-Z): HELLO
//Enter key (A-Z): KEY
//Encrypted: RIJVS


