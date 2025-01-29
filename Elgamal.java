import java.util.Scanner;

public class Elgamal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter prime p: ");
        int p = sc.nextInt();
        System.out.print("Enter generator e1: ");
        int e1 = sc.nextInt();
        System.out.print("Enter public key e2: ");
        int e2 = sc.nextInt();
        System.out.print("Enter private key d: ");
        int d = sc.nextInt();
        System.out.print("Enter random key r: ");
        int r = sc.nextInt();
        System.out.print("Enter plaintext (as integer): ");
        int message = sc.nextInt();

        int c1 = (int) (Math.pow(e1, r) % p);
        int c2 = (message * (int) Math.pow(e2, r) % p) % p;

        int decrypted = (c2 * (int) Math.pow(c1, p - 1 - d) % p) % p;

        System.out.println("Encrypted: c1 = " + c1 + ", c2 = " + c2);
        System.out.println("Decrypted: " + decrypted);
}
}

//Output

//Enter prime p: 23
//Enter generator e1: 5
//Enter public key e2: 8
//Enter private key d: 15
//Enter random key r: 6   
//Enter plaintext (as integer): 9 
//Encrypted: c1 = 8, c2 = 1       
//Decrypted: 9