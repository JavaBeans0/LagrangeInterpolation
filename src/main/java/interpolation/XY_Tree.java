package interpolation;

import java.util.ArrayList;

public class XY_Tree {

    private ArrayList<Coordinate> dataset;
    private double value;
    private double index;

    public XY_Tree() { this(0); }

    public XY_Tree(int coordinates) {
        dataset = new ArrayList<>();
        for(int i = 0; i < coordinates; i++) {
            System.out.println("Enter values for coordinate pair#" + (i + 1));
            dataset.add(new Coordinate());
        }
    }

    public void set(double x, double y) { dataset.add(new Coordinate(x,y)); }
    public XY_Tree(ArrayList<Coordinate> dataset) { this.dataset = dataset; }

    public void setValue(double value) {
        this.value = value;

        this.index = -1;
        for(Coordinate coordinate: dataset) {
            if (coordinate.x < value)
                break;

            this.index++;
        }
    }

    /* Under Construction */
    public double calculate(double value) {
        return 0.0;
    }

    public String Lagrange(int order) {
        String equation = "";
        for(int i = 0; i < order; i++) {
            equation += (i == 0 ? "": " + ") + "[";

            for (int j = 0; j < order; j++)
                if (j != i)
                    equation += x(-1, j) + "/" + x(i, j);

            equation += "] * y(x" + i + ")";
        }

        return equation;
    }

    public String LagrangeReplacement(int order) {
        String equation = "";

        for(int i = 0; i < order; i++) {
            equation += (i == 0 ? "": " + ") + "[";

            for(int j = 0; j < order; j++)
                if(j != i)
                    equation += xOf(-1, j) + "/" + xOf(i, j);

            equation += "] * " + this.dataset.get(i).y + ")";
        } // 0.80344666 +

        return equation;
    }

    public String xOf(int i, int j) { return "(" + Double.toString(i < 0 ? this.value : this.dataset.get(i).x)+ "-" + this.dataset.get(j).x + ")"; }
    public String x(int i, int j) { return "(x" + (i < 0 ? "": i) + " - x" + j + ")"; }

    @Override
    public String toString() {
        String coordinates = "";

        for(Coordinate coordinate: dataset)
            coordinates += coordinate;

        return "Dataset{ " + coordinates + "}";
    }
}
    /*
        Linear Lagrange
        -0.66666 * 1.20517 = -0.803446666666
        1.666666 * 1.89182 = 3.1530333333
        3.1530333333 - 0.80344666666 = 2.3495866666733
    */

    /*
        Quadratic Lagrange
        -0.66666 * 0.1666666 * 1.20517 = -0.133907777
        1.666666 * 0.333333 * 1.89182 = 1.05101111
        0.8333333 * 0.66666 * 271375 = 1.50763888
        1.50763888 + 1.0510111 - 0.133907777 = 2.424742213
    */

    /*
        Cubic Lagrange
        -0.66666 * 0.1666666 * -0.555555 = 5 / 81  * 1.20517 = 0.07439320987
        1.666666 * 0.3333333 * 0.6666666 = 10 / 27 * 1.89182 = 0.700674074
        0.083333 * 0.6666666 * 1.3333333 = 20 / 27 * 2.71375 = 2.010185185
        0.555555 * 0.3333333 * -0.333333 = -5 / 81 * 3.71828 = 0.22963456
     */
