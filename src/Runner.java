public class Runner{
    public static void main(String[] args) {
        Sorters sorters = new Sorters();
        int[] bubbleSortedArr = sorters.bubbleSort();
        int[] mergeSortedArr = sorters.mergeSort();
        System.out.println("Original array: " + java.util.Arrays.toString(sorters.getArr()));
        System.out.println("Bubble sorted array: " + java.util.Arrays.toString(bubbleSortedArr));
        System.out.println("Merge sorted array: " + java.util.Arrays.toString(mergeSortedArr));
    }
}