import java.util.*;

public class APCSAProblemSet7B {
    // Debug Code
    // public static void main(String[] args) {
    //     System.out.println(SieveOfEratosthenes(100));
    //     GoldbachConjecture(10);
    //     List<Integer> a = List.of(1, 0, 1, 2, 3, 9);
    //     List<Integer> b = List.of(9, 2, 1, 2, 3, 9);
    //     for (int i: AddingBigInts(a, b)) {
    //         System.out.print(i);
    //     }
    // }

    public static ArrayList<Integer> SieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true); 
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        prime[0] = false;
        prime[1] = false;
        ArrayList<Integer> p = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) p.add(i);
        }
        return p;
    }

    public static void GoldbachConjecture(int n) {
        ArrayList<Integer> prime = SieveOfEratosthenes(n);
        for (int i: prime) {
            int m = n-i;
            if (prime.contains(m)) {
                System.out.println(i + " " + m);
                return;
            }
        }
    }

    public static ArrayList<Integer> AddingBigInts (ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> sum = new ArrayList<Integer>();

        if (b.size() > a.size()) {
            ArrayList<Integer> temp = a;
            a = b;
            b = temp;
        }
        int max = a.size();
        boolean over = false;
        for (int i = 1; i <= max; i++) {
            int add = a.get(a.size()-i);
            if (i <= b.size()) {
                add += b.get(b.size()-i);
            }
            if (over) {
                add++;
            }
            sum.add(0, add%10);
            if (add > 9) {
                over = true;
            } else {
                over = false;
            }
        }
        if (over) {
            sum.add(0, 1);
        }
        return sum;
    }
}
