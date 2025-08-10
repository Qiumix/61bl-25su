import java.util.ArrayList;

public class MyTriangle extends Triangle {
    public MyTriangle() {

    }
    /** Given triangle side lengths side1, side2, and side3, return whether or not they could form a valid triangle
     * defined by the triangle inequality: any the sum of any two sides must be > the third side. */
    private static boolean sidesCheckHelper(int side1, int side2, int side3) {
        if (side1 == 0) {
            return false;
        }
        return side1 + side2 > side3;
    }
    private static boolean sidesCheckHelper(double side1, double side2, double side3) {
        if (Math.abs(side1) < 0.001) {
            return false;
        }
        return side1 + side2 > side3;
    }
    public boolean sidesFormTriangle(int side1, int side2, int side3) {
        return sidesCheckHelper(side1, side2, side3) && sidesCheckHelper(side2, side3, side1) && sidesCheckHelper(side3, side2, side1);
    }

    /** Given points (x1, y1), (x2, y2), and (x3, y3), return whether they could form a valid triangle in a 2-D plane. */
    public boolean pointsFormTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        double side1 = Math.pow(((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)), 0.5);
        double side2 = Math.pow(((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2)), 0.5);
        double side3 = Math.pow(((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3)), 0.5);
        return sidesCheckHelper(side1, side2, side3);
    }

    /** Given triangle side lengths side1, side2, and side3, return whether the triangle is
     * Scalene (all sides are different lengths), Isosceles (two sides are different lengths), or Equilateral (all sides are the same length).
     * You may assume that the side lengths actually form a triangle together (no need to check first). */
    public String triangleType(int side1, int side2, int side3) {
        ArrayList<String> allType = new ArrayList<>();
        allType.add("Equilateral");
        allType.add("Isosceles");
        allType.add("Scalene");
        if (side1 == side2 && side1 == side3) {
            return allType.get(0);
        }
        if (side1 != side2 && side1 != side3 && side2 != side3) {
            return allType.get(2);
        }
        return allType.get(1);
    }

    /** Given triangle leg lengths side1 and side2, return the squared hypotenuse of the triangle according to the formula
     * squaredHypotenuse = side1^2 + side2^2 */
    public int squaredHypotenuse(int side1, int side2) {
        return side1 * side1 + side2 * side2;
    }
}