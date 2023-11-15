import java.util.*;

public class APCSAProblemSet4B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //System.out.println(Palindrome(sc.nextLine().trim()));
        //System.out.println(pigLatinTranslator(sc.nextLine().trim()));
        //System.out.println(strictlyAscendingNumber(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        //timesTable(Integer.parseInt(sc.nextLine()));
    }
    

    public static boolean Palindrome(String str) {
        str = str.toLowerCase();
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                s += str.charAt(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)){ 
                return false;
            }
        }
        return true;
    }

    public static String pigLatinTranslator(String str) {
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > 2) s[i] = s[i].substring(1) + s[i].charAt(0) + "ay";
        }
        String n = "";
        for (String string: s) {
            n += string + " ";
        }
        return n;
    }

    public static int strictlyAscendingNumber (int l, int h) {
        int count = 0;
        for (int i = l; i < h; i++) {
            if (checker(i)) count++;
        }
        return count;
    }

    public static boolean checker (int n) {
        if (n == 0) return true;
        int a = n%10;
        int b = (n/10)%10;
        if (a <= b) return false;
        return checker(n/10);
    }

    public static void timesTable (int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i*j + " ");
            }
            System.out.println();
        }
    }
}
