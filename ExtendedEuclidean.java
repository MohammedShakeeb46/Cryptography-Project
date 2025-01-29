import java.util.Scanner;

public class ExtendedEuclidean {

    // Function to compute modular inverse using Extended Euclidean Algorithm
    public static int modInverse(int a, int n) {
        int r1 = n, r2 = a;
        int t1 = 0, t2 = 1;

        while (r2 > 0) {
            int q = r1 / r2;
            int r = r1 - q * r2;
            r1 = r2;
            r2 = r;
            
            int t = t1 - q * t2;
            t1 = t2;
            t2 = t;
        }

        // If gcd is not 1, inverse does not exist
        if (r1 != 1) {
            return -1; // No modular inverse
        }

        // Ensure positive modular inverse
        if (t1 < 0) {
            t1 += n;
        }
        return t1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking user input
        System.out.print("Enter value of a: ");
        int a = scanner.nextInt();
        
        System.out.print("Enter value of n: ");
        int n = scanner.nextInt();

        int inverse = modInverse(a, n);

        if (inverse == -1) {
            System.out.println("Multiplicative inverse does not exist.");
        } else {
            System.out.println("Modular inverse of " + a + " modulo " + n + " is: " + inverse);
        }
        
        scanner.close();
    }
}

//Output
//Enter value of a: 3
//Enter value of n: 11
//Modular inverse of 3 modulo 11 is: 4
