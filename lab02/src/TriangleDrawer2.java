public class TriangleDrawer2 {
    private static int size = 5;

    public static void drawTriangle() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
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