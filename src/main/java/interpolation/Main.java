package interpolation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static int order = 3;

    public static void main(String[] args) {

        System.out.println("Welcome to the Lagrange Interpolation Method! ");

        XY_Tree xy_tree = null;

        System.out.println("Choose method of input: (1) Manual (2) Automation");
        System.out.print("Enter your choice: ");
        int choice = (new Scanner(System.in)).nextInt();
        System.out.println();
        if (choice == 1) {
            System.out.println("Enter the number of coordinates for your dataset: ");
            xy_tree = new XY_Tree((new Scanner(System.in)).nextInt());
        } else {
            try {
                xy_tree = new XY_Tree();
                BufferedReader bin = new BufferedReader(new FileReader("/Users/naimul7/JavaProjects/LagrangeInterpolation/src/main/java/dataset.txt"));

                String strX = "";
                String strY = "";
                for (int counter = 0; (strY = bin.readLine()) != null; counter++) { /* Assumption of even number of lines in data.txt file with coordinate pairs for test input data */
                    if (counter % 2 == 1)
                        xy_tree.set(Double.parseDouble(strX), Double.parseDouble(strY));
                    else
                        strX = strY;
                }

                bin.close();
            } catch (FileNotFoundException fnfex) { fnfex.printStackTrace();
            } catch (IOException ioex) { ioex.printStackTrace(); }
        }


        System.out.println(xy_tree);

        System.out.println(xy_tree.Lagrange(order+1));

        System.out.println();
        System.out.println("Please provide a value at which you wish the find the value for f(x). ");
        System.out.print("Enter x: ");
        xy_tree.setValue( (new Scanner(System.in)).nextDouble() );

        System.out.println();
        System.out.println(xy_tree.LagrangeReplacement(order+1));

        System.out.println("Lagrange value: " + xy_tree.LagrangeValue(order+1));

        System.out.println();
        
        System.out.println("Thank you for running this program!");
    }
}
