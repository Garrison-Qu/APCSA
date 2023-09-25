public class APCSAProblemSet2B {
    public static void main(String[] args) {
        OrderedPair op = new OrderedPair(4.0, -5.0);
        System.out.println(op.toString());
        System.out.println(op.getX());
        System.out.println(op.getY());
    }

}

class OrderedPair {
    double X, Y;
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
        return X;
    }
}