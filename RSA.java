import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter prime p: ");
        int p = sc.nextInt();
        System.out.print("Enter prime q: ");
        int q = sc.nextInt();
        System.out.print("Enter public key e: ");
        int e = sc.nextInt();
        System.out.print("Enter private key d: ");
        int d = sc.nextInt();
        System.out.print("Enter plaintext (as integer): ");
        int plaintext = sc.nextInt();

        int n = p * q;
        BigInteger encrypted = BigInteger.valueOf(plaintext).pow(e).mod(BigInteger.valueOf(n));
        BigInteger decrypted = encrypted.pow(d).mod(BigInteger.valueOf(n));

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted); 
        
    }

//Output

//Enter prime p: 17 
//Enter prime q: 19
//Enter public key e: 5
//Enter private key d: 13
//Enter plaintext (as integer): 8
//Encrypted: 7
//Decrypted: 8
}