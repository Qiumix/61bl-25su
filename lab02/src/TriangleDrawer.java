public class TriangleDrawer {
    private static int size = 5;

    public static void drawTriangle() {
        int row = 0;
        while (row++ < size) {
            int col = 0;
            while (col++ < row - 1) {
                System.out.print("*");
            }
            System.out.println("*");
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }
        drawTriangle();
    }
}