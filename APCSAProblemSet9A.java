public class APCSAProblemSet9A {
    public static void main (String[] args) {
        Shape[] shapes = new Shape[6];
        
        shapes[0] = new Circle("c1", true, 10);
        shapes[1] = new Rectangle("c2", true, 10, 20);
        shapes[2] = new Triangle("c3", true, 10, 10, 10);
        shapes[3] = new Square("c4", true, 10);
        shapes[4] = new Pentagon("c5", true, 10);
        shapes[5] = new House("c6", true, 10);
        
        
        System.out.println("Perimeter:");
        for (Shape s: shapes) {
            System.out.println(s.calculatePerimeter());
        }
        
        System.out.println("Area:");
        for (Shape s: shapes) {
            System.out.println(s.calculateArea());
        }

        System.out.println("Info:");
        for (Shape s: shapes) {
            s.displayInfo();
        }
    }

    public static class Shape {
        private String color;
        private boolean filled;
        
        Shape(String color, boolean filled) {
            this.color = color;
            this.filled = filled;
        }

        public double calculateArea() {
            return 0;
        }

        public double calculatePerimeter() {
            return 0;
        }

        public void displayInfo() {
            System.out.println(color + " " + filled);
        }

        public String getColor() {
            return this.color;
        }
    
        public void setColor(String color) {
            this.color = color;
        }
    
        public boolean isFilled() {
            return this.filled;
        }
    
        public void setFilled(boolean filled) {
            this.filled = filled;
        }
    }

    public static class Circle extends Shape {
        private double radius;

        Circle(String color, boolean filled, double radius) {
            super(color, filled);
            this.radius = radius;
        }

        @Override 
        public double calculateArea() {
            return Math.PI*Math.pow(radius, 2);
        }

        @Override
        public double calculatePerimeter() {
            return 2*Math.PI*radius;
        }

        public double getRadius() {
            return radius;
        }
    
        public void setRadius(double radius) {
            this.radius = radius;
        }
    }

    public static class Rectangle extends Shape {
        private double length;
        private double width;
        
        public Rectangle(String color, boolean filled, double length, double width) {
            super(color, filled);
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            return length*width;
        }
    
        @Override
        public double calculatePerimeter() {
            return 2*(length+width);
        }
    
        public double getLength() {
            return length;
        }

        public double getWidth() {
            return width;
        }
    
        public void setLength(double length) {
            this.length = length;
        }
    
        public void setWidth(double width) {
            this.width = width;
        }
    }

    public static class Triangle extends Shape {
        private double side1, side2, side3;
        
        public Triangle(String color, boolean filled, double side1, double side2, double side3) {
            super(color, filled);
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }

        @Override
        public double calculateArea() {
            double s = (side1+side2+side3)/2;
            return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        }
    
        @Override
        public double calculatePerimeter() {
            return side1+side2+side3;
        }
    
        public double getSide1() {
            return side1;
        }
    
        public void setSide1(double side1) {
            this.side1 = side1;
        }

        public double getSide2() {
            return side2;
        }
    
        public void setSide2(double side2) {
            this.side2 = side2;
        }

        public double getSide3() {
            return side3;
        }
    
        public void setSide3(double side3) {
            this.side3 = side3;
        }
    }

    public static class Square extends Shape {
        private double length;
        
        public Square(String color, boolean filled, double length) {
            super(color, filled);
            this.length = length;
        }

        @Override
        public double calculateArea() {
            return Math.pow(length, 2);
        }
    
        @Override
        public double calculatePerimeter() {
            return 4*length;
        }
    
        public double getLength() {
            return length;
        }
    
        public void setLength(double length) {
            this.length = length;
        }
    }

    public static class Pentagon extends Shape {
        private double length;

        public Pentagon(String color, boolean filled, double length) {
            super(color, filled);
            this.length = length;
        }

        @Override
        public double calculateArea() {
            return 1.25*Math.pow(length, 2)/Math.tan(Math.PI/5);
        }
    
        @Override
        public double calculatePerimeter() {
            return 5*length;
        }
    
        public double getLength() {
            return length;
        }
    
        public void setLength(double length) {
            this.length = length;
        }
    }

    public static class House extends Shape {
        private double length;

        public House(String color, boolean filled, double length) {
            super(color, filled);
            this.length = length;
        }

        @Override
        public double calculateArea() {
            return Math.pow(length, 2)*(1+Math.sqrt(3)/4);
        }
    
        @Override
        public double calculatePerimeter() {
            return 5*length;
        }
    
        public double getLength() {
            return length;
        }
    
        public void setLength(double length) {
            this.length = length;
        }
    }
}