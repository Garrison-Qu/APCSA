import java.util.*;

public class FractionClass {
    public static class Fraction {
        private int n, d;

        public Fraction(String s) {
            n = Integer.parseInt(s.split("/")[0]);
            d = Integer.parseInt(s.split("/")[1]);
        }

        public Fraction(int n, int d) {
            this.n = n;
            this.d = d;
        }

        public Fraction() {
            n = 0;
            d = 1;
        }

        public Fraction(Fraction f) {
            n = f.n;
            d = f.d;
        }

        public int getNum() {
            return n;
        }

        public int getDenom() {
            return d;
        }

        public String toString() {
            return n + "/" + d;
        }

        public double toDouble() {
            return (double) n / (double) d;
        }

        public void reduce() {
            int gcd = gcdExtended(n, d, 1, 1);
            n /= gcd;
            d /= gcd;
        }

        public void setNum(int n) {
            this.n = n;
        }

        public void setDenom(int d) {
            this.d = d;
        }

        public int gcdExtended(int a, int b, int x, int y) {
            if (a == 0) {
                x = 0;
                y = 1;
                return b;
            }

            int x1 = 1;
            int y1 = 1;
            int gcd = gcdExtended(b % a, a, x1, y1);

            x = y1 - (b / a) * x1;
            y = x1;

            return gcd;
        }

        public static Fraction multiply(Fraction f1, Fraction f2) {
            Fraction f = new Fraction(f1.n * f2.n, f1.d * f2.d);
            f.reduce();
            return f;
        }

        public static Fraction add(Fraction f1, Fraction f2) {
            Fraction f = new Fraction(f1.n * f2.d + f2.n * f1.d, f1.d * f2.d);
            f.reduce();
            return f;
        }

        public static Fraction subtract(Fraction f1, Fraction f2) {
            Fraction f = new Fraction(f1.n * f2.d - f2.n * f1.d, f1.d * f2.d);
            f.reduce();
            return f;
        }

        public static Fraction divide(Fraction f1, Fraction f2) {
            Fraction f = new Fraction(f1.n * f2.d, f1.d * f2.n);
            f.reduce();
            return f;
        }

        public boolean equals(Fraction f) {
            return n == f.n && d == f.d;
        }
    }

    public static void EstimatingPI() {
        Fraction MILU = new Fraction(355, 113);
        Fraction ArbitraryFraction = new Fraction(400, 200);
        final double EPSILON = Math.abs(Math.PI - MILU.toDouble()) * 0.999;
        while (Math.abs(ArbitraryFraction.toDouble() - Math.PI) > EPSILON) {
            if (ArbitraryFraction.toDouble() > Math.PI) {
                ArbitraryFraction.setDenom(ArbitraryFraction.getDenom() + 1);
            } else {
                ArbitraryFraction.setNum(ArbitraryFraction.getNum() + 1);
            }
        }
        System.out.println(ArbitraryFraction.toString());
    }

    public static void FractionQuizGame() {
        Scanner sc = new Scanner(System.in);

        int gameCount = 0;
        int winCount = 0;
        
        while (true) {
            Fraction f1 = new Fraction((int) (Math.random() * 10), (int) (Math.random() * 9) + 1);
            Fraction f2 = new Fraction((int) (Math.random() * 10), (int) (Math.random() * 9) + 1);
            int r = (int) (Math.random() * 4);
            Fraction ans, p;

            if (r == 0) {
                System.out.print(f1.toString() + " + " + f2.toString() + " = ");
                String s = sc.nextLine();
                if (s.equals("quit")) {
                    break;
                }
                ans = Fraction.add(f1, f2);
                p = new Fraction(s);
            } else if (r == 1) {
                System.out.print(f1.toString() + " - " + f2.toString() + " = ");
                String s = sc.nextLine();
                if (s.equals("quit")) {
                    break;
                }
                ans = Fraction.subtract(f1, f2);
                p = new Fraction(s);
            } else if (r == 2) {
                System.out.print(f1.toString() + " * " + f2.toString() + " = ");
                String s = sc.nextLine();
                if (s.equals("quit")) {
                    break;
                }
                ans = Fraction.multiply(f1, f2);
                p = new Fraction(s);
            } else {
                System.out.print(f1.toString() + " / " + f2.toString() + " = ");
                String s = sc.nextLine();
                if (s.equals("quit")) {
                    break;
                }
                ans = Fraction.divide(f1, f2);
                p = new Fraction(s);
            }

            if (ans.equals(p)) {
                gameCount++;
                winCount++;
                System.out.println("Correct!");
            } else {
                gameCount++;
                System.out.println("Wrong, the answer was " + ans.toString());
            }
        }
        System.out.println("Your win/loss ratio was " + winCount + "/" + gameCount + ", for a score of " + winCount/gameCount*100 + " percent");
    }
}
