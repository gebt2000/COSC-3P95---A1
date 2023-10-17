import java.util.Arrays;
import java.util.Random;

public class TestCaseGenerator {
    public static void main(String[] args) {

        // this for loop generates and test multiple random cases.
        for (int i = 0; i < 10; i++) { // number of test cases is set to 10
            // generates random length array of integers.
            Random random = new Random();
            int arrayLength = random.nextInt(15) + 2; // Array length between 2 and 15.
            int[] arrayToSort = new int[arrayLength];

            // makes array with random integers
            for (int j = 0; j < arrayLength; j++) {
                arrayToSort[j] = random.nextInt(100) - 50; // Integers between -50 and 49.
            }

            // prints the original unsorted array.
            System.out.println("Random Array: " + Arrays.toString(arrayToSort));

            // sort array using the buggy sort method (ignore last element)
            int[] sortedArray = sort(arrayToSort);

            // print the sorted array.
            System.out.println("Sorted Array: " + Arrays.toString(sortedArray));

            // Validate results
            int[] expectedArray = arrayToSort.clone();
            bubbleSort(expectedArray);
            boolean isTestPassed = Arrays.equals(sortedArray, expectedArray);
            System.out.println("Test Result: " + (isTestPassed ? "PASS" : "FAIL"));
            System.out.println("--------------------------------------");
        }
    }

    // buggy sort method for testing purposes.
    public static int[] sort(int[] arrayToSort) {
        int[] sortedArray = arrayToSort.clone();

        // I intentionally ignored the last element during sorting so we can get some tests cases to fail.
        bubbleSort(sortedArray, sortedArray.length - 1);

        return sortedArray;
    }

    public static void bubbleSort(int[] array) {
        bubbleSort(array, array.length);
    }

    //bubble sort
    public static void bubbleSort(int[] array, int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}