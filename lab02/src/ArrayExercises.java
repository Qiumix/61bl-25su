import java.util.ArrayList;
import java.util.List;

public class ArrayExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
        int[] newArray = new int[6];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = i + 1;
        }
        return newArray;
        // TODO: Fill in this function.
    }

    /**
     * Returns the positive difference between the maximum element and minimum
     * element of the given array.
     * Assumes array is nonempty.
     */
    public static int findMinMax(int[] array) {
        int max = array[0];
        int minMax = array[0];
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            if (temp > minMax) {
                minMax = max;
                max = temp;
            }
        }
        return minMax;
        // TODO: Fill in this function.
    }

}
