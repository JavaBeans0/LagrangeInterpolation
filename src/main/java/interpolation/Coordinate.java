package interpolation;

import java.util.Scanner;

public class Coordinate {

    protected double x;
    protected double y;

    public Coordinate() {
        System.out.println("Enter x-value: ");
        this.x = (new Scanner(System.in)).nextDouble();
        System.out.println("Enter y-value: ");
        this.y = (new Scanner(System.in)).nextDouble();
    }

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + " , " + this.y + ") ";
    }
}
