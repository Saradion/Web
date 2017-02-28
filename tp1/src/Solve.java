/**
 * Created by saradion on 17/01/17.
 */
public class Solve {

    public int findMax(int[] array) {
        int index = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] > array[index]) {
                index = j;
            }
        }
        return index;
    }
}
