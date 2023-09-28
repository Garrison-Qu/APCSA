import java.io.*;

public class APCSAProblemSet2C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);

        double a, b, c, x1, x2, y1, y2, s, r, d;
        int k, sides;

        //Quadratic Formula
        System.out.println("QUADRATIC FORMULA: Find the roots of ax^2 + bx + c. Enter a, b, and c:");
        System.out.print("a: ");
        st.nextToken();
        a = st.nval;
        System.out.print("b: ");
        st.nextToken();
        b = st.nval;
        System.out.print("c: ");
        st.nextToken();
        c = st.nval;
        OrderedPair roots = findQuadraticRoots(a, b, c);
        System.out.println("The solutions for " + a + "x^2 + " + b + "x + " + c + " are (" + roots.toString() + ").");

        //Slope Formula
        System.out.println("SLOPE FORMULA: Find the slope between (x1,y1) and (x2,y2)");
        System.out.print("x1: ");
        st.nextToken();
        x1 = st.nval;
        System.out.print("y1: ");
        st.nextToken();
        y1 = st.nval;
        System.out.print("x2: ");
        st.nextToken();
        x2 = st.nval;
        System.out.print("y2: ");
        st.nextToken();
        y2 = st.nval;
        s = findSlope(new OrderedPair(x1, y1), new OrderedPair(x2, y2));
        System.out.println("A line between (" + new OrderedPair(x1, y1).toString() + ") and (" + new OrderedPair(x2, y2).toString() + ") has a slope of " + s + ".");

        // Midpoint Formula
        System.out.println("MIDPOINT FORMULA: Find the midpoint between (x1,y1) and (x2,y2)");
        System.out.print("x1: ");
        st.nextToken();
        x1 = st.nval;
        System.out.print("y1: ");
        st.nextToken();
        y1 = st.nval;
        System.out.print("x2: ");
        st.nextToken();
        x2 = st.nval;
        System.out.print("y2: ");
        st.nextToken();
        y2 = st.nval;
        OrderedPair m = findMidPoint(new OrderedPair(x1, y1), new OrderedPair(x2, y2));
        System.out.println("The midpoint between (" + new OrderedPair(x1, y1).toString() + ") and (" + new OrderedPair(x2, y2).toString() + ") is (" + m.toString() + ").");

        //Sum of an Arithmetic Series
        System.out.println("SUM OF AN ARITHMETIC SERIES");
        System.out.print("Number of terms: ");
        st.nextToken();
        k = (int) st.nval;
        System.out.print("Starts with: ");
        st.nextToken();
        a = st.nval;
        System.out.print("Increased by: ");
        st.nextToken();
        d = st.nval;
        s = findArithmeticSeriesSum(a, d, k);
        System.out.println("The sum of the first " + k + " terms of an arithemetic series that starts with " +  a + " and increases by " + d + " is " + s + ".");

        //Sum of a Geometric Series
        System.out.println("SUM OF A GEOMETRIC SERIES");
        System.out.print("Number of terms: ");
        st.nextToken();
        k = (int) st.nval;
        System.out.print("Starts with: ");
        st.nextToken();
        a = st.nval;
        System.out.print("Rate of growth: ");
        st.nextToken();
        r =  st.nval;
        s = findGeometricSeriesSum (a, r, k);
        System.out.println("The sum of the first " + k + " terms of a finite geometric series that starts with " +  a + " and increases by a rate of " + r + " is " + s + ".");

        //Die Roller
        System.out.println("DIE ROLLER");
        System.out.print("How many sides does your die have? ");
        st.nextToken();
        sides = (int) st.nval;
        k = rollDie(sides);
        System.out.println("Rolling a " + sides + "-sided die... you got a " + k + "!");
    }

    public static OrderedPair findQuadraticRoots(double a, double b, double c) {
        return (new OrderedPair(((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a)), (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a)));
    }

    public static double findSlope(OrderedPair A, OrderedPair B) {
        return (B.getY() - A.getY()) / (B.getX() - A.getX());
    }

    public static OrderedPair findMidPoint (OrderedPair A, OrderedPair B) {
        return (new OrderedPair(((A.getX()+B.getX())/2), ((A.getY()+B.getY())/2)));
    }

    public static double findArithmeticSeriesSum (double a, double d, int k) {
        return (double) k/2 * (2*a+d*(k-1));
    }

    public static double findGeometricSeriesSum (double a, double r, int k) {
        return a*((1-Math.pow(r, k))/(1-r));
    }

    public static int rollDie (int sides) {
        return (int) (Math.random() * sides) + 1;
    }


    static class OrderedPair {
        private double X, Y;

        public OrderedPair() {
            X = 0.0;
            Y = 0.0;
        }

        public OrderedPair(double X, double Y) {
            this.X = X;
            this.Y = Y;
        }

        public String toString() {
            return X + ", " + Y;
        }

        public double getX() {
            return X;
        }

        public double getY() {
            return Y;
        }
    }
}
