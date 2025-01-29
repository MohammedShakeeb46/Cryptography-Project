import java.util.Scanner;

public class AffineCipher {
    static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1)
                return x;
        }
        return -1;
    }

    static String encrypt(String text, int a, int b) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toUpperCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                ch = (char) (((a * (ch - 'A') + b) % 26) + 'A');
            }
            result.append(ch);
        }
        return result.toString();
    }

    static String decrypt(String cipher, int a, int b) {
        StringBuilder result = new StringBuilder();
        int aInverse = modInverse(a, 26);
        for (char ch : cipher.toUpperCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                ch = (char) ((aInverse * (ch - 'A' - b + 26) % 26) + 'A');
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext (A-Z): ");
        String text = sc.nextLine();
        System.out.print("Enter key 'a' (coprime to 26): ");
        int a = sc.nextInt();
        System.out.print("Enter key 'b': ");
        int b = sc.nextInt();

        String cipher = encrypt(text, a, b);
        System.out.println("Encrypted: " + cipher);
        System.out.println("Decrypted: " + decrypt(cipher, a, b));
    }
}

//Output

//Enter plaintext (A-Z): HELLO
//Enter key 'a' (coprime to 26): 5
//Enter key 'b': 8
//Encrypted: RCLLA

